package day07;

public class MaxAscendingSum {
    /*
        给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
        子数组是数组中的一个连续数字序列。
        已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
        若对所有 i（l <= i < r），numsi  < numsi+1 都成立，
        则称这一子数组为 升序 子数组。
        注意，大小为 1 的子数组也视作 升序 子数组。
        示例 1：
                输入：nums = [10,20,30,5,10,50]
                输出：65
                解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
        示例 2：
                输入：nums = [10,20,30,40,50]
                输出：150
                解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。
        示例 3：
                输入：nums = [12,17,15,13,10,11,12]
                输出：33
                解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。
        示例 4：
                输入：nums = [100,10,1]
                输出：100
     */
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 5, 10, 50};
        System.out.println(maxAscendingSum(nums));
    }

    // 方法一：
    public static int maxAscendingSum(int[] nums) {
        int sum = nums[0];
        int res = sum;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                res = Math.max(res, sum);
                sum = nums[i];
            }
        }
        return Math.max(res, sum);
    }


    // 方法二：
    public static int maxAscendingSum1(int[] nums) {
        int l = 0, r = 1, res = 0;
        int n = nums.length;

        while (l < n) {
            while (r < n && nums[r - 1] < nums[r])
                r++;

            int sum = 0;
            for (int j = l; j < r; j++)
                sum += nums[j];

            res = Math.max(res, sum);
            l = r;
            r = l + 1;
        }
        return res;
    }
}
