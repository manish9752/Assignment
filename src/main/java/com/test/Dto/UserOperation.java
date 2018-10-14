package com.test.Dto;

import java.io.File;
import java.time.LocalDate;
import java.time.Period;

public class UserOperation {

	
	
	public static float userWiseDiscount(User user) {

		float returnVaue = 0;
		
		 
		try {
			if (user.getUserType() != null && user.getUserType().equalsIgnoreCase(UserConstant.EMPLOYEE)) {
				returnVaue = Integer.parseInt(UserConstant.EmployeeDiscount);
			}

			else if (user.getUserType() != null && user.getUserType().equalsIgnoreCase(UserConstant.AFFILIATE)) {
				returnVaue = Integer.parseInt(UserConstant.affiliateDiscount);
			}

			else if (user.getUserType() != null && user.getUserType().equalsIgnoreCase(UserConstant.CUSTOMER)
					&& getperiod(user.getPeriod().getStartDate()) > 2) {

				returnVaue = Integer.parseInt(UserConstant.customerDiscount);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return returnVaue;

	}

	public static int getGroceryDiscount(int sellamount) {

		int returnValue = 0;
		try {
			if (sellamount >= 100) {
				int temp = sellamount / 100;
				returnValue = (temp * 5);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return returnValue;
	}

	public static int getperiod(String date) {

		Period diff = null;
		try {
			LocalDate endofCentury = LocalDate.of(Integer.parseInt(date.split("/")[0]),
					Integer.parseInt(date.split("/")[1]), Integer.parseInt(date.split("/")[2]));
			LocalDate now = LocalDate.now();
			diff = Period.between(endofCentury, now);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return diff.getYears();
	}

	public static float getuserDiscount(User user, int markedPrice) {
		float total = 0;
		try {
			total= (markedPrice * userWiseDiscount(user)) / 100;
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return total;
	}

	public static float DiscountAmount(User user, int sellAmount) {
		float returnValue = 0;
		try {
			if (getuserDiscount(user, sellAmount) > getGroceryDiscount(sellAmount)) {
				returnValue = getuserDiscount(user, sellAmount) + getGroceryDiscount(sellAmount);
			} else {
				returnValue = getGroceryDiscount(sellAmount) + getuserDiscount(user, sellAmount);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return returnValue;
	}

	
	
	public static float totalBillAmount(User user, int sellAmount) {
		float returnValue = 0;
		try {
			returnValue=sellAmount-DiscountAmount(user, sellAmount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return returnValue;
	}
	
	
	/*public static void main(String[] args) {

		 
		

		User user = new User();

		user.setUserType("affiliate");
		com.test.Dto.Period period = new com.test.Dto.Period();
		period.setStartDate("2016/10/01");
		period.setLocalDate(LocalDate.now());
		user.setPeriod(period);
		 System.out.println(userWiseDiscount(user));
		 
		 System.out.println(getGroceryDiscount(990));
		 
		 System.out.println("--"+getuserDiscount(user, 990));
		 
		 
		 System.out.println(totalBillAmount(user, 990));
	}*/

}
