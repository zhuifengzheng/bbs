package cn.bbs.common;

import java.util.Date;

public class Utils {
	
	/**
	 * 将指定数据转换为整数类型
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static int convetToInt(Object obj,int defaultValue){
		if(obj == null){
			return defaultValue;
		}else{
			try{
				return Integer.parseInt(obj.toString());
			}catch (Exception e) {
				return defaultValue;
			}
		}
	}
	
	public static String getHello(){
		Date date=new Date();
		int hours = date.getHours();
		String hi="晚上好";
		if(hours>6 && hours<9){
			hi="早上好";
		}
		if(hours>9 && hours<12){
			hi="上午好";
		}
		if(hours>12 && hours<14){
			hi="中午好";
		}
		if(hours>14 && hours<18){
			hi="下午好";
		}
		
		return hi;
	}
}
