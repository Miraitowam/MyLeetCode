package 链表;


/**
 * @description:
 * @return:
 * @Author: M
 * @create: 2022/7/20 20:05
 */

public class Test3 {
    public class ListNodes {
        int val;
        ListNodes next;

        ListNodes(int x) {
            val = x;
            next = null;
        }
    }

    public ListNodes mergeTwoLists(ListNodes list1, ListNodes list2) {
        //如果都为空就返回空
        if (list1 == null && list2 == null) return null;
        //其中一个为空就返回不为空的那条
        if (list1 == null || list2 == null) return list1 == null ? list2 : list1;
        ListNodes dumpy = new ListNodes(-1);
        ListNodes pre = null;
        while (list1 != null && list2 != null) {
            //如果两个不为空那就为小的那个
            if (list1 != null && list2 != null) {
                pre = list1.val >= list2.val ? list2 : list1;
                //更小的继续往前走
                list1 = list1.val >= list2.val ? list1 : list1.next;
                list2 = list1.val >= list2.val ? list2.next : list2;
                //添加节点
                dumpy.next = pre;
                pre = pre.next;
            }
            //如果一个循环为空了那就让其为不为空的那个
            if (list1 == null || list2 == null){
                dumpy.next = list1 == null ? list2 : list1;
                break;
            }
        }
        return dumpy.next;
    }
}
