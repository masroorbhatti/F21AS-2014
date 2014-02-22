package gui;

import io.IOClass;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import pl.Item;
import pl.Order;

import io.IOClass;
public class Manager {


	private ArrayList<Order> orderList;
	private ArrayList<Item> itemList;
	
	/**
	 * Method used to start program with initialization of basic data
	 * @throws FileNotFoundException
	 */
	public void run() throws FileNotFoundException {
		
		IOClass io = new IOClass();
		io.inputFromFile("MenuData.csv", "menu");
		io.inputFromFile("TableData.csv", "order");
		this.itemList = io.getItemList();
		this.orderList = io.getOrderList();
	
	}

	
	public void showGUI() {
    
		//emppty
	}

	
}