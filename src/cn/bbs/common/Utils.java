package cn.bbs.common;

import java.util.Date;

public class Utils {
	
	/**
	 * ��ָ������ת��Ϊ��������
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
		String hi="���Ϻ�";
		if(hours>6 && hours<9){
			hi="���Ϻ�";
		}
		if(hours>9 && hours<12){
			hi="�����";
		}
		if(hours>12 && hours<14){
			hi="�����";
		}
		if(hours>14 && hours<18){
			hi="�����";
		}
		
		return hi;
	}
}
