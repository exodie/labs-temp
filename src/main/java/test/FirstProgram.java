package test;

import test.FirstPackage.FirstPackage;

class FirstProgram {
    public static void main(String[] s) {
        FirstPackage firstPkg = new FirstPackage();

        int i, j;
        for (i = 1; i <= 8; i++) {
            for(j = 1; j <= 8; j++) {
                firstPkg.setA1(i);
                firstPkg.setA2(j);
                System.out.print(firstPkg.sum());
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}

