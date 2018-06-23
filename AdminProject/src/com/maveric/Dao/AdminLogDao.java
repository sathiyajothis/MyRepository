package com.maveric.Dao;

import java.sql.*;

import com.maveric.Model.*;

public class AdminLogDao 
{
	
	static final String driver ="com.mysql.cj.jdbc.Driver";
	static final String dburl = "jdbc:mysql://127.0.0.1:3306/mavadmin";
	static final String user = "root";
	static final String pass = "";
	
	static Connection conn = null;
	static PreparedStatement ps = null;
	  
	private static void common() throws ClassNotFoundException
	{
		try
		  {
			  //registering the Driver here
			  Class.forName(driver);			  
			  //getting the connection
			  conn=DriverManager.getConnection(dburl, user, pass);
		  }
		catch(SQLException se)
		{
			System.out.println(se.getMessage());
		}		
	}
	
	public int register(AdminRegModel model) throws SQLException, ClassNotFoundException
	{
		int i=0;
		common();
		PreparedStatement ps=conn.prepareStatement("insert into adminreg values(?,?,?,?,?)");
		ps.setInt(1, model.getEmpid());
		ps.setString(2, model.getEmpname());
		ps.setString(3, model.getDept());
		ps.setString(4, model.getDoj());
		ps.setString(5, model.getPass());
		
		i=ps.executeUpdate();
		
		return i;
	}
	
	public int login(AdminLogModel model) throws ClassNotFoundException, SQLException
	{
		int i=0;
		common();
		PreparedStatement ps=conn.prepareStatement("select * from adminreg");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			if(model.getId()==(rs.getInt("empid")) && model.getPass().equals(rs.getString("password")))
			{				
				i=1;
			}
			else
			{
				i=0;
			}
		}
		return i;
	}
	
	public int addProd(AddProdModel model) throws SQLException, ClassNotFoundException
	{
		int i=0;
		common();
		PreparedStatement ps=conn.prepareStatement("insert into product values(?,?,?)");
		ps.setInt(1, model.getPid());
		ps.setString(2,model.getPname());
		ps.setDouble(3, model.getPrice());
		
		i=ps.executeUpdate();
		
		return i;
	}
}
