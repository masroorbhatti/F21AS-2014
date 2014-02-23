package pl;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

import pl.Order;
import pl.AllOrders;
public class Allitems  {
	private TreeSet <Item> allitems;    	// TreeSet for storing allitems
	Iterator<Item> itemsIterator;			//Iterator used to iterator through the treeset 
	private Item selectedItem;

	private HashSet<String> unorderditems;	// HashSet Storing value of unordered items
	private HashSet<String> orderditems;	// HashSet Storing value of ordered Items
	/***
	 * Constructor 
	 */

	public Allitems() {		

		allitems = new TreeSet<Item>(Global.itemlistgl);
		itemsIterator = allitems.iterator();

	}  


	/***
	 * 	Method to getItemList			
	 * @return
	 */
	public String getitemslist(){

		String report="";	
		report += ("----------------------------MAIN MENU--------------------------");
		while(itemsIterator.hasNext()){
			Item o1 =  (Item) ((Iterator<Item>) itemsIterator).next();
			report += System.lineSeparator();
			report += String.format("%19s",o1.getItemName());
			report += String.format("%19s",o1.getCategory());
			report += String.format("%19s",o1.getPrice());

		}
		return report;

	}
	/***
	 *  Method to get Item With Highest Price
	 * @return
	 */
	public double getItemwithHighestPrice(){
		double max = Double.MIN_VALUE;
		for (Item it : Global.itemlistgl) {
			double os = it.getPrice();
			if (os> max) 
			{
				max= os;

			}
		}	
		return max ;

	}
	/***
	 * 			
	 * public Method to fetch item by itemname
	 * @return
	 */
	public Boolean getItemFromName(String itemname){

		for(Item it : allitems){
			if(it.getItemName().equals(itemname)){
				this.selectedItem = it;
				return true;
			}
		}
		return false;

	}

	/***
	 * 		public method to return seleceteditem from the items category
	 * @return
	 */
	public Item getSelectedItem()
	{
		return this.selectedItem;
	}
	/***
	 * 	public method to return ordered items
	 * @return
	 */
	public String getOrderedItemList(){
		String report="";
		report +=("------Ordered Items---------\n");
		orderditems = new HashSet<String>();
		for(Item it : Global.itemlistgl){
			for(Order or : Global.orderlistgl){
				if(it.getItemName().equals(or.getItem().getItemName())){
					orderditems.add(it.getItemName());


					//System.out.println(it.getItemName() + "\n");
				}

			}
		}
		for(String vl : orderditems){
			report +=(vl + "\n");

		}

		return report;

	}
	/***
	 * 	Public method to return unordered items
	 * @return
	 */
	public String getUnorderedItemList(){
		String report="";
		report +=("------UnOrdered Items---------\n");
		unorderditems = new HashSet<String>();
		for(Item it : Global.itemlistgl){
			if(!orderditems.contains(it.getItemName())){
				unorderditems.add(it.getItemName());
			}
		}
		for(String vl : unorderditems){
			report +=(vl + "\n");

		}
		return report;

	}

}
