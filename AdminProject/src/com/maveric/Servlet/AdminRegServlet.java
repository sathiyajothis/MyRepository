package com.maveric.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maveric.Dao.AdminLogDao;
import com.maveric.Model.AdminRegModel;
import com.maveric.Model.AdminRegService;

public class AdminRegServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("U entered into Reg Servlet");
		
		int empid=Integer.parseInt(request.getParameter("empid"));
		String empname=request.getParameter("empname");
		String dept=request.getParameter("dept");
		String doj=request.getParameter("doj");
		String pass=request.getParameter("pass");
		
		/*SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		Date dd = null;
		try {
			dd=sdf.parse(doj);
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		
		AdminRegModel arm=new AdminRegModel();
		arm.setEmpid(empid);
		arm.setEmpname(empname);
		arm.setDept(dept);
		arm.setDoj(doj);
		arm.setPass(pass);
		
		AdminRegService ars=new AdminRegService();
		boolean bln=ars.validateReg(arm);
		
		AdminLogDao ald=new AdminLogDao();
		int i=0;
		
		try 
		{
			if(bln)
			{
				try 
				{
					i=ald.register(arm);
				} 
				catch (SQLException e1) 
				{			
					e1.printStackTrace();
				}
				if(i>0)
				{
					System.out.println("New record inserted into DB");
					request.getRequestDispatcher("Login.jsp").forward(request, response);					
				}
				else
				{
					System.out.println("Record not inserted");
					request.getRequestDispatcher("Register.jsp").forward(request, response);
				}
			}
			else
			{
				request.getRequestDispatcher("Register.jsp").forward(request, response);
				throw new Exception("Enter dept and date of joining not valid!!!");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("U exit into Reg Servlet");
	}

}
