package no.hvl.dat100ptc.oppgave5;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

import javax.swing.*;
import java.awt.*;

public class ShowProfile extends EasyGraphics {

	private static int MARGIN = 50;		// margin on the sides 
	
	//FIXME: use highest point and scale accordingly
	private static int MAXBARHEIGHT = 500; // assume no height above 500 meters
	
	private GPSPoint[] gpspoints;

	public ShowProfile() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		GPSComputer gpscomputer =  new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		int N = gpspoints.length; // number of data points

		makeWindow("Height profile", 2 * MARGIN + 3 * N, 2 * MARGIN + MAXBARHEIGHT);

		// top margin + height of drawing area
		showHeightProfile(MARGIN + MAXBARHEIGHT); 
	}

	// ybase indicates the position on the y-axis where the columns should start
	public void showHeightProfile(int ybase) {

		// TODO - START

		System.out.println("Angi tidsskalering i tegnevinduet ...");
		int timescaling = Integer.parseInt(getText("Tidsskalering"));

		setColor(Color.blue);

		var x = MARGIN;
		int elevation;
		for (int i = 0; i < gpspoints.length; i++) {
			if (gpspoints[i].getElevation() > 0) elevation = (int)gpspoints[i].getElevation();
			else elevation = 0;

			drawLine(x, ybase, x, ybase - elevation);
			x += 2;
			if (i < gpspoints.length - 1) {
				pause((gpspoints[i+1].getTime() - gpspoints[i].getTime()) * 1000 / timescaling);
			}
		}

		// TODO - SLUTT
	}

}
