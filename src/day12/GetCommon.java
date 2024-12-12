package day12;

import java.util.HashSet;
import java.util.Set;

public class GetCommon {
    /*
        给你两个整数数组 nums1 和 nums2 ，它们已经按非降序排序，请你返回两个数组的 最小公共整数 。
        如果两个数组 nums1 和 nums2 没有公共整数，请你返回 -1 。
        如果一个整数在两个数组中都 至少出现一次 ，那么这个整数是数组 nums1 和 nums2 公共 的。
        示例 1：
                输入：nums1 = [1,2,3], nums2 = [2,4]
                输出：2
                解释：两个数组的最小公共元素是 2 ，所以我们返回 2 。
        示例 2：
                输入：nums1 = [1,2,3,6], nums2 = [2,3,4,5]
                输出：2
                解释：两个数组中的公共元素是 2 和 3 ，2 是较小值，所以返回 2 。
     */
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 6}, num2 = {2, 3, 4, 5};
        System.out.println(getCommon(num1, num2));
    }

    // 方法一：
    public static int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1)
            set.add(i);
        for (int i : nums2) {
            if (set.contains(i))
                return i;
        }
        return -1;
    }

    // 方法二：
    public static int getCommon1(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else
                return nums1[i];
        }
        return -1;
    }
}
