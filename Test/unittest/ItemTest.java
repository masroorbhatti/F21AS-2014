/**
 * 
 */
package unittest;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.Item;

/**
 * @author Doctor
 *
 */
public class ItemTest {

	/**
	 * Test method for {@link pl.Item#compareTo(pl.Item)}.
	 */
	@Test
	public void testCompareTo() {
		 Item item1 = new Item("Apple Pie","Juice", 15);  // Item 1
		 Item item2 = new Item("Orange Juice", "Juice", 9);    //Item 2 diff
		 assertEquals("should be before", -1, item1.compareTo(item2));
		 assertEquals("should be after", 1, item2.compareTo(item1));
		 Item item3 = new Item("Apple Pie","Juice", 15);  //item3 same
		 assertEquals("should be the same", 0, item1.compareTo(item3));

	}

}
