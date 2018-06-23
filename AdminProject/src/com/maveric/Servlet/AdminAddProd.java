package com.maveric.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maveric.Dao.AdminLogDao;
import com.maveric.Model.AddProdModel;

public class AdminAddProd extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("You Entered into Admin Add Prod Servlet");
		
		int pid=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		double price=Double.parseDouble(request.getParameter("price"));
		
		AddProdModel apm=new AddProdModel();
		apm.setPid(pid);
		apm.setPname(pname);
		apm.setPrice(price);
		
		AdminLogDao ald=new AdminLogDao();
		int i=0;
		
		try
		{
		i=ald.addProd(apm);
		}
		catch (SQLException | ClassNotFoundException e1) 
		{			
			e1.printStackTrace();
		}
		if(i>0)
		{
			System.out.println("New record inserted into product DB");
			request.getRequestDispatcher("Admin.jsp").forward(request, response);
		}
		else
		{
			System.out.println("Record inserted into product DB");
			request.getRequestDispatcher("AddProd.jsp").forward(request, response);
		}
		System.out.println("You Exit into Admin Add Prod Servlet");
	}

}
