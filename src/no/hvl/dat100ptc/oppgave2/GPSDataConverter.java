package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
    // skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26 
	
	private static int TIME_STARTINDEX = 11; // startindex for tidspunkt i timestr

	public static int toSeconds(String timestr) {

		// TODO - START
		String[] time = timestr.split("T")[1].split(":");

		int secs = Integer.parseInt(time[0]) * 3600; // sekunder fra timer
		secs += Integer.parseInt(time[1]) * 60; // sekunder fra minutter
		secs += Double.parseDouble(time[2].replace("Z", "")); // sekunder fra sekunder

		// TODO - SLUTT
		return secs;
		
	}

	// convert("2017-08-13T08:52:26.000Z","60.385390","5.217217","61.9")
	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		// TODO - START ;

		return new GPSPoint(toSeconds(timeStr),
				Double.parseDouble(latitudeStr),
				Double.parseDouble(longitudeStr),
				Double.parseDouble(elevationStr));


		// TODO - SLUTT ;
	}
}
