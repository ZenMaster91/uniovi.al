package com.guille.al.labs.lab_8;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;

public class NonogramTest {

    @Test
    public void testLoadCases() throws IOException {
	Nonogram nonogram = Nonogram.loadData("case1.txt");
	assertNotEquals(null, nonogram);
	
	nonogram = Nonogram.loadData("case2.txt");
	assertNotEquals(null, nonogram);
	
	nonogram = Nonogram.loadData("case3.txt");
	assertNotEquals(null, nonogram);
	
	nonogram = Nonogram.loadData("case4.txt");
	assertNotEquals(null, nonogram);
	
	nonogram = Nonogram.loadData("case5.txt");
	assertNotEquals(null, nonogram);
    }

}
