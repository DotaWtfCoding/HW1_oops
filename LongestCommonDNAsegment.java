
/*
 * LongestCommonDNAsegment.java
 *
 * Version:
 *     17.0.3
 *
 * Revisions:
 *     2
 */

/**
 * This program helps to find the largest common substring between two given strings.
 *
 * @author      Vishal Panchidi
 * @author      Neeraj Bandi
 */


public class LongestCommonDNAsegment {

    /**
     * Prints the two given input strings.
     */
    public static  void printTheDNA(String label, char[] theDNA) {
        System.out.print(label);
        for ( int index = 0; index < theDNA.length; index ++)
            System.out.print( theDNA[index]);
        System.out.println();
    }

    /**
     * Initiates the counter for the common substrings.
     * Increments the counter for common substrings.
     * Returns the largest number of substring in the given two strings
     */
    static int findLongestCommonDNAsegment(char[] dnaOne, char[] dnaTwo){
        int counter = 0;
        int largestSubstringCount = 0;

        // Using the sliding window approach, sliding the first array towards left.

        for(int slide = 0; slide < dnaOne.length; slide++){
            for(int index = 0; index<dnaTwo.length; index++){
                if((slide + index) < dnaOne.length){
                    if (dnaOne[slide + index] == dnaTwo[index]) {
                        counter++;

                        //Updates the final answer with the largest common substring count.
                        if (counter > largestSubstringCount) {
                            largestSubstringCount = counter;
                        }
                    }
                }
            }
            counter = 0;
        }
        return largestSubstringCount;
    }

    /**
     * Swaps the strings for the sliding window approach
     * and helps to get the number of largest common substring .
     */

    public static void main(String[] args) {
        int finalAnswer;
        char[] dnaOne = {'t','a','c','g','g'};
        char[] dnaTwo = {'a','c','g','t'};
        printTheDNA("first DNA:         ", dnaOne);
        printTheDNA("second DNA:        ", dnaTwo);
        int slideWindowOne = findLongestCommonDNAsegment(dnaOne,dnaTwo);
        int slideWindowTwo = findLongestCommonDNAsegment(dnaTwo,dnaOne);

        finalAnswer = (slideWindowOne > slideWindowTwo)?(slideWindowOne):(slideWindowTwo);
        System.out.print("Longest in common:	" + finalAnswer);
    }
}
