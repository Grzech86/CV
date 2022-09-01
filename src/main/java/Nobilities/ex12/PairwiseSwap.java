package Nobilities.ex12;


//Pairwise Swap: Write a program to swap odd and even bits in an integer with as few instructions as possible
// (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
public class PairwiseSwap {


    public static int bitSwap(int value) {
        int oddBits =  value & 0b10101010101010101010101010101010;
        int evenBits = value & 0b01010101010101010101010101010101;

        return (oddBits >>> 1) | (evenBits << 1);
    }

    public static void main(String[] args) {
        int result = bitSwap(17);
        System.out.println("result = " + result);
    }
}


