package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;

public class GPSPoint {

	private int time;
	private double latitude;
	private double longitude;
	private double elevation;
		
	public GPSPoint(int time, double latitude, double longitude, double elevation) {

		// TODO - konstruktur
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
	}

	// TODO - get/set metoder
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getElevation() {
		return elevation;
	}

	public void setElevation(double elevation) {
		this.elevation = elevation;
	}

	@Override
	public String toString() {

		/*
		Gjør ferdig implementasjonen av toString()-metoden som returnerer en strengrepresentasjon av et
		GPSPoint-objekt på formen:
		1 (2.0,3.0) 5.0\n
		der 1 er tiden, (2.0,3.0) er (breddegrad,lengdegrad) og 5.0 er høyden.
		Test implementasjonen ved å bruke enhetstestene.
		 */
		String str;
		
		// TODO - start

		return "hei";

		// TODO - slutt
		
	}
}
