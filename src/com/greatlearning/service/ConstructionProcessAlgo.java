package com.greatlearning.service;

import java.util.Stack;

public class ConstructionProcessAlgo {
	Stack<Integer> stack, temp_stack;
	// floorDay[i] : day on which ith floor is going to be constructed 
	int [] floorDay;
	int floors;
	
	public ConstructionProcessAlgo() {
		stack = new Stack<>();
		temp_stack = new Stack<>();
	}
	
	public void runAlgo(int floors, int floorSizes[]) {
		// initialize input
		this.floors = floors;
		floorDay = new int[floors];
		
		stack.clear();
		
		int currentFloor = floors;
		
		for(int i = 1; i <= floors; i++) {
			if(floorSizes[i-1] == currentFloor) {
				floorDay[currentFloor-1] = i;
				currentFloor--;
			} else {
				insertFloorSizeToStack(floorSizes[i-1]);
			}
			currentFloor = popFloorSizesFromStack(currentFloor, i);
		}
	}

	// this methods pop floor sizes which can be processed on the `day`
	private int popFloorSizesFromStack(int currentFloor, int day) {
		while(!stack.isEmpty() && stack.peek() == currentFloor) {
			floorDay[currentFloor-1] = day;
			currentFloor--;
			stack.pop();
		}
		
		return currentFloor;
	}
	
	// this method inserts the floor size into stack in ascending order using a temporary queue
	private void insertFloorSizeToStack(int size) {
		while(!stack.isEmpty() && stack.peek() > size) {
			int element = stack.pop();
			temp_stack.push(element);
		}
		stack.push(size);
		while(!temp_stack.isEmpty()) {
			stack.push(temp_stack.pop());
		}
	}
	
	public void displayBuildingPlan() {
		System.out.println("The order of construction is as follows");
		int currentFloor = floors; 
		for(int i = 1; i <= floors; i++) {
			System.out.println("\nDay: " + i);
			while(currentFloor > 0 && floorDay[currentFloor-1] == i) {
				System.out.print(currentFloor-- + " ");
			}
		}
	}
	
}
