package gui;
import java.io.FileNotFoundException;

import io.IOClass;
import pl.Allitems;
import pl.Item;
import pl.AllOrders;
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
		System.out.println(al.getitemslist());
		System.out.println(al.getItemwithHighestPrice());
		AllOrders ao = new AllOrders();
		System.out.println(ao.getallOrders());
		System.out.println(ao.getMaxOrderedItem());		
		System.out.println(al.getOrderedItemList());
		System.out.println(al.getUnorderedItemList());
		//Testing End -- 
		
	}

}
