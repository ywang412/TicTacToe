package com.sample.tictactoe;

import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by swengineer on 10/31/17.
 */
public class MainTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void testMain() throws IOException {

        String args[] = {"2"};
        Main.main(args);
    }
}