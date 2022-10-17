
/*
 * NumberEqualCube.java
 *
 * Version:
 *     17.0.3
 *
 * Revisions:
 *     2
 */

/**
 * This program produces a table for unique set of numbers where the addition of
 * all the numbers to the power of their length is equal to the actual number.
 * All such numbers between 1 to 100000 are displayed in the output.
 *
 * @author      Vishal Panchidi
 * @author      Neeraj Bandi
 */

public class NumberEqualCube {
    public static void main(String[] args) {
        for(int number = 1; number <= 100000; number++){
            // Saving the copy of the number to later compare with the final answer.
            int copyOfNumber = number;

            int sumOfPowers = 0;
            // Converts the number to the character array.
            char[] nAsCharcters = ("" + copyOfNumber).toCharArray();
            String answerOfPower = "";

            /**
             * Prints the Addition of the power of each element of the number.
             * Stores the finalAnswer of every number between 1 to 100000
             */

            for(int index = 0; index < nAsCharcters.length; index++){
                sumOfPowers = sumOfPowers +
                        (powerFunction(
                                Character.getNumericValue(nAsCharcters[index]), nAsCharcters.length
                        ));
                String additionSymbol = (index == nAsCharcters.length-1) ? " " : " + ";
                answerOfPower = answerOfPower.concat(nAsCharcters[index] +
                        "^" +
                        nAsCharcters.length +
                        additionSymbol);
            }

            /**
             * Checks if the sum of the powers are equal to the actual number.
             * Prints the output if the sum of the powers are equal to the actual number
             */

            if (sumOfPowers == copyOfNumber){
                System.out.println(sumOfPowers + " = " + answerOfPower);
            }
        }
    }

    /**
     * Returns the required exponent value of the number.
     */

    public static int powerFunction(int number,int power){
        int powerOfTheNumber=1;
        for(int index = 0; index < power; index++){
            powerOfTheNumber = powerOfTheNumber * number;
        }
        return powerOfTheNumber;
    }
}
