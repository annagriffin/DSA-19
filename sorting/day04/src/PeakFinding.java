import java.util.Arrays;

public class PeakFinding {

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakOneD(int i, int[] nums) {
        if (i > 0 && nums[i] < nums[i - 1])
            return -1;
        if (i < nums.length - 1 && nums[i] < nums[i + 1])
            return 1;
        return 0;
    }

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakX(int x, int y, int[][] nums) {
        if (x > 0 && nums[y][x] < nums[y][x - 1])
            return -1;
        if (x < nums[0].length - 1 && nums[y][x] < nums[y][x + 1])
            return 1;
        return 0;
    }

    // Return -1 if up is higher, 1 if down is higher, 0 if peak
    private static int peakY(int x, int y, int[][] nums) {
        if (y > 0 && nums[y][x] < nums[y - 1][x])
            return -1;
        if (y < nums.length - 1 && nums[y][x] < nums[y + 1][x])
            return 1;
        return 0;
    }

    // These two functions return the index of the highest value along the X or Y axis, with the given
    // value for the other axis. Searches between hi (exclusive) and lo (inclusive)
    private static int maxXIndex(int y, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int x = lo; x < hi; x++) {
            if (maxIndex == -1 || nums[y][x] > nums[y][maxIndex])
                maxIndex = x;
        }
        return maxIndex;
    }

    private static int maxYIndex(int x, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int y = lo; y < hi; y++) {
            if (maxIndex == -1 || nums[y][x] > nums[maxIndex][x])
                maxIndex = y;
        }
        return maxIndex;
    }


    public static int findOneDPeak(int[] nums) {
        // TODO
//        for (int i : nums) {
//            System.out.println(i);
//        }
//        System.out.println(" ");

        int middle = nums.length /2;

        int high = nums.length-1;
        int low = 0;
        int i = 0;





        while (i<nums.length) {
            int result = peakOneD(middle, nums);
            if (result == 0) {
                return middle;
            } else if (result == 1) {
                low = middle+1;


            } else if (result == -1) {
                high = middle-1;


            }
            i++;
            middle = (low+high)/2;

        }

        return middle;

    }

    public static int[] findTwoDPeak(int[][] nums) {
        // TODO

        int middleX = nums[0].length /2;
        int middleY = nums.length /2;

        int highX = nums[0].length -1;
        int lowX = 0;

        int highY = nums.length -1;
        int lowY = 0;
        int[] answer = new int[2];

       // (middleX < nums.length-1 || middleX > 0 ) && (middleY > 0 || middleY < nums[0].length-1)
        int i = 0;

        while (i<nums.length){
            int resultX = peakX(middleX,middleY,nums);
            int resultY = peakY(middleX,middleY,nums);

            if (resultX == 0 && resultY == 0) {
                answer[0] = middleX;
                answer[1] = middleY;

                return answer;
            } else {
                if (resultX == 1) {
                    lowX = middleX +1;
                }
                if (resultX == -1) {
                    highX = middleY -1;
                }
//                if (resultY == 1) {
//                    lowY = middleY+1;
//                }
//                if (resultY == -1) {
//                    highY = middleY -1;
//                }
                if (resultX == 0) {
                    if (resultY == 1) {
                        lowY = middleY + 1;
                    }
                    if (resultY == -1) {
                        highY = middleY - 1;
                    }
                }
//            }
//            } else if (resultX == 1 && resultY == 1){
//                lowX = middleX+1;
//                lowY = middleY+1;
//
//            } else if (resultX == 1 && resultY == -1) {
//                lowX = middleX+1;
//                highY = middleY -1;
//
//            } else if (resultX == -1 && resultY == 1) {
//                highX = middleX-1;
//                lowY = middleY +1;
//
//            } else if (resultX == -1 && resultY == -1) {
//                highX = middleX-1;
//                highY = middleY-1;
//
//            } else if (resultX == 0 && resultY == 1) {
//                lowY = middleY +1;
//
//            } else if (resultX == 0 && resultY == -1) {
//                lowY = middleY+1;
//
//            } else if (resultX == -1 && resultY == 0) {
//                highX = middleX-1;
//
//            } else if (resultX == 1 && resultY == 0) {
//                lowX = middleX +1;
            }

            middleX = (highX+lowX) / 2;
            middleY = (highY+lowY) / 2;
            i++;

        }


        return answer;
    }

}
