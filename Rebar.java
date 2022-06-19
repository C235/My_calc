package com.example.my_calc;

import static java.lang.Math.sqrt;

public class Rebar {
    String ProvideMy(String con,String reb,String sh, double q, double qn, double h, double b, double l, double a){
        //int[] BM = {20, 25, 30};
        int[] RbM = {10350, 13050, 15300};
        int[] RbtserM = {1350, 1550, 1750};
        int[] RbserM = {15000, 18500, 22000};
        double[] EbM = {2.75e7, 3e7, 3.25e7};
        //int[] A = {240, 300, 400, 500};
        int[] RsM = {170000, 270000, 355000, 435000};
        int[] RscM = {215000, 270000, 355000, 435000};
        double[] EsM = {2e8, 2e8, 2e8, 2e8};
        double[][] As = {{3,4,5,6,8,10,12,14,16,18,20,22,25,28,32,36,40},
                {0.071, 0.126, 0.196, 0.283, 0.503, 0.785, 1.131, 1.539, 2.011, 2.545, 3.142, 3.801, 4.909, 6.158, 8.042, 10.179, 12.566}};
        double Mpr, Aopr, n1, Astrpr, n, dspr, Aspr, teta;
        String result;
        double ho = h - a;
        Aopr = 0;
        int Rb, Rbtser, Rbser, Rs, Rsc;
        double Eb, Es;
        Rb = 0;
        Rs = 0;

        //расчетные сопротивления бетона
        switch (con){
            case "B20": {
                Rb = RbM[0];
                Rbtser = RbtserM[0];
                Rbser = RbserM[0];
                Eb = EbM[0];
                break;
            }
            case "B25": {
                Rb = RbM[1];
                Rbtser = RbtserM[1];
                Rbser = RbserM[1];
                Eb = EbM[0];
                break;
            }
            case "B30": {
                Rb = RbM[2];
                Rbtser = RbtserM[2];
                Rbser = RbserM[2];
                Eb = EbM[0];
                break;
            }
        }
        //расчетные сопротивления арматуры
        switch (reb) {
            case "A240": {
                Rs = RsM[0];
                Rsc = RscM[0];
                Es = EsM[0];
                break;
            }
            case "A300": {
                Rs = RsM[1];
                Rsc = RscM[1];
                Es = EsM[1];
                break;
            }
            case "A400": {
                Rs = RsM[2];
                Rsc = RscM[2];
                Es = EsM[2];
                break;
            }
            case "A500": {
                Rs = RsM[3];
                Rsc = RscM[3];
                Es = EsM[3];
                break;
            }
        }
        //вычисления
        switch (sh) {
            case "З-З": {
                Mpr = q * l * l / 24;
                Aopr = Mpr / (Rb * b * ho * ho);
                if (Aopr > 0.4) result = "Ao > 0.4";
                else{
                    teta = (1 + sqrt(1 - 2 * Aopr)) / 2;
                    Astrpr = Mpr / (Rs * teta * ho);
                    result = "требуемое количество " + String.valueOf(Astrpr) + "см2";
                }
                //System.out.println("значение Aopr= " + Aopr);
                //System.out.println("значение Mpr = " + Mpr);
                break;
            }
            case "З-Ш" :{
                Mpr = q * l * l / 16;
                Aopr = Mpr / (Rb * b * ho * ho);
                //System.out.println("значение Mpr = " + Mpr);
                //System.out.println("значение Aopr= " + Aopr);
                break;
            }
            case "Ш-Ш" :{
                Mpr = q * l * l / 8;
                Aopr = Mpr / (Rb * b * ho * ho);
                //System.out.println("значение Mpr = " + Mpr);
                //System.out.println("значение Aopr= " + Aopr);
                break;
            }
            case "К" : {
                Mpr = q * l * l / 2;
                Aopr = Mpr / (Rb * b * ho * ho);
                //System.out.println("значение Mpr = " + Mpr);
                //System.out.println("значение Aopr= " + Aopr);
                break;
            }
        }
        return Double.toString(Aopr);
    }
    public static void main (String args[]){
        double[][] As = {{3,4,5,6,8,10,12,14,16,18,20,22,25,28,32,36,40},
                {0.071, 0.126, 0.196, 0.283, 0.503, 0.785, 1.131, 1.539, 2.011, 2.545, 3.142, 3.801, 4.909, 6.158, 8.042, 10.179, 12.566}};
       Rebar k1 = new Rebar();
       k1.ProvideMy("B20","A500","З-Ш",76,70,0.3,1,4.58,0.055);
        System.out.println("значение As l1= " + As[0].length);
        System.out.println("значение As l2= " + As[1].length);

    }
}
