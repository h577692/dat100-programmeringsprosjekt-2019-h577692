package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
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
		for (int i = 0; i < gpspoints.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}

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

		// definisjon fart: delta(s)/delta(t)

		/*
		m/s * 3.6 = km/t
		 */

		// TODO - START

		double strekning = distance(gpspoint1, gpspoint2);
		double tid = gpspoint2.getTime() - gpspoint1.getTime();

		return strekning / tid * 3.6;

		// TODO - SLUTT
	}

	/*
	som returnerer en streng på formatet hh:mm:ss der tiden i sekunder fra midnatt er gitt av parameteren secs.
	I strengen på formatet hh:mm:ss er hh er antall timer, mm er antall minutter og ss er antall sekunder.
	Videre skal metoden legge inn mellomrom foran tiden slik den total lengden på strengen blir 10.
	Hint: se på format-metoden i String-klassen.`
	 */
	public static String formatTime(int secs) {

		// TODO - START

		String TIMESP = ":";

		int h = secs / 3600;
		int m = secs % 3600 / 60;
		int s = secs % 60;

		return "  " + addChars(h, 2, "0") + TIMESP + addChars(m, 2, "0") + TIMESP + addChars(s, 2, "0");
		
		// TODO - SLUTT
	}

	private static String addChars(int num, int length, String c) {
		return c.repeat(length - String.valueOf(num).length()) + num;
	}

	private static String addChars(double num, int length, String c) {
		return c.repeat(length - String.valueOf(num).length()) + num;
	}

	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		// TODO - START

		d = Math.round(d * 100) / 100.0;

		//return " ".repeat(10 - String.valueOf(d).length()) + d;

		return addChars(d, TEXTWIDTH, " ");

		// TODO - SLUTT
		
	}
}
