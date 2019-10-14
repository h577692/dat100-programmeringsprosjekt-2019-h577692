package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}

	// beregn total distances (i meter)
	public double totalDistance() {

		// TODO - START

		double distance = 0;

		for (int i = 0; i < gpspoints.length - 1; i++) {
			distance += GPSUtils.distance(gpspoints[i], gpspoints[i+1]);
		}

		return distance;

		// TODO - SLUTT
	}

	// beregn totale høydemeter (i meter)
	public double totalElevation() {

		// TODO - START

		double hoeydeMeter = 0;

		for (int i = 0; i < gpspoints.length - 1; i++) {
			if (gpspoints[i+1].getElevation() > gpspoints[i].getElevation()) {
				hoeydeMeter += gpspoints[i+1].getElevation() - gpspoints[i].getElevation();
			}
		}

		return hoeydeMeter;

		// TODO - SLUTT

	}

	// beregn total tiden for hele turen (i sekunder)
	public int totalTime() {

		// TODO - START

		return gpspoints[gpspoints.length -1].getTime() - gpspoints[0].getTime();

		// TODO - SLUTT
	}

	/*
	som skal returnere en tabell med gjennomsnitshastigheter mellom hver av de punktene vi har beveget oss mellom.
	Dvs. første inngang i tabellen skal være hastigheten vi beveget oss med mellom punkt 0 og punkt 1,
	andre inngang hastigheten mellom punkt 1 og 2 osv. Hvis antall GPS datapunker er N
	da vil lengden av den tabellen som returneres være N-1.
	 */
		
	// beregn gjennomsnitshastighets mellom hver av gps punktene
	public double[] speeds() { // km/h
		
		// TODO - START

		var speeds = new double[gpspoints.length - 1];

		for (int i = 0; i < speeds.length; i++) {
			speeds[i] = GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
		}

		return speeds;

		// TODO - SLUTT
	}
	
	public double maxSpeed() { // km/h

		// TODO - START

		double maxSpeed = 0;

		for (var speed : speeds())
			if (speed > maxSpeed) maxSpeed = speed;

		return maxSpeed;
		
		// TODO - SLUTT
	}

    public double[] climbs() { // prosent

	    // stigningsprosent = stigning / lengde * 100
        var climbs = new double[gpspoints.length - 1];
        for (int i = 0; i < gpspoints.length - 1; i++) {
            climbs[i] = gpspoints[i+1].getElevation() - gpspoints[i].getElevation() /
                    GPSUtils.distance(gpspoints[i], gpspoints[i+1]) * 100;
        }

        return climbs;
    }

    public double maxClimb() { // prosent

	    double max = 0.0;
	    for (var climb : climbs()) {
	        if (climb > max) max = climb;
        }
	    return max;
    }

    public double averageSpeed() { // km/h

		// TODO - START

		return totalDistance() / (double)totalTime() * 3.6;
		
		// TODO - SLUTT
	}

	/*
	 * bicycling, <10 mph, leisure, to work or for pleasure 4.0 bicycling,
	 * general 8.0 bicycling, 10-11.9 mph, leisure, slow, light effort 6.0
	 * bicycling, 12-13.9 mph, leisure, moderate effort 8.0 bicycling, 14-15.9
	 * mph, racing or leisure, fast, vigorous effort 10.0 bicycling, 16-19 mph,
	 * racing/not drafting or >19 mph drafting, very fast, racing general 12.0
	 * bicycling, >20 mph, racing, not drafting 16.0
	 */

	// conversion factor m/s to miles per hour
	public static double MS = 2.236936;

	// beregn kcal gitt weight og tid der kjøres med en gitt hastighet
	public double kcal(double weight, int secs, double speed) {

		// TODO - START
		
		return met(speed) * weight * secs/3600.0;

		// TODO - SLUTT
	}

	private double met(double speed) {

		double mph = speed * 0.62;

		if (mph < 10) return 4.0;
		if (mph >= 10 && mph <= 12) return 6.0;
		if (mph >= 12 && mph <= 14) return 8.0;
		if (mph >= 14 && mph <= 16) return 10.0;
		if (mph >= 16 && mph <= 20) return 12.0;
		return 16.0;
	}

	public double totalKcal(double weight) {

		// TODO - START

		double kcal = 0;

		for (int i = 0; i < speeds().length; i++) {
			kcal += kcal(weight, gpspoints[i+1].getTime() - gpspoints[i].getTime(), speeds()[i]);
		}

		return kcal;

		// TODO - SLUTT
	}
	
	private static double WEIGHT = 80.0;

	private static final int WIDTH = 17;
	private static final String SEP = ":";
	
	public String displayStatistics() {

		// TODO - START

		String stats = "==============================================" +
				formatString("\nTotal Time") + SEP + GPSUtils.formatTime(totalTime()) +
				formatString("\nTotal distance") + SEP + GPSUtils.formatDouble(totalDistance()) + " km" +
				formatString("\nTotal elevation") + SEP + GPSUtils.formatDouble(totalElevation()) + " m" +
				formatString("\nMax speed") + SEP + GPSUtils.formatDouble(maxSpeed()) + " km/h" +
				formatString("\nAverage speed") + SEP + GPSUtils.formatDouble(averageSpeed()) + " km/h" +
				formatString("\nEnergy") + SEP + GPSUtils.formatDouble(totalKcal(WEIGHT)) + " kcal" +
				"\n==============================================";
        System.out.println(stats);
		return stats;

		// TODO - SLUTT
	}

	private static String formatString(String s) {
		return s + " ".repeat(WIDTH - s.length());
	}

}
