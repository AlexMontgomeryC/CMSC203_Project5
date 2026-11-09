import java.io.*;
import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SalesFileIOJUnitTestStudent {

	@Test
	public void testReadSalesDataMethod() {

		try {
			double[][] correct = {{100.50, 200.75 ,150.00},
					{80.00, 90.00},
					{220.10, 130.50,300.00,50.25}};
			double[][] got = SalesFileIO.readSalesData("salesdata.txt");
			for(int row =0; row<correct.length; row++) {
				for(int col =0; col< got[row].length; col++) {
					assertEquals(correct[row][col], got[row][col], 0.001);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testWriteSummaryMethod() {
		try(Scanner reader = new Scanner(new File("sales_summary.txt"))) {
			double [][] data = {{100.50, 200.75 ,150.00},
					{80.00, 90.00},
					{220.10, 130.50,300.00,50.25}};
			SalesFileIO.writeSummary("sales_summary.txt", data);
			String read = "";
			while(reader.hasNext()) {
				read += reader.nextLine() +"\n";
			}
			String[] readArray = read.split("\n");	
			String correct = "Total sales: 1322.10;"
					+ "Average sale: 146.90;"
					+ "Highest sale: 300.00;"
					+ "Lowest sale: 50.25;"
					+";"
					+ "Row 0 total: 451.25;"
					+ "Row 1 total: 170.00;"
					+ "Row 2 total: 700.85;"
					+";"
					+ "Column 0 total: 400.60;"
					+ "Column 1 total: 421.25"; 
			String [] correctData = correct.split(";");
			for(int row =0; row<correctData.length; row++) {
				assertEquals(correctData[row], readArray[row]);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
