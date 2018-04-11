package com.gojek.parkinglot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainApps {
	static FileParser fileparser = new FileParser();
	public static void main(String[] args) {
		switch (args.length) {
		case 0:
//			System.out.println("manual input");
			for (;;) {
                try {
                	Scanner sc = new Scanner(System.in);
                    String inputString = sc.nextLine();
//                    System.out.println(inputString);
                    if (inputString.equalsIgnoreCase("exit")) {
                        break;
                    } else if ((inputString == null) || (inputString.isEmpty())) {
                        // Do nothing
                    } else {
                    	fileparser.parseTextInput(inputString.trim());
                    }
                } catch(Exception e) {
                    System.out.println("Oops! Error in reading the input from console.");
                    e.printStackTrace();
                }
            }
			break; 
		case 1:
			System.out.println("Input File name :"+args[0]);
			fileparser.parseFileInput(args[0]);
			break;
		default:
            System.out.println("Invalid command. Usage: java -jar <jar_file_path> <input_file_path>");
		}

	}

}
