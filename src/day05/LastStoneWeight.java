package day05;

import java.util.*;

public class LastStoneWeight {
    /*
        有一堆石头，每块石头的重量都是正整数。
        每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。
        假设石头的重量分别为 x 和 y，且 x <= y。
        那么粉碎的可能结果如下：
        如果 x == y，那么两块石头都会被完全粉碎；
        如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
        最后，最多只会剩下一块石头。
        返回此石头的重量。
        如果没有石头剩下，就返回 0。
        示例：
            输入：[2,7,4,1,8,1]
            输出：1
            解释：
                先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
                再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
                接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
                最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
     */
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones));
    }

    // 方法一：
    public static int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int stone : stones) {
            list.add(stone);
        }
        while (list.size() > 1) {
            Collections.sort(list);
            int y = list.remove(list.size() - 1); // 移除最大值
            int x = list.remove(list.size() - 1); // 移除次大值
            if (x != y)
                list.add(y - x); // 添加新的石头重量
        }
        return list.isEmpty() ? 0 : list.get(0);
    }

    // 方法二：
    public static int lastStoneWeight1(int[] stones) {
        int n = stones.length - 1;
        while (n >= 1) {
            Arrays.sort(stones);
            stones[n - 1] = stones[n] - stones[n - 1];
            n--;
        }
        return stones[0];
    }

    // 方法三：
    public static int lastStoneWeight2(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
