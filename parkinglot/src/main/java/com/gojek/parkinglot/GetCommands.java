package com.gojek.parkinglot;

public class GetCommands {
	static ParkingLot parkinglot = new ParkingLot();
	
	public static void getCommand(String[] inputs) {
		try {
			String command = inputs[0].toLowerCase();
						
			if (command.equalsIgnoreCase("create_parking_lot")){				
				try {
					parkinglot.createParkingLot(inputs[1]);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("invalid input, please enter a valid slot number");
				}
			}else if (command.equalsIgnoreCase("park")){
				try {
					parkinglot.park(inputs[1].toUpperCase(), inputs[2].toUpperCase());
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("invalid input, please enter a valid car color & registration number");
				}
			}else if (command.equalsIgnoreCase("status")){
				parkinglot.status();
			}else if (command.equalsIgnoreCase("leave")){
				try {
					parkinglot.leave(inputs[1]);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("invalid input, please enter a valid slot number");
				}
			}else if (command.equalsIgnoreCase("registration_numbers_for_cars_with_colour")){
				try {
					parkinglot.getRegistrationNumbersFromColor(inputs[1].toUpperCase());
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("invalid input, please enter a valid car color");
				}
			}else if (command.equalsIgnoreCase("slot_numbers_for_cars_with_colour")){
				try {
					parkinglot.getSlotNumbersFromColor(inputs[1].toUpperCase());
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("invalid input, please enter a valid car color");
				}
			}else if (command.equalsIgnoreCase("slot_number_for_registration_number")){
				try {
					parkinglot.getSlotNumberFromRegNo(inputs[1].toUpperCase());
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("invalid input, please enter a valid car registration number");
				}
			}else if (command.equalsIgnoreCase("delete_parking_lot")){
				try {
					parkinglot.deleteParkingLot();
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("invalid input");
				}
			}else {
				System.out.println("Command Not Found, Please enter a valid command");
			}
		} catch (NullPointerException e) {
			System.out.println("input value is null, please input a valid command");
			e.printStackTrace();
		}
	}
}
