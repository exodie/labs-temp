package org.example;

import org.example.FirstPackage.*;

class FirstProgram {
    public static void main(String[] s) {
        FirstPackage o = new FirstPackage();

        int i, j;
        for (i = 1; i <= 8; i++) {
            for(j = 1; j <= 8; j++) {
                o.setA1(i);
                o.setA2(j);
                System.out.print(o.sum());
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

