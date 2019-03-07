import java.util.LinkedList;

public class Problems {

    static void sortNumsBetween100s(int[] A) {
        // TODO

        int[] negative = new int[A.length];
        int negIdx = 0;
        int[] positive = new int[A.length];
        int posIdx = 0;

        for (Integer e: A) {
            if (e >= 0) {
               positive[posIdx] = e;
               posIdx += 1;
            } else {
                negative[negIdx] = -1* e;
                negIdx += 1;
            }
        }

        RadixSort.radixSort(negative,10);
        RadixSort.radixSort(positive,10);
        int AIdx = 0;

        for (int i=negative.length -1; i>=negative.length - negIdx; i--) {
            int temp = negative[i]*-1;
            A[AIdx] = temp;
            AIdx += 1;
        }
        int d = positive.length - posIdx;
        for (int i=d; AIdx<A.length; i++) {
            A[AIdx] = positive[i];
            AIdx += 1;
        }



    }

    /**
     * @param n the character number, 0 is the rightmost character
     * @return
     */
    private static int getNthCharacter(String s, int n) {
        return s.charAt(s.length() - 1 - n) - 'a';
    }


    /**
     * Use counting sort to sort the String array according to a character
     *
     * @param n The digit number (where 0 is the least significant digit)
     */
    static void countingSortByCharacter(String[] A, int n) {
        // TODO
        LinkedList<String>[] L = new LinkedList[26];
        for (int i = 0; i < 26; i++)
            L[i] = new LinkedList<>();
        for (String i : A) {
            // TODO: Extract the relevant digit from i, and add i to the corresponding Linked List.
            L[getNthCharacter(i,n)].add(i);

        }
        int i = 0; // index in A to place numbers
        for (LinkedList<String> list : L) {
            // TODO: Put all numbers in the linked lists into A
            for (String e : list) {
                A[i] = e;
                i+=1;
            }
        }


    }

    /**
     * @param stringLength The length of each of the strings in S
     */
    static void sortStrings(String[] S, int stringLength) {
        // TODO


        // TODO: Perform radix sort

        for (int i = 0; i < stringLength; i++) {

            countingSortByCharacter(S,i);
        }


    }

    /**
     * @param A The array to count swaps in
     */

    public static int countSwaps(int[] A) {
        // TODO
        return 0;
    }

}
