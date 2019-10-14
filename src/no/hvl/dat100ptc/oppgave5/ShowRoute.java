package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

import java.awt.*;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int STATSSIZE = 200;
	private static int MAPXSIZE = 1000;
	private static int MAPYSIZE = 600 - STATSSIZE;


	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	private Cord[] cords;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN + STATSSIZE);

		showRouteMap(MARGIN + MAPYSIZE);

		showStatistics();

		playRoute(MARGIN + MAPYSIZE);
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		return MAPXSIZE / (Math.abs(maxlon - minlon));
	}

	// antall y-pixels per breddegrad
	public double ystep() {
		
		// TODO - START

		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));

		return MAPYSIZE / (Math.abs(maxlat - minlat));

		// TODO - SLUTT
		
	}

	public void showRouteMap(int ybase) {

		// TODO - START

		double xstep = xstep();
		double ystep = ystep();

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));

		double x;
		double y;

		setColor(Color.green);

		cords = new Cord[gpspoints.length];

		for (int i = 0; i < gpspoints.length; i++) {
			x = (GPSUtils.getLongitudes(gpspoints)[i] - maxlon) * xstep + MAPXSIZE + MARGIN;
			y = (GPSUtils.getLatitudes(gpspoints)[i] - maxlat) * ystep + MAPYSIZE + MARGIN + STATSSIZE;
			cords[i] = new Cord((int)x, (int)y);

			//System.out.println(y);
			//fillCircle((int)x, (int)y, 5);
		}

		for (int i = 0; i < cords.length; i++) {
			fillCircle(cords[i].x, cords[i].y, 5);
			if (i < cords.length -1) {
				drawLine(cords[i].x, cords[i].y, cords[i+1].x, cords[i+1].y);
			}
		}

		// TODO - START
	}

//	private Cord[] getCords(double[] x, double[] y) {
//		var cords = new Cord()
//	}

	class Cord {
		public int x;
		public int y;

		public Cord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		// TODO - START

		var stats = gpscomputer.displayStatistics().split("\\r?\\n");
		int y = MARGIN;
		for (var line : stats) {
			drawString(line, MARGIN, y);
			y+= TEXTDISTANCE;
		}
		//drawString(gpscomputer.displayStatistics(), 20, 20);

		// TODO - SLUTT;
	}

	public void playRoute(int ybase) {

		// TODO - START

		System.out.println("Angi tidsskalering i tegnevinduet ...");
		int timescaling = Integer.parseInt(getText("Tidsskalering (1-10)"));
		if (timescaling > 10) timescaling = 10;

		setColor(Color.blue);
		int blue = fillCircle(cords[0].x, cords[0].y, 10);
		int speed;
		for (int i = 1; i < cords.length; i++) {
			speed = (int)(timescaling * gpscomputer.speeds()[i-1] / gpscomputer.maxSpeed());
			if (speed < 1) speed = 1;
			setSpeed(speed); // avhenger av maskinen osv, blir ikke riktig uansett
			move(blue, cords[i].x, cords[i].y);
		}

		// TODO - SLUTT
	}

}
