package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDate;

import org.junit.Test;

import com.test.Dto.User;
import com.test.Dto.UserOperation;

 
public class UserOperationsTest {

	 
	@Test
	public void testBillAmount()
	{
		User user = new User();
		
		user.setFirstName("manish");
		user.setFirstName("yadav");
		user.setUserType("employee");
		com.test.Dto.Period period = new com.test.Dto.Period();
		period.setStartDate("2016/10/01");
		period.setLocalDate(LocalDate.now());
		user.setPeriod(period);
		 
		float actual= UserOperation.totalBillAmount (user, 100);
		
		System.out.println("actual---"+ actual);
		
		float expected= (float) 65.0;
		 
		assertEquals(expected, actual,0.0f);
		
	}
	
	@Test
	public void getBillAmount()
	{
		User user = new User();
		user.setFirstName("manish");
		user.setFirstName("yadav");
		user.setUserType("affiliate");
		com.test.Dto.Period period = new com.test.Dto.Period();
		period.setStartDate("2016/10/01");
		period.setLocalDate(LocalDate.now());
		user.setPeriod(period);
		 
		float actual= UserOperation.totalBillAmount(user, 100);
		
		float expected= (float) 85.0;
		 
		assertEquals(expected, actual,0.0f);
		
	}
	
	@Test
	public void getGroceryDiscount()
	{
		int  expected= 45;
		assertEquals(expected, UserOperation.getGroceryDiscount(990) );
		
	}
	
	@Test
	public void getperiod()
	{
		int  expected= 2;
		assertEquals(expected,    UserOperation.getperiod("2016/10/01"));
		
	}
	
	@Test
	public void getBillAmountaffCustomer()
	{
		User user = new User();

		user.setUserType("customer");
		com.test.Dto.Period period = new com.test.Dto.Period();
		period.setStartDate("2016/10/01");
		period.setLocalDate(LocalDate.now());
		user.setPeriod(period);
		 
		float actual= UserOperation.totalBillAmount(user, 100);
		
		float expected= (float) 95.0;
		 
		assertEquals(expected, actual,0.0f);
		
	}
	
	@Test
	public void createBill() throws IOException {
		
		Path path = FileSystems.getDefault().getPath("src/Bill.txt");
	    File newFile = new File(path.toString());
	    newFile.delete();
	    boolean success = newFile.createNewFile();
	    
	    User user = new User();
		user.setFirstName("Manish");
		user.setLastName("Yadav"); 
		user.setUserType("affiliate");
		com.test.Dto.Period period = new com.test.Dto.Period();
		period.setStartDate("2016/10/01");
		period.setLocalDate(LocalDate.now());
		user.setPeriod(period);
	    
	    FileWriter writer = new FileWriter(newFile);
	    writer.write("************* Bill Details************** ");
	    writer.write("\r\n");
	    writer.write("User  :" + user.getFirstName() + "" + user.getLastName());
	    writer.write("\r\n");
	    writer.write("Role:" +user.getUserType() );
	    writer.write("\r\n");
	    writer.write("Sell Amount:" +  990);
	    writer.write("\r\n");
	    writer.write("User Discount:" + UserOperation.userWiseDiscount(user) );
	    writer.write("\r\n");
	    writer.write("Grocery Discount:" + UserOperation.getGroceryDiscount(990) );
	    writer.write("\r\n");
	    writer.write("********************************************* ");
	    writer.write("\r\n");
	    writer.write("Total Amount:" + UserOperation.totalBillAmount(user,990) );
	    writer.close();
	   
	    assertTrue(success);
	}
}
