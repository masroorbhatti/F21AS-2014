package pl;

public class Order implements Comparable<Order> {

	private int ordernumber;
	private Table table;
	private Item item;
	private int qty;
	
	
	/***
	 * Public constructor for Order class 
	 */	
	public Order(Table table, Item item, int qty){
		setOrdernumber(Global.getNewOrderNo());
		setTable(table); 
		setItem(item);
		setQty(qty);
	}

	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}

	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * 
	 * @param itemname for creating item
	 * @param categorydetail for creating item
	 * @param price for creating item
	 */
	public void setItem(String itemname, String categorydetail, double price) {
		this.item = new Item(itemname, categorydetail, price);
	}
	
	/**
	 * @return the table
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(Table table) {
		this.table = table;
	}

	/**
	 * @return the ordernumber
	 */
	public int getOrdernumber() {
		return ordernumber;
	}

	/**
	 * @param ordernumber the ordernumber to set
	 */
	private void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
	}
	
	/***
	 * implementing compare to function.
	 */
	@Override
	public int compareTo(Order order) {
		
		int retval=0;
		if (this.ordernumber > order.ordernumber) retval=1;
		else if (this.ordernumber < order.ordernumber) retval=-1;
		else retval=0;
		
        return retval;
	}
}
