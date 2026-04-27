class Solution1 {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long val = (long) mid * mid;

            if (val == x) {
                return mid;
            } else if (val > x) {
                right = mid - 1;
            } else {
                res = mid;
                left = mid + 1;
            }
        }

        return res;
    }
}

class Solution {
    public int mySqrt(int x) {
        if (x==0) {
            return 0;
        }

        if (x==1) {
            return 1;
        }
        int left = 1;
        int right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            long val = (long) mid * mid;

            if (val > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left-1;
    }
}