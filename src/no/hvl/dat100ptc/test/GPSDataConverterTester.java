package no.hvl.dat100ptc.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;

public class GPSDataConverterTester {

	/*
	2017-08-13T08:52:26.000Z,60.385390,5.217217,61.9,7.0,219.93,0.94605947,0,gps,1.02,0.85,1.33,,,,,100.0,
	2017-08-13T08:53:00.000Z,60.385588,5.217857,56.2,11.1,0.0,0.0,0,gps,2.22,0.94,2.41,,,,TILTING,100.0,
	
	*/
	
	private String TIMESTR = "2017-08-13T08:52:26.000";
	private String LATSTR = "60.385390";
	private String LONGSTR = "5.217217";
	private String ELEVSTR = "61.9";
		
	@Test
	public void test_toSeconds() {
		
	    assertEquals(8*60*60 + 52*60 + 26,GPSDataConverter.toSeconds(TIMESTR));
		
	}

	@Test
	public void test_convert () {
		
		GPSPoint g = GPSDataConverter.convert(TIMESTR,LATSTR,LONGSTR,ELEVSTR);
		
		assertEquals(8*60*60 + 52*60 + 26,g.getTime());
		assertEquals(60.385390,g.getLatitude(),0.01);
		assertEquals(5.217217,g.getLongitude(),0.01);
		assertEquals(61.9,g.getElevation(),0.01);
		
	}
}
