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

public class SalesDataUtility {
	/**
	 This method calculates and returns the average of the passed array's values. 
	 @param data The array to be processed
	 @return Average of the values
	 */
	public static double getAverage(double[][] data) {
		int totalLength =0; //The variable to hold the total number of values in the array.
		double total = getTotal(data);// Get the total.
		for(int row =0; row<data.length; row++) {
			totalLength += data[row].length;
		}
		return total/totalLength;
		
	}
	/**
	 This method calculates the total of the values of the array passed. 
	 @param data Array of data to be processed.
	 @return Total of the array of data passed.
	 */
	public static double getTotal(double[][] data) {
		double total =0;
		for(int row =0; row<data.length; row++) {
			for(int col =0; col<data[row].length; col++) {
				total+= data[row][col];
			}
		}
		return total;
	}
	/**
	 This method calculates the total of the specified row.
	 @param data The array.
	 @param row Column number.
	 @return The total of the specified row.
	 */
	public static double getRowTotal(double[][] data, int row) {
		double rowTotal =0;
		if(row <0) {//Verify that the row is non-negative
			return rowTotal;
		}
		for(int col = 0; row<data.length&&col<data[row].length; col++) {
			rowTotal += data[row][col];
		}
		return rowTotal;
	}
	/**
	 This method calculates the total of the specified column.
	 @param data The array.
	 @param col Column number.
	 @return The total of the specified column.
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double colTotal =0;
		//Verify that the column is non-negative
		if(col <0) {
			return 0.0;
		}
		//The following loop iterates through each row, checking if this column is present in the row. 
		//If it is not present, the loop skips it. Otherwise, add the value stored at data[row][col] to colTotal.
		for(int row =0; row<data.length; row++) {
			if(data[row].length>col)
				colTotal += data[row][col];
		}
		return colTotal;
	}
	/**
	 Returns the highest value in the specified row.
	 @param data The array to be processed.
	 @param row The row to be processed.
	 @return The highest value in the specified row.
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highest =data[row][0];
		if(row<0) {//Verify that the row is non-negative
			return 0.0;
		}
		for(int col =0; row<data.length&&col<data[row].length; col++) {
			if(data[row][col] >highest) {
				highest = data[row][col];
			}
		}
		return highest;
	}
	/**
	 Returns the lowest value in the specified row.
	 @param data The array to be processed.
	 @param row The row to be processed.
	 @return The lowest value in the specified row.
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest =data[row][0];
		if(row<0) {//Verify that the row is non-negative
			return 0.0;
		}
		for(int col =0; row<data.length&&col<data[row].length; col++) {
			if(data[row][col] <lowest) {
				lowest = data[row][col];
			}
		}
		return lowest;
	}
	/**
	 Returns the highest value in the array.
	 @param data The array to be processed.
	 @param row The row to be processed.
	 @return The highest value in the array.
	 */
	public static double getHighestInArray(double[][] data) {
		double highest =data[0][0], highestInRow; //Variables used in the method
		for(int row =0; row<data.length; row++) {
			highestInRow = getHighestInRow(data, row); //Gets the highest in row, then compares that value with the current highest value.
			highest = highestInRow>highest? highestInRow: highest;
		}
		return highest;
	}
	/**
	 Returns the lowest value in the array.
	 @param data The array to be processed.
	 @param row The row to be processed.
	 @return The lowest value in the array.
	 */
	public static double getLowestInArray(double[][] data) {
		double lowest = data[0][0], lowestInRow; //Variables used in the method
		for(int row =0; row<data.length; row++) {
			lowestInRow = getLowestInRow(data, row); //Gets the lowest in row, then compares that value with the current lowest value.
			lowest = lowestInRow<lowest? lowestInRow: lowest;
		}
		
		return lowest;
	}
	
}
