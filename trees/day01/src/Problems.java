public class Problems {

    public static int leastSum(int[] A) {
        //TODO

        if (A.length == 0) {
            return 0;
        }

        if (A.length == 1) {
            return A[0];
        }


        int max = 0;

        for (int i : A) {
            if (i > max) {
                max = i;
            }
        }

        int[] temp = new int[max+1];

        for (int i : A) {
            temp[i] += 1;
        }


        int half = A.length / 2;
        int[] first = new int[A.length - half];
        int[] second = new int[half];

        int firstIdx = 0;
        int secondIdx = 0;

        int i = 0;

        while (i < temp.length) {

            while (temp[i] != 0) {

                if (secondIdx > second.length || firstIdx > secondIdx) {
                    second[secondIdx] = i;
                    secondIdx +=1;
                } else {
                    first[firstIdx] = i;
                    firstIdx+=1;
                }
                temp[i] -= 1;
            }
            i+=1;


        }

        String firstnum = "";
        String secondnum = "";

        if (first == null || second == null) {
            if (first == null) {
                firstnum = "0";
            }

            if (second == null) {
                secondnum = "0";
            }
        } else {


            for (int f : first) {
                firstnum += Integer.toString(f);
            }
            for (int s : second) {
                secondnum += Integer.toString(s);
            }
        }

        int sum = Integer.parseInt(firstnum) + Integer.parseInt(secondnum);




        return sum;
    }
}
