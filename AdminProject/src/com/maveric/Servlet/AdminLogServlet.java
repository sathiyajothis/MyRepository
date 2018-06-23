package com.maveric.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.maveric.Dao.AdminLogDao;
import com.maveric.Model.AdminLogModel;

//@WebServlet("/AdminLogServlet")
public class AdminLogServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("U entered into Login Servlet");
		int j=0;
		int id=Integer.parseInt(request.getParameter("id"));
		String pass=request.getParameter("pass");
		
		AdminLogModel alm=new AdminLogModel();
		alm.setId(id);
		alm.setPass(pass);
	
		AdminLogDao ald=new AdminLogDao();
		int i=0;
		try {
            i=ald.login(alm);
			if(i>0)
			{
				System.out.println("User login successfully");
				request.getRequestDispatcher("Admin.jsp").forward(request, response);
			}
			else if(j>2)
			{
				System.out.println("Login Failed");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				j++;
			}
			else
			{
				System.out.println("Page redirected to register.jsp");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("U exit into Login Servlet");
	}

}
