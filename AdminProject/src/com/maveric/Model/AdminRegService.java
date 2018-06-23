package com.maveric.Model;

public class AdminRegService 
{

	public boolean validateReg(AdminRegModel model)
	{
		boolean bln=false;
		if(model.getDept().equalsIgnoreCase("admin"))
		{
			bln=true;
		}
		else
		{
			bln=false;
		}
		return bln;
	}
}
