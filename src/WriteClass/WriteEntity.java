package WriteClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ********************************************************
 * 
 * @ClassName: WriteEntity
 * @Description: 创建 hibernate 实体对象类
 * @author DoDo
 * @date 2012-12-26 下午06:02:04
 */
public class WriteEntity {

    ReadTable rt = new ReadTable();
    public String webHtml = "WebRoot\\WEB-INF\\jsp\\"; // 页面生成路径(WEB 里边)
    public String address = ""; // 项目绝对路径

    private String table_name = ""; // 表名
    private String entity_name = ""; // 类名
    private String locahost = ""; // java代码生成路径

    private String comments_table = ""; // 表说明
    private Map<String, String> comment_map = new LinkedHashMap<String, String>(); // 表属性明说
    private Map<String, String> datalength_map = new LinkedHashMap<String, String>(); // 表字段长度明说
    private Map<String, String[][]> hibernate_map = new LinkedHashMap<String, String[][]>(); // hibernate

    // 实体对象信息

    /**
     * ********************************************************
     * 
     * @Title: Write
     * @param table
     * @return String
     * @date 2012-12-26 下午06:02:27
     */
    @SuppressWarnings("unchecked")
    public void Write(String table) {
        table_name = table;
        ReadTable rt = new ReadTable();
        Map<String, String[][]> table_map = rt.read(table); // 表信息
        comments_table = rt.findTableComments(table); // 表说明
        comment_map = rt.findColComment(table); // 表属性明说
        datalength_map = rt.findColDataLength(table);// 表字段长度明说
        hibernate_map = getHibernate(table_map); // 数据库 实体对象信息

        String addr[] = new File(NewEntity.class.getName()).getAbsolutePath().replace("%20", " ").split("\\\\");
        address = ""; // 项目绝对路径
        for (int i = 0; i < addr.length - 1; i++) {
            address += addr[i] + "\\";
        }
        locahost = address + "src\\"; // newEntity 类 路径
        entity_name = getEntityName(); // 类名
        table_name.substring(0, 4).toUpperCase();
        entity("entity\\", "entity");
    }

    /**
     * ********************************************************
     * 
     * @Title: getHibernate
     * @Description: 获取 hibernate 属性
     * @param map
     *            table 数据
     * @return Map
     * @date 2012-12-26 下午06:03:29
     */
    public Map<String, String[][]> getHibernate(Map<String, String[][]> map) {

        Map<String, String[][]> h_map = new LinkedHashMap<String, String[][]>();

        for (Map.Entry<String, String[][]> t_m : map.entrySet()) { // hibernate
                                                                   // 属性名 和
                                                                   // 数据类型

            String[] t_name = t_m.getKey().split("_");
            String h_name = "";

            for (int i = 0; i < t_name.length; i++) {
                if (i > 0) {
                    h_name += t_name[i].substring(0, 1).toUpperCase() + t_name[i].substring(1, t_name[i].length());
                } else {
                    h_name += t_name[i].substring(0, t_name[i].length());
                }
            }
            int length = 0;
            String type = t_m.getValue()[0][0];
            if (type.equals("varchar2") || type.equals("varchar") || type.equals("nvarchar2")
                    || type.equals("nvarchar") || type.equals("char")) {
                type = "String";
            } else if (type.equals("number")) {

                if (Integer.parseInt(t_m.getValue()[0][1]) > 0) {
                    type = "Double";
                } else {
                    type = "Integer";
                }

            } else if (type.equals("int") || type.equals("integer")) {
                type = "Integer";
            } else if (type.equals("decimal")) {
                length = Integer.valueOf(t_m.getValue()[0][1]);
                if (length > 0) {
                    type = "Double";
                } else {
                    type = "Long";
                }
            } else if (type.equals("datetime")) {
                type = "Date";
            } else if (type.equals("float") || type.equals("double")) {
                type = "Double";
            }

            h_map.put(t_m.getKey(), new String[][] {{h_name, type } });

        }

        return h_map;
    }

    /**
     * ********************************************************
     * 
     * @Title: getEntityName
     * @Description: 生成对象名
     * @return String
     * @date 2012-12-27 下午03:11:19
     */
    public String getEntityName() {

        String[] t_name = table_name.toLowerCase().split("_");
        String e_name = "";
        for (int i = 0; i < t_name.length; i++) {
            e_name += t_name[i].substring(0, 1).toUpperCase() + t_name[i].substring(1, t_name[i].length());
        }

        return e_name;
    }

    /**
     * ********************************************************
     * 
     * @Title: writeEntity
     * @Description: 写入实体类
     * @param file
     *            文件路径
     * @param string
     *            写入内容
     * @date 2012-12-27 下午04:24:49
     */
    private void writeEntity(String file, String string) {
        System.out.println(file);

        try {
            FileOutputStream outs = new FileOutputStream(file, false);
            PrintStream p = new PrintStream(outs);
            p.println(string);
            p.flush();
            p.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("创建失败 ： " + file);
        }
        System.out.println("创建成功 ： " + file);
    }

    private void entity(String path, String pak) {

        StringBuffer entity_txt = new StringBuffer("\r\n"); // 要生成的信息
        String newFile = locahost + path + entity_name + ".java"; // 要生成的实体类
        entity_txt.append("package ").append(pak).append(";\r\n"); // 包名
        entity_txt.append("import java.util.Date; ").append("\r\n"); // 包名
        entity_txt.append("import javax.persistence.Column; ").append("\r\n"); // 包名
        entity_txt.append("import javax.persistence.Entity; ").append("\r\n"); // 包名
        entity_txt.append("import javax.persistence.Table; ").append("\r\n"); // 包名
        entity_txt.append("import com.bstek.dorado.annotation.PropertyDef; ").append("\r\n"); // 包名
        entity_txt.append("import com.lc.web.base.entity.BaseEntity; ").append("\r\n"); // 包名
        entity_txt.append("\r\n");

        // 表注释
        entity_txt.append("/**").append("\r\n");
        entity_txt.append("* ********************************************************").append("\r\n");
        entity_txt.append("* @ClassName: ").append(entity_name).append("\r\n");
        entity_txt.append("* @Description: ").append(comments_table).append("\r\n");
        entity_txt.append("* @author 用lcy改进版的代码自动生成器").append("\r\n");
        entity_txt.append("* @date ").append(new SimpleDateFormat("yyyy-MM-dd aa hh:mm:ss ").format(new Date()))
                .append("\r\n");
        entity_txt.append("*******************************************************").append("\r\n");
        entity_txt.append("*/").append("\r\n");
        // 开始 @Entity
//        entity_txt.append("@Entity").append("\r\n");
        entity_txt.append("@Entity(name = \"").append(table_name).append("\")\r\n");
        entity_txt.append("public class ").append(entity_name).append(" extends BaseEntity {").append("\r\n"); // 类开始
        entity_txt.append("\r\n");

        // ----------- 属性
        for (Map.Entry<String, String[][]> h_m : hibernate_map.entrySet()) {
            // 字段注解
            // @PropertyDef(label = "代理商户编号")
//            entity_txt.append("\t").append("@PropertyDef(label = \"").append(comment_map.get(h_m.getKey()))
//                    .append("\")\r\n");
            entity_txt.append("\t").append("private ").append(h_m.getValue()[0][1]).append(" ")
                    .append(h_m.getValue()[0][0]).append(";"); // 属性信息
            entity_txt.append("\t\t//").append(comment_map.get(h_m.getKey())).append("\r\n"); // 说明信息
        }

        entity_txt.append("\r\n");
        // -------------- get 和 set 方法
        for (Map.Entry<String, String[][]> h_m : hibernate_map.entrySet()) {

            String name = h_m.getValue()[0][0]; // 属性名
            String m_name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length()); // 首字母大写 属性名
            String type = h_m.getValue()[0][1]; // 数据类型
            // 获取字段注解
            String coldatalength = datalength_map.get(h_m.getKey());
            if (null == coldatalength) {
                entity_txt.append("\t").append("@Column(name = \"").append(h_m.getKey().toUpperCase()).append("\"")
                        .append(")\r\n");
            } else {
                entity_txt.append("\t").append("@Column(name = \"").append(h_m.getKey().toUpperCase())
                        .append("\", length = ").append(coldatalength).append(")\r\n");
            }
            // get方法
            entity_txt.append("\t").append("public ").append(type).append(" get").append(m_name).append("() {")
                    .append("\r\n");
            entity_txt.append("\t\t").append("return this.").append(name).append(";\r\n");
            entity_txt.append("\t").append("}").append("\r\n");
            entity_txt.append("\r\n");
            // set 方法
            entity_txt.append("\t").append("public void").append(" set").append(m_name).append("(").append(type)
                    .append(" ").append(name).append(") {").append("\r\n");
            entity_txt.append("\t\t").append("this.").append(name).append(" = ").append(name).append(";\r\n");
            entity_txt.append("\t").append("}").append("\r\n");
            entity_txt.append("\r\n");
        }
        entity_txt.append("}").append("\r\n"); // 类结束

        writeEntity(newFile, entity_txt.toString());
    }

    // 读取指定类中的java代码
    public String readFile(String fileName) {
        String output = "";

        File file = new File(fileName);

        if (file.exists()) {
            if (file.isFile()) {
                try {
                    BufferedReader input = new BufferedReader(new FileReader(file));
                    StringBuffer buffer = new StringBuffer();
                    String text;

                    while ((text = input.readLine()) != null)
                        buffer.append(text + "\r\n");
                    output = buffer.toString();
                } catch (IOException ioException) {
                    System.err.println("File Error!");
                }
            } else if (file.isDirectory()) {
                String[] dir = file.list();
                output += "Directory contents:\r\n";

                for (int i = 0; i < dir.length; i++) {
                    output += dir[i] + "\r\n";
                }
            }
        } else {
            System.err.println("Does not exist!");
        }
        return output;
    }

    /**
     * ********************************************************
     * 
     * @Title: createFile
     * @Description: 生成文件夹
     * @param file
     *            void
     * @date 2013-1-5 下午04:25:32
     */
    @SuppressWarnings("unused")
    private void createFile(String fileway) {
        File file = new File(fileway);
        file.mkdirs();
        file.mkdir();
    }

}
