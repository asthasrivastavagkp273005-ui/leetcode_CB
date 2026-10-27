
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    void solve(int index, int[] arr, int target,
               List<Integer> temp, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }

            if (arr[i] > target) {
                break;
            }

            temp.add(arr[i]);

            solve(i + 1, arr, target - arr[i], temp, ans);

            temp.remove(temp.size() - 1);
        }
    }
}
