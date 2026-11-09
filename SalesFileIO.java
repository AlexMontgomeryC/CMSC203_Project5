/*
 * Class: CMSC203 CRN 21410
 * Instructor: Huseyin Aygun
 * Description: (This is a utility class that provides useful array operations.)
 * Due: 11/01/2026
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Alexander Zlodorev
*/

import java.util.*;
import java.io.*;
public class SalesFileIO {
	/**
	 This method reads data from the specified file and returns the read information. 
	 @param filename The file to be read.
	 @return The data read as a double[][]
	 @throws FileNotFoundException
	 */
	public static double[][] readSalesData(String filename) throws FileNotFoundException {
		File file = new File(filename);// Creates the file reference.
		try(Scanner infile = new Scanner(file)){
			//The following statements declare the needed counters, arrays, and String reference variable.
			double[][] data = new double[3][];
			String[] tokens;
			int row =0;
			String inputString;
			do {
				inputString = infile.nextLine();// Read the data (line by line) and then split it into tokens.
				tokens = inputString.split(" ");
				//Assign each row in data to reference an array of doubles of the length of tokens.
				data[row] = new double[tokens.length];
				//The following loop initializes the newly created array.
				for(int col =0; col< tokens.length; col++) {
					data[row][col]= Double.parseDouble(tokens[col]);
				}
				//Advance the index.
				row++;
			} while(infile.hasNext());
			return data;
		}
		
		
	}
	/**
	 This method writes the summary of the data provided to the specified output file. 
	 @param filename The file name to which the data should be written to.
	 @param data The array holding the data.
	 @throws IOException
	 */
	public static void writeSummary(String filename, double[][] data) throws IOException {
		File file = new File(filename);
		
		try(PrintWriter outputF = new PrintWriter(file)){
			//The following four statements write the non-repetitive statements into the file.
			outputF.println(String.format("Total sales: %.2f",SalesDataUtility.getTotal(data)));
			outputF.println(String.format("Average sale: %.2f",SalesDataUtility.getAverage(data)));
			outputF.println(String.format("Highest sale: %.2f",SalesDataUtility.getHighestInArray(data)));
			outputF.println(String.format("Lowest sale: %.2f\n", SalesDataUtility.getLowestInArray(data)));
			//The following variable is used to store which row has lowest number of columns in the array. 
			//The program then uses this value as a control value when writing the column totals to the file.
			int lowestNumOfCols=data[0].length;
			for(int row = 0; row < data.length; row++) {
				outputF.println(String.format("Row %d total: %.2f", row, SalesDataUtility.getRowTotal(data, row)));
				lowestNumOfCols = data[row].length<lowestNumOfCols?data[row].length: lowestNumOfCols;	
			}
			outputF.println();
			//This loop writes the column totals into the file.
			for(int col =0; col<lowestNumOfCols; col++) {
				outputF.println(String.format("Column %d total: %.2f", col, SalesDataUtility.getColumnTotal(data, col)));
			}
		}
			
		
		
	}

}
