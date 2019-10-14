package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
    // skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26 
	
	private static int TIME_STARTINDEX = 11; // startindex for tidspunkt i timestr

	public static int toSeconds(String timestr) {

		// TODO - START
		var timestamp = timestr.split("T")[1].split("\\.")[0].split(":");
		int seconds = Integer.parseInt(timestamp[0]) * 3600;
		seconds += Integer.parseInt(timestamp[1]) * 60;
		seconds += Integer.parseInt(timestamp[2]);
		return seconds;

		// TODO - SLUTT
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
