/**
 * 
 */
package unittest;

import static org.junit.Assert.*;
import global.Shared;

import org.junit.Test;

import pl.*;


/**
 * Testing the different calculation used 
 * in application based on provided values in  
 * temporary class objects
 */
public class CalculationTest {

	Table tbl = new Table();  //defining table
	Order ord1;
	Order ord2;
	
	/**
	 * Constructor to initialize value for testing
	 */
	public CalculationTest(){
		
		/*
		 * Defining first order
		 */
		Item itm1 = new Item("Carrot Soup","Starter",20);
		Shared.discountlistgl.put("Starter", 10.0);
		ord1 = new Order(tbl,itm1,7);
		tbl.addOrder(ord1);

		/*
		 * Defining second order
		 */
		Item itm2 = new Item("Coffee and Mints","Drinks",7);
		Shared.discountlistgl.put("Drinks", 5.0);
		ord2 = new Order(tbl,itm2,2);
		tbl.addOrder(ord2);
	}
	
	/**
	 * Test order Discount
	 */
	@Test
	public void testDiscountCalculation()  {

	
		/**
		 * Testing order discount for item 'Carrot Soup' and 
		 * category 'Starter' , and adding discount for category 
		 * in global discount list that is 10% with item qty =7 and price = 20
		 */
		//Testing 
		 assertEquals( "Checking Order#1 Discount", 14, ord1.getOrderDiscount(),0.001);
		 

		/**
		 * Testing order discount for item 'Coffee and Mints' and 
		 * category 'Drinks' , and adding discount for category 
		 * in global discount list that is 5% with item qty =2 and price = 7
		 */
		//Testing 
		 assertEquals( "Checking Order#2 Discount", 0.70, ord2.getOrderDiscount(),0.001);
		 
		 

	}

	 /**
	  * Testing discount for complete table
	  */	
	@Test
	public void testtableDiscount(){
		 assertEquals( "Checking table Discount", 14.7, tbl.getDiscount(),0.001);
	}
	
	/**
	 * Test Order Price
	 */
	@Test
	public void testOrderPrice(){
		/**
		 * Test the price of order#1 which has 
		 * 'Carrot Soup' @ 20 and total orders are 7
		 */
		 assertEquals( "Checking order price", 140, ord1.getOrderPrice(),0.001);
	}
	
	/**
	 * Test Bill amount for table
	 */
	@Test
	public void testBillAmount(){
		/**
		 * Test the bill for the table without and with discount 
		 */
		 assertEquals( "Bill without discount", 154, tbl.getTotalBill(),0.001);
		 assertEquals( "Bill with discount (154 - 14.7)", 139.3, tbl.getTotalBillPayable(),0.001);
		 
	}

}
