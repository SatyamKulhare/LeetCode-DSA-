import java.util.*;

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        // Coordinate Compression
        int[] temp = prefix.clone();
        Arrays.sort(temp);

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        for (int x : temp) {
            if (!map.containsKey(x)) {
                map.put(x, idx++);
            }
        }

        Fenwick bit = new Fenwick(idx);

        long ans = 0;

        for (int x : prefix) {
            int pos = map.get(x);

            // Count previous prefix sums < current prefix sum
            ans += bit.query(pos - 1);

            bit.update(pos, 1);
        }

        return ans;
    }

    class Fenwick {
        int[] tree;

        Fenwick(int n) {
            tree = new int[n + 1];
        }

        void update(int i, int val) {
            while (i < tree.length) {
                tree[i] += val;
                i += i & -i;
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }
}