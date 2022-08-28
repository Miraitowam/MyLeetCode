package 滑动窗口;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Test1 {
    public int lengthOfLongestSubstring(String s) {
        //维护一个最长的不重复set
        Set<Character> set = new HashSet<>();
        //定义左右指针
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {    //如果不包含右边界那就添加移动右边界
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
          res = Math.max(res,set.size());
        }
        return res;
    }
    @Test
    public void test(){
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
