import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SalesDataUtilityJUnitTestStudent {
	private double[][] sample = {
	        {1100.0, 20.0, 3.0},
	        {506, 75.0, 78.0, 67.0},
	        {467.0, 69}
	    };
	@Test
	public void testGetTotal() {
        double total=0;
		try {
			total = SalesDataUtility.getTotal(sample);
		} catch (Exception e) {
			e.printStackTrace();
		}
        assertEquals(2385, total, 0.001);
    }
	@Test
    public void testGetAverage() {
        double avg = SalesDataUtility.getAverage(sample);
        assertEquals(265.0, avg, 0.001);
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(1123.0, SalesDataUtility.getRowTotal(sample, 0), 0.001);
        assertEquals(726.0, SalesDataUtility.getRowTotal(sample, 1), 0.001);
        assertEquals(536.0, SalesDataUtility.getRowTotal(sample, 2), 0.001);
    }

   @Test
    public void testGetColumnTotal() {
        assertEquals(2073.0, SalesDataUtility.getColumnTotal(sample, 0), 0.001); 
        assertEquals(164.0, SalesDataUtility.getColumnTotal(sample, 1), 0.001); 
        assertEquals(81.0, SalesDataUtility.getColumnTotal(sample, 2), 0.001);
        assertEquals(67, SalesDataUtility.getColumnTotal(sample, 3), 0.001);
    }

    @Test
    public void testHighestArray() {
        assertEquals(1100.0, SalesDataUtility.getHighestInArray(sample), 0.001); 
    }
    @Test
    public void testLowestArray() {
    	assertEquals(3.0, SalesDataUtility.getLowestInArray(sample), 0.001);
    }
    @Test
    public void testLowestRow() {
    	assertEquals(3.0, SalesDataUtility.getLowestInRow(sample, 0), 0.001);
    	assertEquals(67.0, SalesDataUtility.getLowestInRow(sample, 1), 0.001);
    	assertEquals(69.0, SalesDataUtility.getLowestInRow(sample, 2), 0.001);
    }
    @Test
    public void testHighestRow() {
    	assertEquals(1100.0, SalesDataUtility.getHighestInRow(sample, 0), 0.001);
    	assertEquals(506.0, SalesDataUtility.getHighestInRow(sample, 1), 0.001);
    	assertEquals(467.0, SalesDataUtility.getHighestInRow(sample, 2), 0.001);
    }
}
