package pl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
public class AllOrders {
	private TreeMap<Integer ,Order> allorders;		// TreeMap For storing All Orders
	Iterator<Integer> ordersIterator;				// Iterator for iterating thorugh TreeMAp
	private HashSet<String> maxItems;		
	private TreeMap<String ,Integer> maxorders;
	/***
	 * Constructor
	 */
	public AllOrders(){
		allorders = new TreeMap<Integer,Order>();
		int c=1;
		for(Order o : Global.orderlistgl){
			allorders.put(c, o);
			c++;
		}
	}
	/**
	 *  Public method returning  list of allorders
	 * @return String value
	 */
	public String getallOrders(){
		String report="";
		report += ("-------------------------------All Ordered Items--------------------------\n");
		report += ("Table No 	Item Name		Quantity	   Price	\n");
		ordersIterator = allorders.keySet().iterator();
		while (ordersIterator.hasNext()){
			Integer orderno = ordersIterator.next();

			report += String.format("%5s",allorders.get(orderno).getTable().getTableno()+"");
			report += String.format("%20s",allorders.get(orderno).getItem().getItemName()+"");
			report += String.format("%20s",allorders.get(orderno).getQty()+ "");
			report += String.format("%20s",allorders.get(orderno).getOrderPrice()+"");
			report += ("\n");
		}

		return report;
	}
	/***
	 * 	public method to get maxiumum ordered item
	 * @return
	 */
	public String getMaxOrderedItem(){

		maxorders = new TreeMap<String,Integer>();
		
		int repeat = 0;
		String report="";
		report +=("------Max Ordered Item ---------\n");
		maxItems = new HashSet<String>();
		for(Order or : Global.orderlistgl){	
			for(Item it : Global.itemlistgl){
				if(or.getItem().getItemName().equals(it.getItemName())){
					for(String s : maxorders.keySet()){
						if(it.getItemName() == s){
							int currentcount = maxorders.get(it.getItemName());
							int newcount = currentcount + 1;
							maxorders.put(it.getItemName(), newcount);
							repeat = 1;
						}
					}
					if(repeat == 0){
						maxorders.put(it.getItemName(), 1);
						
					}
					else
						repeat = 0;
					
				}
			}
		}
		report += "Item Name                   Order Count\n\n";
		for (Entry<String, Integer> entry : maxorders.entrySet()) {
		     report += entry.getKey() + "                   " +entry.getValue() + "\n";
		}

		return report;
	}

}

