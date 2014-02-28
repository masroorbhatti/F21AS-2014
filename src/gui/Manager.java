package gui;

import global.Shared;
import io.IOClass;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import pl.*;
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
		Shared.al = new AllItems(itemlistgl);
	
		io.inputFromFile("Discount.csv", "discount");

		//getting order details from table data file
		io.inputFromFile("TableData.csv", "order");
		ArrayList<Order> orderlistgl = io.getOrderList();

		
		ao = new AllOrders(orderlistgl);
		Shared.al.setOrderedItemList(ao);
			


	}

	public void run() throws FileNotFoundException {

		//generating final report for some statistics requested
		String finalreport = "";
		finalreport += Shared.al.getAllItemListAccToCat();
		finalreport += ao.getFrequency();
		finalreport += Shared.al.getUnorderedItemList();
		finalreport += Shared.resttables.getOccupiedTableRecords();
		finalreport += Shared.resttables.getReportOfTableWithHighestBill();
		finalreport += Shared.resttables.getReportOfTableWithMostOrders();

		io.writeToFile(finalreport, false);

		//jOption panel to get input from used 
		//getJOptionPane();
		GUIClass gui = new GUIClass();
		
		gui.setVisible(true);


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
				ArrayList<Table> tblist = Shared.resttables.getOccupiedTableList();
				String tablelist = "";
				for(Table tb : tblist){
					tablelist +=  tb.getTableno()+"  ";
				}
				String id = JOptionPane.showInputDialog(null, "Enter Table No From The Following Occupied Tables To Check Details : \n"+tablelist);

				Table tb = Shared.resttables.getTable(Integer.parseInt(id));


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