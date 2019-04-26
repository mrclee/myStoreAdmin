package com.admin.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//基类抽取，将频繁用到的代码抽取到另一个类，供其他类继承
public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 使用反射解决GeneralServletTest类中if判断代码繁琐问题
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置请求与响应编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//所要转发的目标页面路径
		String path = null;
		//接收请求参数
		String action = request.getParameter("action");
		//获取当前类的字节码
		Class<? extends BaseServlet> clazz = this.getClass();
		//根据传过来的请求参数获取相应的方法
		try {
			Method method = clazz.getMethod(action, HttpServletRequest.class,HttpServletResponse.class);
			//对获取的方法进行非空判断
			//若非空，则执行该方法
			if(method!=null){
				//返回的是字符串路径
				path = (String) method.invoke(this, request,response);
				//对路径进行非空判断
				//若不空，则将请求转发到路经所在的页面
				if(path!=null){
					request.getRequestDispatcher(path).forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("请求的方法不存在！");
		}
	}
}
