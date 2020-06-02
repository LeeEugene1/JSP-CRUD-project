package kr.or.ddit.utiles;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.SIPUSH;

public class TimeSteampToStringConvert {
	public static String convert(Object target){
		Date date = new Date(((Timestamp)target).getTime());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		return dateFormat.format(date);
	}
}
