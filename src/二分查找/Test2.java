package 二分查找;

/**
 * @description: 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * 在比较时，字母是依序循环出现的。举个例子：
 * 如果目标字母 target = 'z' 并且字符列表为letters = ['a', 'b']，则答案返回'a'
 * 输入: letters = ["c", "f", "j"]，target = "a"
 * 输出: "c"
 * @return:
 * @Author: M
 * @create: 2022/7/6 20:19
 */

public class Test2 {
    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target - letters[mid] >= 0) {
                left = mid + 1;
            } else if (target - letters[mid] < 0) {
                right = mid - 1;
            }
        }
        return letters[(right + 1) % letters.length];
    }

    public static void main(String[] args) {
        char[] s = {'c', 'f', 'j'};
        char target = 'j';
        System.out.println(nextGreatestLetter(s, target));
    }
}
