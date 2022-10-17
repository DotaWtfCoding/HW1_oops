/*
 * Coins.java
 *
 * Version:
 *     17.0.3
 *
 * Revisions:
 *     3
 */

/**
 * Class that represents the maximum coins problem
 *
 * @author      Vishal Panchidi
 * @author      Neeraj Bandi
 */
public class Coins {
    /**
     * coins used for input.
     */
    public static int[] coins = { 1, 4, 4, 5, 8};
    /**
     * toPay used for input.
     */
    public static int[] toPay = { 9, 6, 4, 7, 8};
    /**
     * Array used for storing the possible coins
     */
    public static int[] ans = new int[coins.length];
    /**
     * counter
     */
    public static int ansSize = 0;

    /**
     * Used as an entry channel to find the maximum Coins used to arrive at toPay.
     * @param coins : input coins
     * @param toPay: input toPay
     */

    private void opening(int[] coins, int[] toPay)
    {
        for(int index = 0;index < toPay.length; ++index){
            int[] storage = new int[coins.length];
            int storageSize = 0;
            int counter = 0;
            maximumCoins(toPay[index],counter,storage,storageSize);
            System.out.print(ansSize == 0?"NO ":"YES ");
            if(ansSize>0){
                for(int j = 0;j < ansSize; ++j){
                    System.out.print(ans[j]);
                    System.out.print(" ");
                }
            }
            System.out.println();
            ans = new int[coins.length];
            ansSize=0;
        }}

    /**
     * Finds the maximum coins used to get to the target in the toPay.
     * @param target :targeted toPay number
     * @param index : counter
     * @param storage :stores the possible output
     * @param storageSize :counter of coins.
     */
    private void maximumCoins(int target, int index,int[] storage, int storageSize)
    {
        if (target<0) return;
        if (target == 0 && storageSize > ansSize) {
            ans = storage.clone();
            ansSize = storageSize;
            return;
        }
        if (index == coins.length) {
            return;
        }
        storageSize += 1;
        storage[storageSize-1] = coins[index]; // add current coin to the end of the array
        maximumCoins(target-coins[index],index+1,storage,storageSize); // here current coin is considered in storage
        storageSize -= 1; // remove the coin added earlier
        maximumCoins(target,index+1,storage,storageSize);

    }

    /**
     * main method of the code.
     * @param args : Unused in the code.
     */

    public static void main(String[]args){
        Coins coin = new Coins();
        coin.opening(coins,toPay);
    }

}
