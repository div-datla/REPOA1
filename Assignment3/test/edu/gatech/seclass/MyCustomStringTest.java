package edu.gatech.seclass;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyCustomStringTest {

	private MyCustomStringInterface mycustomstring;

	@Before
	public void setUp() throws Exception {
		mycustomstring = new MyCustomString();
	}

	@After
	public void tearDown() throws Exception {
		mycustomstring = null;
	}

    @Test
    public void testCountDigits1() {
        mycustomstring.setString("I'd better put s10me d1gits in this 5tr1n9, right?");
        assertEquals(6, mycustomstring.countDigits());
    }

	@Test
	public void testCountDigits2() {

		mycustomstring.setString("1234567890");
        assertEquals(10, mycustomstring.countDigits());
	}

	@Test
	public void testCountDigits3() {
		mycustomstring.setString("There are no numbers in this string");
        assertEquals(0, mycustomstring.countDigits());
	}

	@Test
	public void testCountDigits4() {
		mycustomstring.setString("");
        assertEquals(0, mycustomstring.countDigits());
	}

    @Test
    public void testGetEveryNthCharacter1() {
        mycustomstring.setString("I'd better put s10me d1gits in this 5tr1n9, right?");
        assertEquals("deep 0 gsnh r9rh", mycustomstring.getEveryNthCharacter(3));
    }

	@Test (expected = MyIndexOutOfBoundsException.class)
	public void testGetEveryNthCharacter2() { 
		 mycustomstring.setString("I'd better put s10me d1gits in this 5tr1n9, right?");
	        assertEquals("Throw Exception", mycustomstring.getEveryNthCharacter(0));
	}

	@Test
	public void testGetEveryNthCharacter3() { fail("Not yet implemented"); }

	@Test
	public void testGetEveryNthCharacter4() {
		fail("Not yet implemented");
	}

    @Test
    public void testGetEveryNthCharacter5() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd better put s10me d1gits in this 5tr1n9, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd better put sTenme dOnegits in this 5tr1n9, right?", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring2() { 
    	mycustomstring.setString("2his string has no digits");
        mycustomstring.convertDigitsToNamesInSubstring(1, 1);
        assertEquals("Twohis string has no digits", mycustomstring.getString());
        }

    @Test
    public void testConvertDigitsToNamesInSubstring3() { 
    	mycustomstring.setString("011001");
        mycustomstring.convertDigitsToNamesInSubstring(1,6);
        assertEquals("ZeroOneTenZeroOne", mycustomstring.getString());
        }

    @Test
    public void testConvertDigitsToNamesInSubstring4() { 
    	mycustomstring.setString("011001");
        mycustomstring.convertDigitsToNamesInSubstring(6,6);
        assertEquals("01100One", mycustomstring.getString());
        }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring5() { 
    	mycustomstring.setString("I'd better put s10me d1gits in this 5tr1n9, right?");
    	mycustomstring.convertDigitsToNamesInSubstring(23, 17);
    	assertEquals("I'd better put sTenme dOnegits in this 5tr1n9, right?", mycustomstring.getString());
    }
    
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring7() { 
    	mycustomstring.setString("I'd better put s10me d1gits in this 5tr1n9, right?");
    	mycustomstring.convertDigitsToNamesInSubstring(0, 0);
    	assertEquals("I'd better put sTenme dOnegits in this 5tr1n9, right?", mycustomstring.getString());
    }

    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring6() { 
    	mycustomstring.setString("SmallString");
    	mycustomstring.convertDigitsToNamesInSubstring(17,23);
    	assertEquals("I'd better put sTenme dOnegits in this 5tr1n9, right?", mycustomstring.getString());
    	}


}
