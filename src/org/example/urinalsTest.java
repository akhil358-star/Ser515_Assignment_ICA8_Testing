package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {
    //author - Akhil Sai Alpuri (Asurite ID - aalpuri)
    urinals ur123=new urinals();

    @Test
    void getStringTest() {

        assertEquals(true, ur123.getString("10001"));
        assertEquals(true, ur123.getString("10010"));
        assertFalse(ur123.getString("1100"));
        //Failed test case - assertEquals(true, ur.getString("1100"));;
    }

    @Test
    void countUrinalsTest() {
        assertEquals(0, ur123.countUrinals("01001"));
        assertEquals(1, ur123.countUrinals("100001"));
        assertEquals(-1, ur123.countUrinals("100010000000000000000000000000000000000010000000000000"));
        assertEquals(-1, ur123.countUrinals("0110"));
        //        Failed test case - assertEquals("failed test case", ur123.countUrinals("10001"));
    }

    @Test
    void openFileTest() throws IOException {
        assertEquals(1,ur123.openFile("src/org.example/urinals.dat"));
        //        Failed test case - assertEquals("failed test case", ur.openFile("src/org.example/urinals.dat"));
    }
}