package pl;

public class Global {
public static int tableno;
public static int orderno;

	public static int getTableNo(){
		return tableno;
	}
	
	public static int getOrderNo(){
		return orderno;
	}
	
	public static int getNewOrderNo(){
		return orderno++;
	}
	
	public static int getNewTableNo(){
		return tableno++;
	}
	
}
