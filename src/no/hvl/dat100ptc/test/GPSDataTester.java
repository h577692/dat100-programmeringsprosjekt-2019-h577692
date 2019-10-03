package no.hvl.dat100ptc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat100ptc.oppgave1.*;

class GPSDataTester {

	private TGPSData gpsdata;
	private int STR = 3;
	private GPSPoint g0,g1,g2;
	
	@BeforeEach
	void setUp() throws Exception {
		
		gpsdata = new TGPSData(STR);

		g0 = new GPSPoint(0,1.0,2.0,3.0);
		g1 = new GPSPoint(1,4.0,5.0,6.0);
		g2 = new GPSPoint(2,7.0,8.0,9.0);
		
	}

	@Test
	void testConstructor() {
		
		assertEquals(0,gpsdata.getAntall());
		assertEquals(STR,gpsdata.getGPSPoints().length);
		
	}

	@Test
	void testinsertGPS () {
		
		assertTrue(gpsdata.insertGPST(g0));
		assertEquals(1,gpsdata.getAntall());

		assertTrue(gpsdata.insertGPST(g1));
		assertEquals(2,gpsdata.getAntall());

		assertTrue(gpsdata.insertGPST(g2));
		assertEquals(3,gpsdata.getAntall());

		GPSPoint[] gs = gpsdata.getGPSPoints();
		
		assertEquals(g0,gs[0]);
		assertEquals(g1,gs[1]);
		assertEquals(g2,gs[2]);

		assertFalse(gpsdata.insertGPST(g2));
	}
	
	@Test
	void testinsert () {
		
		assertTrue(gpsdata.insert("2017-08-13T00:00:01.000Z","1.0","2.0","3.0"));
		assertEquals(1,gpsdata.getAntall());

		assertTrue(gpsdata.insert("2017-08-13T00:00:02.000Z","4.0","5.0","6.0"));
		assertEquals(2,gpsdata.getAntall());

		assertTrue(gpsdata.insert("2017-08-13T00:00:03.000Z","7.0","8.0","9.0"));
		assertEquals(3,gpsdata.getAntall());

		gpsdata.print();
		
	}
	
	
}
