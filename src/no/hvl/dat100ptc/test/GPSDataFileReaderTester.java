package no.hvl.dat100ptc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat100ptc.oppgave2.GPSData;
import static no.hvl.dat100ptc.oppgave2.GPSDataFileReader.*;

class GPSDataFileReaderTester {

	private String SHORTFILE = "short";
	private String MEDIUMFILE = "medium";
	private String LONGFILE = "long";
	private String VMFILE = "vm";
	
	private void test_file (String filename, int n) {
		
		GPSData gpsdata = readGPSFile(filename);
		assertEquals(n,gpsdata.getGPSPoints().length);
		gpsdata.print();
	}
	
	@Test
	void test_shortfile () {
		test_file(SHORTFILE,19);
	}

	@Test
	void test_mediumfile () {
		test_file(MEDIUMFILE,197);
	}
	
	@Test
	void test_longfile () {
		test_file(LONGFILE,111);
	}
	
	@Test
	void test_vmfile () {
		test_file(VMFILE,423);
	}
	
}
