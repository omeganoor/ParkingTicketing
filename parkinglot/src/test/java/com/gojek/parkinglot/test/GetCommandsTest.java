package com.gojek.parkinglot.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.parkinglot.GetCommands;

public class GetCommandsTest {
	
	public ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	GetCommands getCommand = new GetCommands();
	
	@Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
    
	@Test
	public void invalidCommandInput() throws IOException{
		String[] input = {"hello"};
		getCommand.getCommand(input);
		assertEquals("CommandNotFound,Pleaseenteravalidcommand", outContent.toString().trim().replace(" ", ""));
	}
	
	@Test
	public void invalidDataValueInput() throws IOException{
		String[] input = {"Create_Parking_lot"};
		getCommand.getCommand(input);
		assertEquals("invalidinput,pleaseenteravalidslotnumber", outContent.toString().trim().replace(" ", ""));
	}
	
	@Test
	public void getCommands() throws IOException{
		String[] input = {"status"};
		getCommand.getCommand(input);
		assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
	}
}
