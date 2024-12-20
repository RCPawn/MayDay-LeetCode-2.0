package day11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EqualFrequency {
    /*
        给你一个下标从 0 开始的字符串 word ，字符串只包含小写英文字母。
        你需要选择 一个 下标并 删除 下标处的字符，使得 word 中剩余每个字母出现 频率 相同。
        如果删除一个字母后，word 中剩余所有字母的出现频率都相同，
        那么返回 true ，否则返回 false 。
        注意：
                字母 x 的 频率 是这个字母在字符串中出现的次数。
                你 必须 恰好删除一个字母，不能一个字母都不删除。
        示例 1：
                输入：word = "abcc"
                输出：true
                解释：选择下标 3 并删除该字母：word 变成 "abc" 且每个字母出现频率都为 1 。
        示例 2：
                输入：word = "aazz"
                输出：false
                解释：我们必须删除一个字母，所以要么 "a" 的频率变为 1 且 "z" 的频率为 2 ，
                要么两个字母频率反过来。所以不可能让剩余所有字母出现频率相同。
     */
    public static void main(String[] args) {
        String word = "aazz";
        System.out.println(equalFrequency(word));
    }

    // 方法一：
    public static boolean equalFrequency(String word) {
        for (int i = 0; i < word.length(); i++) {  // 枚举删除的字符
            // 删除字符并统计出现次数
            String newWord = word.substring(0, i) + word.substring(i + 1);
            Map<Character, Integer> countMap = new HashMap<>();
            for (char c : newWord.toCharArray())
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);

            // 如果所有字符的出现次数都相同，则返回 true
            Set<Integer> set = new HashSet<>(countMap.values());
            if (set.size() == 1)
                return true;
        }
        return false;
    }

    // 方法二：
    public static boolean equalFrequency1(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray())
            count[c - 'a']++;
        for (char c : word.toCharArray()) {
            count[c - 'a']--;
            HashSet<Integer> frequency = new HashSet<>();
            for (int f : count) {
                if (f > 0)
                    frequency.add(f);
            }
            if (frequency.size() == 1)
                return true;
            count[c - 'a']++;
        }
        return false;
    }
}
