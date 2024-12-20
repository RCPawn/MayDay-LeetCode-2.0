package day06;

public class FindNumbers {
    /*
        给你一个整数数组 nums，请你返回其中 位数为 偶数 的数字的个数。
        示例 1：
                输入：nums = [12,345,2,6,7896]
                输出：2
                解释：
                    12 是 2 位数字（位数为偶数）
                    345 是 3 位数字（位数为奇数）
                    2 是 1 位数字（位数为奇数）
                    6 是 1 位数字 位数为奇数）
                    7896 是 4 位数字（位数为偶数）
                    因此只有 12 和 7896 是位数为偶数的数字
        示例 2：
                输入：nums = [555,901,482,1771]
                输出：1
                解释：
                    只有 1771 是位数为偶数的数字。
     */
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int len = 0;
            while (num > 0) {
                num /= 10;
                len++;
            }
            if (len % 2 == 0)
                res++;
        }
        return res;
    }

    public static int findNumbers1(int[] nums) {
        int res = 0;
        for (int num : nums) {
            if (Integer.toString(num).length() % 2 == 0)
                res++;
        }
        return res;
    }
}
