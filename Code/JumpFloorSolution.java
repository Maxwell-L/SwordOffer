/*
 * 跳台阶
 * 题目描述:
 *     一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 思路:
 *     假设跳上一个 n 级台阶有 f(n) 种跳法，第一次跳上 1 级时，剩下 n-1 级台阶有 f(n-1) 种跳法; 第一次跳上 2 级台阶时，剩下 n-2 级台阶有
 * f(n-2) 种跳法，故有 f(n) = f(n-1) + f(n-2)。
 */
 
public class JumpFloorSolution {
    public int JumpFloor(int target) {
        if(target <= 2){
            return target;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}
