package com.datastatistics.util;

/**
 * 获取Session工具类
 * @author 树朾
 * @date 2015-06-11 13:42:12 中国标准时间 
 */
public class SessionUtil {

//	/**
//	 * 获取当前登陆用户
//	 * @param request
//	 * @return
//	 */
//	public static Sysuser getUser(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		Object sysuser = session.getAttribute("sysuser");
//		if (sysuser instanceof Sysuser) {
//			return Sysuser.class.cast(sysuser);
//		}
//		return null;
//	}
//
//	/**
//	 * 存入登陆用户
//	 * @param request
//	 * @param sysuser
//	 */
//	public static void setUser(HttpServletRequest request, Sysuser sysuser) {
//		// TODO Auto-generated method stub
//		request.getSession().setAttribute("sysuser", sysuser);
//	}
}
