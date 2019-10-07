package no.hvl.dat100ptc.oppgave1;

class karius {
    public static void baktus() {
/*        TODO Karius og baktus*/
        System.out.println("blir dette printet?");
    }

    public static void baktus(String text) {
        System.out.println("her er teksten: " + text);
    }
}


public class TestKlasse {
    public static void main(String[] args) {
        karius.baktus();
        karius.baktus("Girl, this is it.");
    }
}