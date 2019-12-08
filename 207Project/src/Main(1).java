import java.util.ArrayList;
import java.util.Scanner;

/**
 * 207 Traveling Salesman Project.
 * 11/14/2019
 * Pears Algorithm
 * 
 * 
 * @author Alex Juan
 * @author Lucas Balangero
 * 
 */
public class Main {

	public static void main(String[] args) {
		String[] cityNames = {"Rockville","Silver Spring","Philadelphia","PittsBurgh","Baltimore","Cleveland","New York City"};
		
		final int [][]CITIES_DISTANCES = {					//In order:
				// 0    1    2    3    4    5    6
				{  0,  13, 142, 225,  40, 352, 227},		//0			Rockville,
				{ 13,   0, 136, 237,  34, 363, 222},		//1			Silver Spring,
				{141, 135,   0, 305, 101, 432,  97},		//2			Philadelphia,
				{226, 237, 304,   0, 248, 133, 371},		//3			Pittsburgh,
				{ 40,  34, 106, 248,   0, 374, 192},		//4			Baltimore,
				{352, 364, 431, 133, 375,   0, 462},		//5			Cleveland,
				{228, 222,  97, 370, 188, 462,   0},		//6			New York City
		};
		
		
		ArrayList<Integer> cityPath = new ArrayList<Integer>();
		
		int[] list = {0,1,2,3,4,5,6};
		cityPath = connectCityPath(pairedCities(list, CITIES_DISTANCES), CITIES_DISTANCES);
		//printCities(cityPath, cityNames);
		
		/*
			//Test Case 2: 5 cities!!!!!!!
			int [][]CITY2DISTANCES = {
					// 0    1    2    3    4
					{  0,  13, 142, 225,  40},		//0			Rockville,
					{ 13,   0, 136, 237,  34},		//1			Silver Spring,
					{141, 135,   0, 305, 101},		//2			Philadelphia,
					{226, 237, 304,   0, 248},		//3			Pittsburgh,
					{ 40,  34, 106, 248,   0},		//4			Baltimore,	
			};
			
			int[] test2List = {0,1,2,3,4};
			cityPath = connectCityPath(pairedCities(test2List, CITY2DISTANCES), CITY2DISTANCES);
		*/
		
		/*
			//Test Case 3: 3 cities!!!!!!!
			int [][]CITY3DISTANCES = {
					// 0    1    2
					{  0,  13, 142},		//0			Rockville,
					{ 13,   0, 136},		//1			Silver Spring,
					{141, 135,   0},		//2			Philadelphia,	
			};
			
			int[] test3List = {0,1,2};
			cityPath = connectCityPath(pairedCities(test3List, CITY3DISTANCES), CITY3DISTANCES);
		*/
		
		/*
			//Test Case 4: 4 cities!!!!!!!
			int [][]CITY4DISTANCES = {
					// 0    1    2    3
					{  0,  13, 142, 225},		//0			Rockville,
					{ 13,   0, 136, 237},		//1			Silver Spring,
					{141, 135,   0, 305},		//2			Philadelphia,
					{226, 237, 304,   0},		//3			Pittsburgh,
			};
			
			int[] test4List = {0,1,2,3};
			cityPath = connectCityPath(pairedCities(test4List, CITY4DISTANCES), CITY4DISTANCES);
		*/
		
		
		
		//User Interface
		Scanner input = new Scanner(System.in);
		int userCityNum;
		int [][]distance;
		
		System.out.println("How many cities are there?");
		userCityNum = input.nextInt();
		distance = new int[userCityNum][userCityNum];
		int []userList = new int[userCityNum];
		
		
		for(int i = 0; i < userCityNum; i++) {
			userList[i] = i;
			
			for(int j = 0; j < userCityNum; j++) {		
				
				if(i == j) {
					distance[i][j] = 0;
				}
				else {
					System.out.print("Enter the distance from city " +(i+1) +" to " +(j+1) +": ");
					distance[i][j] = input.nextInt();
				}
				
			}
			System.out.println();
		}
		
		input.close();
		cityPath = connectCityPath(pairedCities(userList,distance),distance);
		
		
		
		//Calculate the total Distance
		int total_Distance = totalDistance(cityPath, CITIES_DISTANCES);
		double roadHours = hoursOnRoad(total_Distance);
		double fuel_Cost = fuelCost(total_Distance);
		double driver_Salary = driversSalary(total_Distance);
		double helper_Salary = helpersSalary(total_Distance);
		double hotel_Cost = hotelCost(userCityNum);
		double meal_Cost = mealCost(userCityNum);
		double maintenance_Cost = maintenanceCost(total_Distance);
		double total_Cost = totalCostTruck(fuel_Cost, driver_Salary, helper_Salary, hotel_Cost, meal_Cost, maintenance_Cost);
		
		//Print the total distance traveled
		System.out.println("Total Distance traveled: " +total_Distance);
		
		System.out.println("The city are traveled in the following order: ");
		cityNames(cityPath, cityNames);
		//printCities(cityPath, cityNames);
		
	}
	
	
	
	private static ArrayList<Integer> pairedCities(int[] city, int[][] cityD) {
		ArrayList<Integer> pair = new ArrayList<Integer>();		
		
		int shortest, shortestIdx;
		for(int i = 0; i < city.length; i++) {
			if(city[i] == -1) {
				continue;
			}
			
			shortest = cityD[city[i]][0];
			shortestIdx = i;
			
			
			if(cityD[city[i]][0] == 0) {
				shortest = cityD[city[i]][1];
				shortestIdx = 1;
			}
			
			for(int j = 1; j < city.length; j++) {
				if(city[j] == -1) {
					continue;
				}
				if(cityD[i][j] < shortest && cityD[i][j] != 0) {
					shortest = cityD[city[i]][j];
					shortestIdx = j;
					
				}
				
			}
			
			pair.add(i);
			if(i != shortestIdx) {
				pair.add(shortestIdx);
				System.out.println(city[i] +" is paired with " +shortestIdx);
			}
			else {
				if((city.length - 1)%2 == 0)		//If city has lone pair
					System.out.println(city[i] +" is paired with " +shortestIdx +" due to LONE PAIR");
				else
					System.out.println(city[i] +" is paired with " +shortestIdx +" due to it is the shortest, BUT NOT LONE PAIR");
			}
			
			city[i] = -1;
			city[shortestIdx] = -1;
			
		}
		
		System.out.println(pair);
		System.out.println();
		
		//citiesPaired = printCities(pair);
		
		return pair;
	}
	
	public static void printCities(ArrayList<Integer> pList, String[] cNames){
		
		for(int i = 0; i < pList.size(); i++) {
			if(i%2 == 0) {
				if(pList.size()-1 == i) {
					System.out.println(cNames[pList.get(i)] +" is a lone pair");
				}
				else {
					System.out.print(cNames[pList.get(i)] +" is paried with ");
				}
			}
			else {
				System.out.println(cNames[pList.get(i)]);
			}
		}
		
	}
	
	/**
	 * Create Pairs instances for each city pair, and compare the distances of pairs, find the smallest, and save into array.
	 * @param pair the adjacent element in the list is a pair. Example: {0,1,2,6,4}, 0 and 1 is a pair, 2 and 6 is a pair, and 4 is a lone pair.
	 * @param cityDistance the distances from each city
	 * @return the pathway for deliver truck to follow
	 */
	public static ArrayList<Integer> connectCityPath(ArrayList<Integer> pair, int[][] cityDistance){
	
		ArrayList<Integer> returnPath = new ArrayList<Integer>();
		//int size = pair.size();
		boolean hasLonePair =false;
		ArrayList<Pairs> pairsArray = new ArrayList<Pairs>();
		Pairs smallest;
		int currentCity,smallestInd;
		
		//Checks if there is a lone pair
		if (pair.size()%2!=0) {
			//size --;								//Prevent loop from cycling into the lone pair
			hasLonePair = true;						//Keep track that there is a lone pair
		}
		
		
		//Pair fPair = new Pair()
		for(int i=0; i < pair.size(); i+=2) {
			//pair.add(i);
			if(pair.size()-1 == i) {
				pairsArray.add(new Pairs(pair.get(i), -1, 0));				//Adding lone pair
			}
			else {
				Pairs newPair = new Pairs(pair.get(i), pair.get(i+1), getCityDistance(cityDistance, pair.get(i), pair.get(i+1)));
				pairsArray.add(newPair);
			}
		}
		
		
		
		System.out.println("Pairs: "+pair);
		System.out.println("pairsArray:"+pairsArray);
		
		//Adds first pair directly to the return array
			returnPath.add(pairsArray.get(0).getCityA());			//Adding the first city
			returnPath.add(pairsArray.get(0).getCityB());			//Adding the city that is in the same pair
			pairsArray.remove(0);
			
			
		int pairSize = pairsArray.size();
		//Runs for the length of the pairs array
		for(int i = 0; i < pairSize;i++) {
			
			//Sets standard small element to compare later ones to
			smallest=pairsArray.get(0);
			smallestInd=0;
			
			
			//Cycles through the current pair array ( constantly removing from this array)
			for (int j = 1;j < pairsArray.size(); j++) {
				if(pairsArray.get(j).getCityDistance()<smallest.getCityDistance() && pairsArray.get(j).getCityDistance() != 0) {
					smallest=pairsArray.get(i); //keeps track of smallest pair object
					smallestInd=j; //keeps track of smallest pair object index
				}
			}
			currentCity = returnPath.get(returnPath.size()-1); //The last element from the return array
		
			//Distance from last element of reuturnPath array to comparing cities
			int distanceToCityA = 0;
			int distanceToCityB = 0;
			int distanceToLonePair = 0;
			
			//Test the distances with the lone pair's distance to last city added to the return array
			if (hasLonePair) {
				if(pairsArray.size() != 1) {
					
					distanceToLonePair = cityDistance[currentCity][pair.get(pair.size()-1)];			//Distance from last element of reuturnPath array to lone pair
					distanceToCityA = getCityDistance(cityDistance, currentCity, smallest.getCityA());	//Distance from last element of reuturnPath array to smallest cityA
					if(smallest.getCityB() != -1)
						distanceToCityB = getCityDistance(cityDistance, currentCity, smallest.getCityB());	//Distance from last element of reuturnPath array to smallest cityB
					
					
					//Checks if lone pair distance's is shorter than either city in the pair 
					//(this is the pair with the smallest distance between the 2 cities inside the pair)
					if(distanceToCityA   >   distanceToLonePair   &&   distanceToCityB   >   distanceToLonePair) {
						//Adds to the array
						returnPath.add(pairsArray.get(pairsArray.size()-1).getCityA());
						
						// remove lone pair from the pairsArray so its not checked again	
						pairsArray.remove(pairsArray.size()-1);
						
						hasLonePair=false;
						continue;
					}
					
					if(distanceToCityA < distanceToCityB) {		//Add cityA first because it is shorter than cityB
						returnPath.add(smallest.getCityA());
						returnPath.add(smallest.getCityB());
					}
					else {										//Add cityB first because it is shorter than cityA
						returnPath.add(smallest.getCityB());
						returnPath.add(smallest.getCityA());
					}
					pairsArray.remove(smallestInd);
					continue;
				}
				
				returnPath.add(pairsArray.get(pairsArray.size()-1).getCityA());		//Add the only element in pairsArray
				pairsArray.remove(pairsArray.size()-1);
			}

			//Ignore lone pair since it has already been added, Focuses on next two shortest distances
			else {
				distanceToCityA = getCityDistance(cityDistance, currentCity, smallest.getCityA());
				distanceToCityB = getCityDistance(cityDistance, currentCity, smallest.getCityB());
				
				if(distanceToCityA < distanceToCityB) {		//Add cityA first because it is shorter than cityB
					returnPath.add(smallest.getCityA());
					returnPath.add(smallest.getCityB());
				}
				else {										//Add cityB first because it is shorter than cityA
					returnPath.add(smallest.getCityB());
					returnPath.add(smallest.getCityA());
				}
				pairsArray.remove(smallestInd);
			}
			
			
		}
		
		returnPath.add(returnPath.get(0));
		
		System.out.println("ReturnPath:"+returnPath);
		
		for (int k = 0; k<returnPath.size() ;k++) {
			if (returnPath.get(k)==-1) {
				returnPath.remove(k);
				break;
			}
		}
		System.out.println(returnPath);
		
		return returnPath;			//Return array of sorted points.
	}
	
	
	
	/**
	 * Get the distance from one city to another
	 * @param citryDistance the distances from each city
	 * @param cityA the starting city
	 * @param cityB the desired city
	 * @return the distance from cityA to cityB
	 */
	public static int getCityDistance(int[][] citryDistance, int cityA, int cityB) {
		return citryDistance[cityA][cityB];
	}
	
	
	/**
	 * Calculate the total time in hours spent on the road
	 * @param distance total road distance
	 * @return total time in hours spent on the road
	 */
	public static double hoursOnRoad(double distance){
		return (distance / 60);
	}
	
	/**
	 * Calculate the total cost of fuel
	 * @param distance total road distance
	 * @return total cost of fuel
	 */
	public static double fuelCost(double distance){
		 return (distance / 7.0) * 3.32;
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
	
	/**
	 * Calculate the total distance of the trip
	 * @param path the order of cities to travel
	 * @param cityD the distances from each city
	 * @return the total distance of the trip
	 */
	public static int totalDistance(ArrayList<Integer> path, int[][] cityD) {
		int totalDistance = 0;
		
		for(int i = 0; i < path.size(); i++) {
			totalDistance += getCityDistance(cityD, path.get(i), path.get((i+1)%path.size()));
		}
		
		return totalDistance;
	}
	
	/**
	 * Print out the order of cities to cover for the delivery truck 
	 * @param path the order of cities to travel
	 * @param cName the names of the cities
	 */
	public static void cityNames(ArrayList<Integer> path, String[] cName) {
		
		for(int i = 0; i < path.size(); i++) {
			System.out.print(cName[path.get(i)] +"     ");
		}
		System.out.println();
	}
}