package gui;

import io.IOClass;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import pl.AllOrders;
import pl.Allitems;
import pl.Item;
import pl.Order;
import pl.Global;
import pl.Table;

import io.IOClass;
public class Manager {


	/**
	 * Method used to start program with initialization of basic data
	 * @throws FileNotFoundException
	 */


	private AllOrders ao; 
	private IOClass io = new IOClass();
	
	public Manager() throws FileNotFoundException {
		
		//getting item details from menu file
		io.inputFromFile("MenuData.csv", "menu");
		ArrayList<Item> itemlistgl = io.getItemList();
		
		io.inputFromFile("Discount.csv", "discount");
		
		//getting order details from table data file
		io.inputFromFile("TableData.csv", "order");
		ArrayList<Order> orderlistgl = io.getOrderList();
		
		Global.al = new Allitems(itemlistgl);
		ao = new AllOrders(orderlistgl);
		Global.al.setOrderedItemList(ao);
		
		
	}
	
	public void run() throws FileNotFoundException {
		
		//generating final report for some statistics requested
		String finalreport = "";
		finalreport += Global.al.getAllItemListAccToCat();
		finalreport += ao.getMaxOrderedItem();
		finalreport += Global.al.getUnorderedItemList();
		finalreport += Global.resttables.getOccupiedTableRecords();
		finalreport += Global.resttables.getReportOfTableWithHighestBill();
		finalreport += Global.resttables.getReportOfTableWithMostOrders();

		io.writeToFile(finalreport, false);
		
		//jOption panel to get input from used 
		getJOptionPane();


		
	}
	
	/**
	 * Method used to show JOption Panel to ask for table no as input and shows the details of that table as output
	 */
	public void getJOptionPane(){
		   boolean ok = false;
			int count = 0;
			
			//will ask for the input three times
			while (!ok && count <4) {
				//Asking for input a competitor ID
				ArrayList<Table> tblist = Global.resttables.getOccupiedTableList();
				String tablelist = "";
				for(Table tb : tblist){
					tablelist +=  tb.getTableno()+"  ";
				}
				String id = JOptionPane.showInputDialog(null, "Enter Table No From The Following Occupied Tables To Check Details : \n"+tablelist);
				
				Table tb = Global.resttables.getTable(Integer.parseInt(id));
				
				
				if (tb!=null) {
					String result = tb.getOrderdItemDetails();
					System.out.println(result);
					ok = true;
				}
				else  {
					System.out.println("Incorrect id");
					if (count <= 4) {
						System.out.println("Try again");
					}
				}
			}
	}


	
}