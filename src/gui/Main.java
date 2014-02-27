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
	}

}
