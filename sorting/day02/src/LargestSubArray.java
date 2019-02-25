import java.util.HashMap;

public class LargestSubArray {
    static int[] largestSubarray(int[] nums) {
        // TODO

        // O(N)


        for (int i=0; i<nums.length; i++) {

            if (nums[i] == 0) {
                nums[i] = -1;
            } else {
                nums[i] = 1;
            }

        }

        HashMap<Integer, Integer> hash = new HashMap<>();


        int sum = 0;
        int size = 0;
        int endIdx = -1;


        for (int i=0; i < nums.length; i++) {

            sum += nums[i];

            if (sum==0) {
                size = i+1;
                endIdx = i;
            }

            boolean hashKey = hash.containsKey(sum+nums.length);

            if (hashKey) {
                if (size < i - hash.get(sum+nums.length)) {
                    size = i - hash.get(sum + nums.length);
                    endIdx = i;
                }
            } else {
                hash.put(sum + nums.length, i);
            }


        }
        int startIdx = endIdx - size + 1;

        System.out.print(startIdx);
        System.out.print(endIdx);

        return new int[]{startIdx,endIdx};
    }
}
