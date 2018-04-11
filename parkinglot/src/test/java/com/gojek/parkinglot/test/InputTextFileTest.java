package com.gojek.parkinglot.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.gojek.parkinglot.FileParser;
import com.gojek.parkinglot.ParkingLot;

public class InputTextFileTest {
	FileParser parseFile = new FileParser();	
	public ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
    
	@Test
	public void readFileNotFound() throws IOException{
		parseFile.parseFileInput("test\\input.txt");
		assertEquals("Filenotfoundinthepathspecified.", outContent.toString().trim().replace(" ", ""));
	}
	
	@Test
	public void readFile() throws IOException{
		parseFile.parseFileInput("input_test_file.txt");
		assertEquals("Sorry,parkinglotisnotcreated"
		, outContent.toString().trim().replace(" ", "").replaceAll("\n", ""));
	}

}
