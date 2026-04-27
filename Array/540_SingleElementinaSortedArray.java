class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int leftElements = left - mid + 1;
            int rightElements = right - mid + 1;

            if (nums[mid] == nums[mid + 1]) {
                if (rightElements % 2 == 0) {
                    right = mid - 1;
                } else {
                    left = mid + 2;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if (leftElements % 2 == 0) {
                    left = mid + 1;
                } else {
                    right = mid - 2;
                }
            } else {
                return nums[mid];
            }
        }

        return nums[left];
    }
}