package com.lc.common.util;

public class CodeConverter {

	
	// ASCII字符串转16进制字符串
	public static String ascStringToHex(String str) {
		char[] chars = str.toCharArray();
		StringBuffer hex = new StringBuffer();
		for(int i = 0; i < chars.length; i++){
		    hex.append(Integer.toHexString((int)chars[i]));
		  }
		return hex.toString().toUpperCase();

	}
	
	//16进制字符串转ASCII字符串
	public static String hexStringToAsc(String hex) {

		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		// 49204c6f7665204a617661 split into two characters 49, 20, 4c...
		for (int i = 0; i < hex.length() - 1; i += 2) {
			// grab the hex in pairs
			String output = hex.substring(i, (i + 2));
			// convert hex to decimal
			int decimal = Integer.parseInt(output, 16);
			// convert the decimal to character
			sb.append((char) decimal);
			temp.append(decimal);
		}

		return sb.toString();

	}


	//2进制字符串 转 16进制字符串
	public static String binaryString2hexString(String bString) {
		if (bString == null || bString.equals("") || bString.length() % 8 != 0)
			return null;
		StringBuffer tmp = new StringBuffer();
		int iTmp = 0;
		for (int i = 0; i < bString.length(); i += 4) {
			iTmp = 0;
			for (int j = 0; j < 4; j++) {
				iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);
			}
			tmp.append(Integer.toHexString(iTmp));
		}
		return tmp.toString().toUpperCase();
	}

	//16进制转2进制字符串
	public static String hexString2binaryString(String hexString)
	{
		if (hexString == null || hexString.length() % 2 != 0)
			return null;
		String bString = "", tmp;
		for (int i = 0; i < hexString.length(); i++)
		{
			tmp = "0000"
					+ Integer.toBinaryString(Integer.parseInt(hexString
							.substring(i, i + 1), 16));
			bString += tmp.substring(tmp.length() - 4);
		}
		return bString;
	}
	
	/**
     * @函数功能: 10进制串转为BCD码
     * @输入参数: 10进制串
     * @输出结果: BCD码
     */
    public static byte[] str2Bcd(String asc) {

        // 原数据的长度
        int len = asc.length();
        int mod = len % 2;

        if (mod != 0) {
            asc = asc + "0";
            len = asc.length();
        }

        // 原数据
        byte bOriginalData[] = new byte[len];
        if (len >= 2) {
            len = len / 2;
        }

        // 将字符串数据转换成字节数据
        bOriginalData = asc.getBytes();

        // 转换后的BCD码
        byte bBCD[] = new byte[len];

        int sH, sL;

        for (int p = 0; p < asc.length()/2; p++) {

            if ( (bOriginalData[2 * p] >= 'a') && (bOriginalData[2 * p] <= 'f')) {
                sH = bOriginalData[2 * p] - 'a' + 10;
            } else if ((bOriginalData[2 * p] >= 'A') && (bOriginalData[2 * p] <= 'F')) {
                sH = bOriginalData[2 * p] - 'A' + 10;
            } else {
                sH = bOriginalData[2 * p] & 0x0f;
            }

            if ( (bOriginalData[2 * p + 1] >= 'a') && (bOriginalData[2 * p + 1] <= 'f')) {
                sL = bOriginalData[2 * p + 1] - 'a' + 10;
            } else if ((bOriginalData[2 * p + 1] >= 'A') && (bOriginalData[2 * p + 1] <= 'F')) {
                sL = bOriginalData[2 * p + 1] - 'A' + 10;
            } else {
                sL = bOriginalData[2 * p + 1] & 0x0f;
            }

            bBCD[p] = (byte)((sH << 4) + sL);
        }
        return bBCD;
    }

    /**
     * @函数功能: BCD码串转化为字符串
     * @输入参数: BCD码
     * @输出结果: 10进制串
     */
    public static String bcd2Str(byte[] bytes) {
        char temp[] = new char[bytes.length*2], val;

        for(int i = 0; i < bytes.length; i++){
            val = (char)(((bytes[i]& 0xf0) >> 4)&0x0f);
            temp[i * 2] = (char)(val > 9 ? val + 'A' - 10 : val + '0');

            val = (char)(bytes[i]& 0x0f);
            temp[i * 2 + 1] = (char)(val > 9 ? val + 'A' - 10 : val + '0');
        }
        return new String(temp);
    }
    
    /**
	 * 计算报文长度
	 */
	public static String calcMsgLength(String msg) throws Exception {
		Integer length = msg.length() / 2;
		String hexLength = Integer.toHexString(length);
		Integer hexValLength = hexLength.length();
		for(int i = 0 ; i < 4 - hexValLength ; i++) {
			hexLength = "0" + hexLength;
		}
		return hexLength;
	}

		
	
	public static void main(String[] args) {
		System.out.println(ascStringToHex("930E20141010"));
	}



	



}
