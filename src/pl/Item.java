package pl;

public class Item implements Comparable<Item> {

	
	private String itemname;
	private String categorydetail;
	private double price;
	
	/***
	 * Public default constructor for item class 
	 */
	public Item(){
		itemname="";
		categorydetail ="";
		price = 0.0;
				
	}
	
	/***
	 * Public overloaded constructor for item class 
	 */
	public Item(String itemname, String categorydetail, double price){
		this.itemname=itemname;
		this.categorydetail =categorydetail;
		this.price = price;
	}

	
	/***
	 * public method to get the price of item
	 * @return double value of price
	 */
	public double getPrice(){
		return price;
	}
	
	/***
	 * public method to set price
	 * @param price
	 */
	public void setPrice(double price){
		this.price = price;
	}
	
	/***
	 * public method to get the category of item
	 * @return String value category
	 */
	public String getCategory(){
		return categorydetail;
	}
	
	/***
	 * public method to set category
	 * @param String value for categorydetail
	 */
	public void setCategory(String categorydetail){
		this.categorydetail = categorydetail;
	}
	
	/***
	 * public method to get the name of item
	 * @return String value of item name
	 */
	public String getItemName(){
		return itemname;
	}
	
	/***
	 * public method to set name of item
	 * @param itemname
	 */
	public void setItemName(String itemname){
		this.itemname = itemname;
	}

	/***
	 * implementing compare to function.
	 */
	@Override
	public int compareTo(Item item) {
		// TODO Auto-generated method stub
        return itemname.compareToIgnoreCase(item.itemname);
	}

	/***
	 * Public method to set item data 
	 */
	public void SetItemData(String itemname, String categorydetail, double price){
		this.itemname=itemname;
		this.categorydetail =categorydetail;
		this.price = price;
	}

	/***
	 * public method to get the detail of item
	 * @return String
	 */
	public String getItemDetail(){
		return itemname + "    " + categorydetail + "    " + String.format("%.1f", price);
	}
	
}
