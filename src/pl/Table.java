package pl;

import java.util.Set;
import java.util.TreeSet;

public class Table {
	private int tableno;
	private boolean isReserved;
	private Set<Order> orders ;
	private double discount;

	/**
	 *  Public default constructor for Table class
	 */
	public Table(){
		setTableno(Global.getNewTableNo());
		setReserved(false);
		orders = new TreeSet<Order>();
		setDiscount(0);
	}

	/**
	 * @return the tableno
	 */
	public int getTableno() {
		return tableno;
	}

	/**
	 * @param tableno the tableno to set
	 */
	private void setTableno(int tableno) {
		this.tableno = tableno;
	}

	/**
	 * @return the isReserved
	 */
	public boolean isReserved() {
		return isReserved;
	}

	/**
	 * @param isReserved the isReserved to set
	 */
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}

	/**
	 * @return the discount
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	/**
	 *  public method to add new order in current table
	 * @param order to be added to orders treeset
	 */
	public void addOrder(Order order){
		orders.add(order);
	}
	
	/**
	 *  public method to cancel order from current table 
	 * @param order to be canceled from orders treeset
	 */
	public void cancelOrder(Order order){
		orders.remove(order);
	}
	
	/**
	 * Update table isReserved status
	 */
	public void toggleTableStatus(){
		if (isReserved == true) 
			isReserved = false;
		else
			isReserved=true;
	}
	
}
