package com.example.my_calc;

public class Rebar {
    void ProvideMy(double q, double qn, double h, double b, double l, double a){
        int[] B = {30, 25, 20};
        int[] Rb = {15300, 13050, 10350};
        int[] Rbtser = {1750, 1550, 1350};
        int[] Rbser = {22000, 18500, 15000};
        double[] Eb = {3.25e7, 3e7, 2.75e7};
        int[] A = {500, 400, 300, 240};
        int[] Rs = {435000, 355000, 270000, 170000};
        int[] Rsc = {435000, 355000, 270000, 215000};
        double[] Es = {2e8, 2e8, 2e8, 2e8};
        double Mpr, Aopr, n1, Astrpr, n, dspr, Aspr;

        double ho = h - a;

        Mpr = q * l * l / 16;
        Aopr = Mpr / (Rb[0] * b * ho * ho);
        System.out.println("значение = " + Aopr);
        System.out.println("значение М= " + Mpr);
    }
    public static void main (String args[]){
       Rebar k1 = new Rebar();
       k1.ProvideMy(76,70,0.3,1,4.58,0.055);

    }
}
