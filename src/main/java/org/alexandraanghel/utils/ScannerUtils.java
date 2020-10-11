package org.alexandraanghel.utils;

import java.util.Scanner;

public class ScannerUtils {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int nextIntAndMoveToNextLine()
    {
        try {
            return SCANNER.nextInt();
        } finally {
            SCANNER.nextLine();
        }
    }

    public static String nextLine()
    {
        return SCANNER.nextLine();
    }

    public static double nextDoubleAndMoveToNextLine()
    {
        try {
            return SCANNER.nextDouble();
        } finally {
            SCANNER.nextLine();
        }
    }

}
