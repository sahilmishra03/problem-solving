// GOT TLE IN THIS APPROACH

import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    int count;

    public int countArrangement(int n) {
        count = 0;
        backtrack(n, new ArrayList<Integer>(), new HashSet<Integer>());
        return count;
    }

    public void backtrack(int n, ArrayList<Integer> ls, HashSet<Integer> set) {
        // code here
        if (ls.size() == n) {
            boolean flag = true;
            int tracker = 1;
            for (int i = 0; i < ls.size(); i = i + 1) {
                if (tracker % ls.get(i) != 0 && ls.get(i) % tracker != 0) {
                    flag = false;
                    break;
                }

                tracker++;
            }

            if (flag) {
                count++;
            }

            return;
        }

        for (int i = 1; i <= n; i = i + 1) {
            if (!set.contains(i)) {
                ls.add(i);
                set.add(i);
                backtrack(n, ls, set);
                set.remove(i);
                ls.remove(ls.size() - 1);
            }
        }
    }
}