package gui;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import io.IOClass;
import pl.AllTables;
import pl.Allitems;
import pl.Global;
import pl.Item;
import pl.AllOrders;
import pl.Order;
import pl.Table;
public class Main {
	/**
	 * Main method
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Manager mn = new Manager();
		mn.run();
		//Testing Start --
		Allitems al = new Allitems();
		//--1System.out.println(al.getAllItemListAccToCat());
		//System.out.println(al.getItemListByCategory("Main"));
//		System.out.println(al.getItemwithHighestPrice());
		AllOrders ao = new AllOrders();
//		System.out.println(ao.getallOrders());
		//2-System.out.println(ao.getMaxOrderedItem());		
		//3-System.out.println(al.getUnorderedItemList());
//		System.out.println(al.getUnorderedItemList());
//		
		
//		AllTables at = new AllTables();
//		Table tmptable = Global.resttables.getTable(1);
//		tmptable.setReserved(true);
//		tmptable.addOrder(new Order(tmptable, al.getItemFromName("Roast Beef"),2 ));
//		tmptable.addOrder(new Order(tmptable, al.getItemFromName("Carrot Soup"),2 ));
		
		
		//ArrayList lst = Global.resttables.getTableWithMostOrders();
		
		ArrayList lst  = Global.resttables.getOccupiedTableList();
		
		
		String report  = Global.resttables.getOccupiedTableRecords();
		String report1  = Global.resttables.getReportOfTableWithHighestBill();
		String report2  = Global.resttables.getReportOfTableWithMostOrders();
		
		//4-System.out.println(report);
		//5-System.out.println(report1);
		//6-System.out.println(report2);
		
		   boolean ok = false;
			int count = 0;
			
			//will ask for the input three times
			while (!ok && count <3) {
				//Asking for input a competitor ID
				String id = JOptionPane.showInputDialog(null, "Enter Table No :");
				
				Table tb = Global.resttables.getTable(Integer.parseInt(id));
				
				if (tb!=null) {
					String result = tb.getOrderdItemDetails();
					System.out.println(result);
					ok = true;
				}
				else  {
					System.out.println("Incorrect id");
					if (count <= 3) {
						System.out.println("Try again");
					}
				}
			}

		
		
	}

}
