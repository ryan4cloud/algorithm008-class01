import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 *
 * https://leetcode-cn.com/problems/walking-robot-simulation/description/
 *
 * algorithms
 * Easy (34.08%)
 * Likes:    88
 * Dislikes: 0
 * Total Accepted:    7.7K
 * Total Submissions: 22.4K
 * Testcase Example:  '[4,-1,3]\n[]'
 *
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * 
 * 
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 
 * 
 * 在网格上有一些格子被视为障碍物。
 * 
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * 
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * 
 * 返回从原点到机器人的最大欧式距离的平方。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 
 * 
 * 示例 2：
 * 
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于 2 ^ 31
 * 
 * 
 */

// @lc code=start
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[] {0, 1, 0, -1}; // x坐标方向
        int[] dy = new int[] {1, 0, -1, 0}; // y坐标方向
        int x = 0, y = 0, di = 0; // 初始化起始坐标和方向索引
        int res = 0; // 初始化返回值
        Set<String> set = new HashSet<>(); // 障碍物坐标保存为字符串
        for (int[] ob : obstacles) {
            set.add(ob[0] + "," + ob[1]);
        }
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                di = (di + 3) % 4;
            } else if (commands[i] == -1) {
                di = (di + 1) % 4;
            } else {
                for (int j = 0; j < commands[i]; j++) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    if (!set.contains(nx + "," + ny)) {
                        x = nx;
                        y = ny;
                        res = Math.max(res, x * x + y * y);
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

