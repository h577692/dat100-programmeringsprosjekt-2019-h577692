package no.hvl.dat100ptc.oppgave3;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max = da[0];
		
		for (double d : da) if (d > max) max = d;

		return max;
	}

	public static double findMin(double[] da) {

		// TODO - START

		double min = da[0];

		for (double d : da) if (d < min) min = d;

		return min;

		// TODO - SLUT
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		
		var latitudes = new double[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}

		return latitudes;
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START

		var longitudes = new double[gpspoints.length];

		for (int i = 0; i < gpspoints.length; i++)
			longitudes[i] = gpspoints[i].getLongitude();

		return longitudes;
		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		// TODO - START

		double latitude1 = Math.toRadians(gpspoint1.getLatitude());
		double longitude1 = Math.toRadians(gpspoint1.getLongitude());
		double latitude2 = Math.toRadians(gpspoint2.getLatitude());
		double longitude2 = Math.toRadians(gpspoint2.getLongitude());

		return 2 * R * Math.asin(Math.sqrt(Math.pow(Math.sin((latitude2 - latitude1)/2.0), 2) +
						Math.cos(latitude1)*Math.cos(latitude2) * Math.pow(Math.sin((longitude2 - longitude1)/2),2)));

		// TODO - SLUTT
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		// definisjon gjennomsnittsfart: delta(s)/delta(t)

		// TODO - START

		return distance(gpspoint1, gpspoint2) /
				(gpspoint2.getTime() - gpspoint1.getTime()) * 3.6;

		// TODO - SLUTT
	}

	public static String formatTime(int secs) {

		// TODO - START

		return String.format("  %02d:%02d:%02d",
				secs / 3600, 		// timer
				secs % 3600 / 60,   // minutter
				secs % 60); 		// sekunder

		// TODO - SLUTT
	}

	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		// TODO - START

		d = Math.round(d * 100) / 100.0;

		return " ".repeat(TEXTWIDTH - Double.toString(d).length()) + d;

		// TODO - SLUTT
	}
}
