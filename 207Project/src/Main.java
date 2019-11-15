/**
 * 207 Traveling Salesman Project.
 * 11/14/2019
 * Great Wall Algorithm
 * 
 * 
 * 
 * @author Alex
 * @author Lucas
 * 
 */

//Create Junit Tests

public class Main {

	public static void main(String[] args) {
		
		final int [][]CITIES_DISTANCES = {				//In order:
				{0, 13, 142, 225, 40, 352, 227},		//Rockville,
				{13, 0, 136, 237, 34, 363, 222},		//Silver Spring,
				{141, 135, 0, 305, 101, 432, 97},		//Philadelphia,
				{226, 237, 304, 0, 248, 133, 371},		//Pittsburgh,
				{40, 34, 106, 248, 0, 374, 192},		//Baltimore,
				{352, 364, 431, 133, 375, 0, 462},		//Cleveland,
				{228, 222, 97, 370, 188, 462, 0},		//New York City
				};
		
		
		
		
		
		
	}
	
	
	
	
	/**
	 * Calculate the total time in hours spent on the road
	 * @param distance total road distance
	 * @return total time in hours spent on the road
	 */
	public static double hoursOnRoad(double distance){
		return distance *60;
	}
	
	/**
	 * Calculate the total cost of fuel
	 * @param distance total road distance
	 * @return total cost of fuel
	 */
	public static double fuelCost(double distance){
		 return (distance/7.0) * 3.32;
	}
	
	/**
	 * Calculate truck driver’s salary
	 * @param distance total road distance
	 * @return truck driver’s salary
	 */
	public static double driversSalary(double distance){
		return (distance * 0.56) + 1200;
	}
	
	/**
	 * Calculate helper's salary
	 * @param distance total road distance
	 * @return helper's salary
	 */
	public static double helpersSalary(double distance){
		return (distance * 0.42) + 900;
	}
	
	/**
	 * Calculate the total cost of the hotel
	 * @param numCities number of cities a single delivery truck has to supply to the supermarkets
	 * @return total cost of the hotel
	 */
	public static double hotelCost(int numCities){
		return 100.0 * 2 * numCities;
	}
	
	/**
	 * Calculate the total cost of meal
	 * @param numCities number of cities a single delivery truck has to supply to the supermarkets
	 * @return total cost of meal
	 */
	public static double mealCost(int numCities){
		return 68.0 * 2 * numCities;
	}
	
	/**
	 * Calculate the cost of maintenance
	 * @param distance total road distance
	 * @return cost of maintenance
	 */
	public static double maintenanceCost(double distance){
		return 0.88 * distance;
	}
	
	/**
	 * Calculate the total cost of operating a single delivery truck on a single supply chain mission 
	 * for supplying to the supermarket stores across the seven cities.
	 * @param fuel the total cost of fuel
	 * @param dSalary truck driver’s salary
	 * @param hSalary helper's salary
	 * @param hotel total cost of the hotel
	 * @param meal total cost of meal
	 * @param maintenance cost of maintenance
	 * @return total cost of operating a single delivery truck on a single supply chain mission
	 */
	public static double totalCostTruck(double fuel, double dSalary, double hSalary, double hotel, double meal, double maintenance) {
		return fuel + dSalary + hSalary + hotel + meal + maintenance;
	}
	
	public static int totalDistance(int[][] array) {
		
		int totalDistance = 0;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				totalDistance += array[i][j];
			}
		}
		
		return totalDistance;
	}
	
	public static String cityNames() {
		return null;
	}
}
