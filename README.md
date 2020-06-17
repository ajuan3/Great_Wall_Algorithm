# Traveling Salesman Problem (TSP)
This program is to solve a "Traveling Salesman" problem set in the context of this Supermarket Chain Store, trying to optimize its delivery costs through 7 cities.
<p align="center">
  <image src="images/Distance_Table.png" width="550"/>
</p>

## Description of the Problem
A supermarket chain store has its warehouse located in Rockville, Maryland. It operates chain stores located in 7 major cities in 4 different states across the United States of America. Their delivery truck starts in Rockville, Maryland, which is the company’s city #1 for routing the delivery trucks from the warehouse to chain stores. They want to cover these 7 cities for their delivery trucks such that their traveling distance is minimized, and they have the least amount of time spent running on the road before their delivery fleet comes back to Rockville, MD. These cities should be visited so the total transportation cost is as small as possible.

In order to solve this problem, we have devise the **Pear Algorithm**.

## The Algorithm
Pear Algorithm was made by considering the nearest neighbor algorithm but trying to take in account of future moves. We decided on creating pairs of the cities that are closest to each other, and the distance between each pair will determine the next location to travel for the salesman.

### Step1 - Displaying the cities
<p align="center">
  <image src="images/step1.png" width="550"/>
</p>

### Step2 - Pairing the cities
<p align="center">
  <image src="images/step2.png" width="550"/>
</p>

### Step3 - Forming the path
<p align="center">
  <image src="images/step3.png" width="550"/>
</p>

