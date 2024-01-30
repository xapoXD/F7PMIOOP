package org.cv.main;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


import model.Factory;

public class Main {
    public static void getPatientByID(int id, Object[] patientList) {
        String output="";
        for (Object obj:patientList
        ) {
            if ( obj instanceof String[])
            {
                Object[] array=(Object[]) obj;
                output+=" "+array[id];
            }
            else if ( obj instanceof  int[])
            {
                int[] array=(int[]) obj;
                output+=" "+array[id];
            }
        }
        System.out.println(output);
    }

    public static void main(String[] args) {


        Factory f1 = new Factory(1020);
        f1.createCar("medour","rychly","oranzove");
        System.out.println(f1.toString());

    }


}
