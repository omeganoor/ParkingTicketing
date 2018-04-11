package com.gojek.parkinglot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.rmi.activation.ActivationGroupDesc.CommandEnvironment;

public class FileParser {
    
	GetCommands commandsInput = new GetCommands();;

    public FileParser() {

    }
  
    public void parseFileInput(String filePath) {
        // Assuming input to be a valid file path.
        File inputFile = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    parseTextInput(line.trim());
                }
            } catch (IOException ex) {
                System.out.println("Error in reading the input file.");
                ex.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found in the path specified.");
            e.printStackTrace();
        }
    }
    
    public void parseTextInput(String inputTrim) {
		String[] inputs = inputTrim.split(" ");
        commandsInput.getCommand(inputs);
	}
}
