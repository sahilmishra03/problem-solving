package Array;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ArrayList<Integer> ls = map.get(nums[i]);
                ls.add(i);
                map.put(nums[i], ls);
            } else {
                ArrayList<Integer> ls = new ArrayList<>();
                ls.add(i);
                map.put(nums[i], ls);
            }
        }
        long[] finalSum = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            long sum =0;
            for (int k = 0; k < map.get(nums[i]).size(); k++) {
                sum+=Math.abs(i-map.get(nums[i]).get(k));
            }
            finalSum[i]=sum;
        }

        return finalSum;
    }
}