package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0; // brukes til å holde kontroll på hvor neste gpspoint skal settes inn


	public GPSData(int antall) {

		// TODO - START
		
		gpspoints = new GPSPoint[antall];

		// TODO - SLUTT
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;

		// TODO - START

		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			inserted = true;
		}
		return inserted;

		// TODO - SLUTT
	}

	/*
	public boolean insert(String time, String latitude, String longitude, String elevation)
	som tar GPS punkt data i streng-representasjon og setter inn et tilsvarende GPSPoint-objekt i gpspoints-tabellen.
	Hint: Metoden skal konvertere data, opprette et nytt GPSPoint-objekt og bruk insertGPS-metoden ovenfor.
	 */

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		//GPSPoint gpspoint = ;

		// TODO - START
		
		return insertGPS(GPSDataConverter.convert(time, latitude, longitude, elevation));

		// TODO - SLUTT
		
	}

	public void print() {

		// TODO - START

		var sb = new StringBuilder("====== Konvertert GPS Data - START ======\n");

		for (var point : gpspoints) {
			sb.append(point.toString());
		}

		// TODO - SLUTT
		
		sb.append("====== Konvertert GPS Data - SLUTT ======");
		System.out.println(sb.toString());

	}
}
