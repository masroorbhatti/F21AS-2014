package gui;

import io.IOClass;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import pl.Item;
import pl.Order;
import pl.Global;

import io.IOClass;
public class Manager {


	/**
	 * Method used to start program with initialization of basic data
	 * @throws FileNotFoundException
	 */
	public void run() throws FileNotFoundException {
		
		IOClass io = new IOClass();
		io.inputFromFile("MenuData.csv", "menu");
		Global.itemlistgl = io.getItemList();
		io.inputFromFile("TableData.csv", "order");
		Global.orderlistgl = io.getOrderList();
		Global.tablellistgl = io.getTableList();
	
	}

	
	public void showGUI() {
    
		//emppty
	}

	
}