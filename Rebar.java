package com.example.my_calc;

public class Rebar {
    void ProvideMy(String sh, double q, double qn, double h, double b, double l, double a){
        int[] B = {30, 25, 20};
        int[] Rb = {15300, 13050, 10350};
        int[] Rbtser = {1750, 1550, 1350};
        int[] Rbser = {22000, 18500, 15000};
        double[] Eb = {3.25e7, 3e7, 2.75e7};
        int[] A = {500, 400, 300, 240};
        int[] Rs = {435000, 355000, 270000, 170000};
        int[] Rsc = {435000, 355000, 270000, 215000};
        double[] Es = {2e8, 2e8, 2e8, 2e8};
        double[][] As = {{3,4,5,6,8,10,12,14,16,18,20,22,25,28,32,36,40},
                {0.071, 0.126, 0.196, 0.283, 0.503, 0.785, 1.131, 1.539, 2.011, 2.545, 3.142, 3.801, 4.909, 6.158, 8.042, 10.179, 12.566}};
        double Mpr, Aopr, n1, Astrpr, n, dspr, Aspr;
        double ho = h - a;

        switch (sh) {
            case "З-З": {
                Mpr = q * l * l / 24;
                Aopr = Mpr / (Rb[0] * b * ho * ho);
                System.out.println("значение Aopr= " + Aopr);
                System.out.println("значение Mpr = " + Mpr);
                break;
            }
            case "З-Ш" :{
                Mpr = q * l * l / 16;
                Aopr = Mpr / (Rb[0] * b * ho * ho);
                System.out.println("значение Mpr = " + Mpr);
                System.out.println("значение Aopr= " + Aopr);
                break;
            }
            case "Ш-Ш" :{
                Mpr = q * l * l / 8;
                Aopr = Mpr / (Rb[0] * b * ho * ho);
                System.out.println("значение Mpr = " + Mpr);
                System.out.println("значение Aopr= " + Aopr);
                break;
            }
            case "К" : {
                Mpr = q * l * l / 2;
                Aopr = Mpr / (Rb[0] * b * ho * ho);
                System.out.println("значение Mpr = " + Mpr);
                System.out.println("значение Aopr= " + Aopr);
                break;
            }
        }
    }
    public static void main (String args[]){
        double[][] As = {{3,4,5,6,8,10,12,14,16,18,20,22,25,28,32,36,40},
                {0.071, 0.126, 0.196, 0.283, 0.503, 0.785, 1.131, 1.539, 2.011, 2.545, 3.142, 3.801, 4.909, 6.158, 8.042, 10.179, 12.566}};
       Rebar k1 = new Rebar();
       k1.ProvideMy("З-Ш",76,70,0.3,1,4.58,0.055);
        System.out.println("значение As l1= " + As[0].length);
        System.out.println("значение As l2= " + As[1].length);

    }
}
