/**
 * @description: 从N个不同字符中任取M个字符组合
 * @return:
 * @Author: M
 * @create: 2022/6/30 12:49
 */

public class HOW1 {
    public static String[] combine(String s, int num) {
        StringBuffer stringBuffer = new StringBuffer();
        if (num == 1) {
            return s.split("");
        } else if (s.length() > num) {
            for (int i = 0; i < s.length() - num + 1; i++) {
                String subStr = s.substring(i + 1, s.length());
                String[] tempStr = combine(subStr, num - 1);
                for (int j = 0; j < tempStr.length; j++) {
                    String bufferStr = s.charAt(i) + tempStr[j];
                    stringBuffer.append(bufferStr + ",");
                }
            }
            String[] result = stringBuffer.toString().split(",");
            return result;
        } else {
            return new String[]{s};
        }
    }

    public static void main(String[] args) {
        String str = "abcd";
        String[] result = combine(str, 3);
        for (String t : result) {
            System.out.print(t + " ");
        }
    }
}
