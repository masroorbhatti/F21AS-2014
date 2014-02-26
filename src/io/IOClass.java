package io;
import pl.AllTables;
import pl.Allitems;
import pl.Global;
import pl.Order;
import pl.Item;
import pl.Table;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.org.apache.xpath.internal.operations.Or;

public class IOClass {

	private ArrayList<Order> orderList;
	private ArrayList<Item> itemList;
	private ArrayList<Table> tableList;

	/**
	 * Constructor initializing orderlist and itemlist
	 */
	public IOClass(){
		orderList = new ArrayList<Order>();
		itemList = new ArrayList<Item>();
		tableList = new ArrayList<Table>();

	}
	
	/**
	 * Method used to read data from TableData and MenuData file
	 * @param filename
	 * @param filetype
	 * @throws FileNotFoundException
	 */
	public void inputFromFile(String filename,String filetype) throws FileNotFoundException	{
		try {
			File f = new File(filename);
			Scanner fr = new Scanner(f);
			while (fr.hasNextLine()) {

				//read first line and process it
				String inputLine = fr.nextLine(); 
				if (inputLine.length() != 0) {//ignored if blank line
					if(filetype == "order")
						processOrder(inputLine);
					else
						processMenu(inputLine);
				}
			}
			
		}
		//if the file is not found, stop with system exit
		catch (FileNotFoundException fnf){
			throw fnf ;
		}
	}
	
	/**
	 * Method used to process each line from TabeData file
	 * @param line
	 */
	private void processOrder(String line) {
		try {
			String parts [] = line.split(",");
			int orderno = Integer.parseInt(parts[0]);
			int tableno = Integer.parseInt(parts[1]);
			String itemname = parts[2];
			int quantity = Integer.parseInt(parts[3]);
			
			Allitems ai = new Allitems();
			
			Table tmptable = Global.resttables.getTable(tableno);
			tmptable.setDiscount(3.0);
			tmptable.setReserved(true);
			tmptable.addOrder(new Order(tmptable, ai.getItemFromName(itemname),quantity ));
			Order or = new Order(tmptable,ai.getItemFromName(itemname),quantity);
			this.addOrder(or);
			
		}
	
		//this catches trying to convert a String to an integer
		catch (NumberFormatException nfe) {
			String error = "Number conversion error in '"
					+ line + "'  - " + nfe.getMessage();
			System.out.println(error);
		}
		//this catches missing items if only one or two items
		//other omissions will result in other errors
		catch (ArrayIndexOutOfBoundsException air) {
			String error = "Not enough items in  : '" + line
					+ "' index position : " + air.getMessage();
			System.out.println(error);
		}
	}
	
	/**
	 * Method used to prcoess each line from MenuData file
	 * @param line
	 */
	private void processMenu(String line) {
		try {
			String parts [] = line.split(",");
			String dishname = parts[0];
			double price = Double.parseDouble(parts[1]);
			String category = parts[2];
			
			Item it = new Item(dishname, category ,price);
			this.addItem(it);

		}
	
		//this catches trying to convert a String to an integer
		catch (NumberFormatException nfe) {
			String error = "Number conversion error in '"
					+ line + "'  - " + nfe.getMessage();
			System.out.println(error);
		}
		//this catches missing items if only one or two items
		//other omissions will result in other errors
		catch (ArrayIndexOutOfBoundsException air) {
			String error = "Not enough items in  : '" + line
					+ "' index position : " + air.getMessage();
			System.out.println(error);
		}
	}
	
	/**
	 * Method used to add order object into an Arraylist named as orderList 
	 * @param or
	 */
	public void addOrder( Order or){
		orderList.add(or);		
	}

	/**
	 * Method used to add item object into an Arraylist name as itemList 
	 * @param it
	 */
	public void addItem( Item it){
		itemList.add(it);	
	}
	
	/**
	 * Method used to add item object into an Arraylist name as itemList 
	 * @param it
	 */
	public void addTable( Table tb){
		tableList.add(tb);	
	}

	/**
	 * Method used to return itemlist
	 * @return
	 */
	public ArrayList<Item> getItemList(){
		return this.itemList;
	}
	
	/**
	 * Method used to return orderlist
	 * @return
	 */
	public ArrayList<Order> getOrderList(){
		return this.orderList;
	}
	/**
	 * Method used to return tableList
	 * @return
	 */
	public ArrayList<Table> getTableList(){
		return this.tableList;
	}


}
