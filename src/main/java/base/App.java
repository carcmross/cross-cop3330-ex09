package base;

import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Marc-Anthony Cross
 */

/*
 * Sometimes you have to round up to the next number rather than follow standard rounding rules.
 *
 * Calculate gallons of paint needed to paint the ceiling of a room. Prompt for the length and width, and assume one
 * gallon covers 350 square feet. Display the number of gallons needed to paint the ceiling as a whole number.
 * Example Output
 *
 * You will need to purchase 2 gallons of paint to cover 360 square feet.
 *
 * Remember, you can’t buy a partial gallon of paint. You must
 * round up to the next whole gallon.
 * Constraints
 *
 *     Use a constant to hold the conversion rate.
 *     Ensure that you round up to the next whole number.
 *
 * Challenges
 *
 *     Revise the program to ensure that inputs are entered as numeric values. Don’t allow the user to proceed if
 *     the value entered is not numeric.
 *     Implement support for a round room.
 *     Implement support for an L-shaped room.
 *     Implement a mobile version of this app so it can be used at the hardware store.
 *
 */

public class App {
    static Scanner in = new Scanner(System.in);
    static final double CONVERSION_RATE = 180;

    public static void main(String[] args) {
        App myApp = new App();
        String length = myApp.getLength();
        String width = myApp.getWidth();
        String area = myApp.calcArea(length, width);
        String numGallons = myApp.calcGallons(area, CONVERSION_RATE);
        String outputString = myApp.generateOutput(numGallons, area);
        myApp.printOutput(outputString);
    }

    private void printOutput(String outputString) {
        System.out.println(outputString);
    }

    private String generateOutput(String numGallons, String area) {
        return "You will need to purchase " + numGallons + " gallons of paint to cover " + area + " square feet.";
    }

    private String getLength() {
        System.out.print("What is the length of the ceiling? ");
        String length = in.nextLine();
        return length;
    }

    private String getWidth() {
        System.out.print("What is the width of the ceiling? ");
        String width = in.nextLine();
        return width;
    }

    private String calcArea(String length, String width) {
        int area = Integer.parseInt(length) * Integer.parseInt(width);
        return String.valueOf(area);
    }

    private String calcGallons(String area, final double CONVERSION_RATE) {
        int numGallons = (int) (Math.ceil(Integer.parseInt(area) / CONVERSION_RATE));
        return String.valueOf(numGallons);
    }
}
