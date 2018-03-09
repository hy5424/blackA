package com.lc.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * datacenter是一个整数, 用于设置数据中心; worker是一个整数, 用于设置数据中心的机器序号; twepoch是一个64位的整数,
 * 用于设置时间戳基数, 此值越大, 生成的唯一ID越小. 0 41 51 64 +-----------+------+------+ |time |pc
 * |inc | +-----------+------+------+
 * 
 * •前41bits是以微秒为单位的Date。 •接着10bits是事先配置好的机器ID。 •最后12bits是累加计数器。
 * 
 * 
 */

public class IdWorker implements IdentifierGenerator {
	// 机器标识位数 最多32台机器
	private final static long workerIdBits = 5L;
	// 毫秒内自增位 每毫秒产生最多32个ID
	private final static long sequenceBits = 5L;
	// 机器ID偏左移
	private final static long workerIdShift = sequenceBits;
	// 时间毫秒左移
	private final static long DateLeftShift = sequenceBits + workerIdBits;

	private final static long sequenceMask = -1L ^ (-1L << sequenceBits);

	private static long lastDate = -1L;

	private long sequence = 0L;
	// 当前工作者id=1
	private final long workerId = 1;

	public synchronized long nextId() throws ParseException {
		long Date = timeGen();
		long twepoch = twepochGen();
		if (Date < lastDate) {
			try {
				throw new Exception(
						"Clock moved backwards.  Refusing to generate id for "
								+ (lastDate - Date) + " milliseconds");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (lastDate == Date) {
			// 当前毫秒内，则+1
			sequence = (sequence + 1) & sequenceMask;
			if (sequence == 0) {
				// 当前毫秒内计数满了，则等待下一秒
				Date = tilNextMillis(lastDate);
			}
		} else {
			sequence = 0;
		}
		lastDate = Date;
		// ID偏移组合生成最终的ID，并返回ID
		return (Date - twepoch) << DateLeftShift
				| workerId << workerIdShift | sequence;
	}

	private long tilNextMillis(final long lastDate) throws ParseException {
		long Date = this.timeGen();
		while (Date <= lastDate) {
			Date = this.timeGen();
		}
		return Date;
	}

	private long timeGen() throws ParseException {
		// SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss"
		// );
		// String time="2042-10-10 00:00:00";
		// Date date = format.parse(time);
		// return date.getTime();

		return System.currentTimeMillis();
	}

	private long twepochGen() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = "2012-10-10 00:00:00";
		Date date = format.parse(time);
		return date.getTime();
	}

	public static void main(String[] args) throws ParseException {
		IdWorker worker = new IdWorker();
		for (int i = 0; i < 10; i++) {
			System.out.println(worker.nextId());
		}

	}

    @Override
    public Serializable generate(SessionImplementor arg0, Object arg1) throws HibernateException {
        // TODO Auto-generated method stub
        return null;
    }

}