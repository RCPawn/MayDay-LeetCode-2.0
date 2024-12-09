package day11;

public class NumberOfSpecialChars {
    /*
        给你一个字符串 word。
        如果 word 中同时存在某个字母的小写形式和大写形式，
        则称这个字母为 特殊字母 。
        返回 word 中 特殊字母 的数量。
        示例 1:
                输入：word = "aaAbcBC"
                输出：3
                解释：word 中的特殊字母是 'a'、'b' 和 'c'。
        示例 2:
                输入：word = "abc"
                输出：0
                解释：word 中不存在大小写形式同时出现的字母。
        示例 3:
                输入：word = "abBCab"
                输出：1
                解释：word 中唯一的特殊字母是 'b'。
     */
    public static void main(String[] args) {
        String word = "aaAbcBC";
        System.out.println(numberOfSpecialChars(word));
    }

    // 方法一：
    public static int numberOfSpecialChars(String word) {
        int[] count = new int[256];
        for (char c : word.toCharArray())
            count[c]++;
        int res = 0;
        for (int i = 0; i <= 90; i++)
            res = (count[i] != 0 && count[i + 32] != 0) ? res + 1 : res;
        return res;
    }

    // 方法二：
    public static int numberOfSpecialChars1(String word) {
        int[] mask = new int[2];
        for (char c : word.toCharArray())
            mask[c >> 5 & 1] |= 1 << (c & 31);
        return Integer.bitCount(mask[0] & mask[1]);
    }
}
