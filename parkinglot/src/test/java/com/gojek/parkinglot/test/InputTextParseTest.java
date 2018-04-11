package com.gojek.parkinglot.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.parkinglot.FileParser;
import com.gojek.parkinglot.MainApps;

public class InputTextParseTest {
	
	FileParser parseInput = new FileParser();
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
    @Test
    public void parseTextInputInvalidCommand() throws Exception {
        parseInput.parseTextInput("hello");
        assertEquals("CommandNotFound,Pleaseenteravalidcommand", outContent.toString().trim().replace(" ", ""));
    }
    
    @Test
    public void parseTextInput() throws Exception {
        parseInput.parseTextInput("status");
        assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
    }

}
