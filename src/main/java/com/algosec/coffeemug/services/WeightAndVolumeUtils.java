package com.algosec.coffeemug.services;

public class WeightAndVolumeUtils {

    public static double kiloIntoLbs( double kilo) {
        return kilo * 2.205;
    }

    public static double literIntoGallons( double liter) {
        return liter / 3.785;
    }

}
