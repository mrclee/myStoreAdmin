package com.admin.web;

import com.admin.domain.Admin;
import com.admin.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AdminServlet")
public class AdminServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 退出登录方法
	 * @param request
	 * @param response
	 * @return String
	 * @throws ServletException
	 * @throws IOException
	 */
	public String exitLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ctx = request.getContextPath();
		//System.out.println("exitLogin");
		//获取session域对象，将admin从域对象中移除
		HttpSession adminSession = request.getSession();
		//System.out.println(adminSession);
		if(adminSession!=null){
			adminSession.removeAttribute("admin");
			response.getWriter().print("感谢您的光临，再见！");
			response.setHeader("refresh", "3;url="+ctx+"/admin/admin_login.jsp");
			//return "admin/admin_login.jsp";
		}
		return null;
	}

	/**
	 * 登录方法
	 * @param request
	 * @param response
	 * @return String
	 * @throws ServletException
	 * @throws IOException
	 */
	public String login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			Admin admin = new AdminService().login(username,password);
			//获取session域对象，将admin保存到域对象中
			HttpSession adminSession = request.getSession();
			adminSession.setAttribute("admin", admin);
			//登录成功，页面重定向到首页
			response.sendRedirect("admin/admin_index.jsp");
		}catch (Exception e) {
			//登录失败
			//若失败原因是我自己抛出的异常信息，跳回到登录页面，回显错误信息
			if(e.getMessage().equals("用户名不能为空！")){
				request.setAttribute("errorMessage", e.getMessage());
			}else if(e.getMessage().equals("密码不能为空！")){
				request.setAttribute("errorMessage", e.getMessage());
			}else if(e.getMessage().equals("用户名或密码错误！")){
				request.setAttribute("errorMessage", e.getMessage());
			}else{
				//否则输出其他异常堆栈信息
				e.printStackTrace();
			}
			return "admin/admin_login.jsp";
		}	
		return null;
	}


	/**
	 * 注册方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void regist(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//获取表单参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			//调用服务层注册方法
			boolean result = new AdminService().regist(username, password);
			if(result){
				response.getWriter().write("注册成功，页面跳转中……");
				response.setHeader("refresh", "3;url=/myStoreAdmin_war_exploded/admin/admin_login.jsp");
			}else{
				response.getWriter().write("注册失败，请重新注册！");
				response.setHeader("refresh", "3;url=/myStoreAdmin_war_exploded/admin/admin_regist.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
