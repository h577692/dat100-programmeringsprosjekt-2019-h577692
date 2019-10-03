package no.hvl.dat100ptc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat100ptc.oppgave1.*;

class GPSPointTester {

	private GPSPoint g;
	
	private int T_TIME = 1;
	private double T_LAT = 2.0;
	private double T_LONG = 3.0; 
	private double T_ELEV = 5.0;
	
	private int TS_TIME = 2;
	private double TS_LAT = 6.0;
	private double TS_LONG = 7.0; 
	private double TS_ELEV = 8.0;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		g = new GPSPoint(T_TIME,T_LAT,T_LONG,T_ELEV);
	}

	@Test
	void testgetTime() {
		assertEquals(T_TIME,g.getTime()); 	
	}

	@Test
	void testgetLatitude() {
		assertEquals(T_LAT,g.getLatitude()); 	
	}

	@Test
	void testgetLongitude() {
		assertEquals(T_LONG,g.getLongitude()); 	
	}
	
	@Test
	void testgetElevation() {
		assertEquals(T_ELEV,g.getElevation()); 	
	}
	
	@Test
	void testsetTime() {
		g.setTime(TS_TIME);
		assertEquals(TS_TIME,g.getTime()); 	
	}
	
	@Test
	void testsetLatitude() {
		g.setLatitude(TS_LAT);
		assertEquals(TS_LAT,g.getLatitude()); 	
	}

	@Test
	void testsetLongitude() {
		g.setLongitude(TS_LONG);
		assertEquals(TS_LONG,g.getLongitude()); 	
	}

	@Test
	void testsetElevation() {
		g.setElevation(TS_ELEV);
		assertEquals(TS_ELEV,g.getElevation()); 	
	}
	
	
	@Test
	void testtoString() {
		
		String res = "1 (2.0,3.0) 5.0\n";
		
		assertEquals(res,g.toString()); 	
	}

}
