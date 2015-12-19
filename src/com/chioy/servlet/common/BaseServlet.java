package com.chioy.servlet.common;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");
		if(methodName == null || methodName.trim().isEmpty()){
			throw new RuntimeException("您还没有传入方法参数！");
		}
		Class c = this.getClass();
		Method method = null;
		
		try {
			method = c.getMethod(methodName,
					HttpServletRequest.class,HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("您调用的："+methodName+"，方法没有找到！");
		}
		
		
		try {
			String result = (String) method.invoke(this, request,response);
			
			if(result==null||result.trim().isEmpty()){
				return ;
			}
			
			if(result.contains(":")){
				int index = result.indexOf(":");
				String s = result.substring(0,index);
				String path = result.substring(index+1);
				if(s.equalsIgnoreCase("f")){
					request.getRequestDispatcher(path).forward(request, response);
				}else if(s.equalsIgnoreCase("r")){
					response.sendRedirect(request.getContextPath()+path);
				}else{
					throw new RuntimeException("您指定的操做：" + s + ",当前版本不支持");
				}
			}else {//不包含冒号
				request.getRequestDispatcher(result).forward(request, response);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("您调用的方法内部出现了异常！");
		} 
		
	}
	
}
