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
	public void run() throws FileNotFoundException {
		
		IOClass io = new IOClass();
		
		//getting item details from menu file
		io.inputFromFile("MenuData.csv", "menu");
		Global.itemlistgl = io.getItemList();
		//getting order details from table data file
		io.inputFromFile("TableData.csv", "order");
		Global.orderlistgl = io.getOrderList();
		
		Allitems al = new Allitems();
		AllOrders ao = new AllOrders();
		
		//generating final report for some statistics requested
		String finalreport = "";
		finalreport += al.getAllItemListAccToCat();
		finalreport += ao.getMaxOrderedItem();
		finalreport += al.getUnorderedItemList();
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