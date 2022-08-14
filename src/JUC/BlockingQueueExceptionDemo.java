package JUC;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

//阻塞队列
public class BlockingQueueExceptionDemo {
    public static void main(String[] args) {
        //List list=new ArrayList();
        //注意:这里要给一个初始值
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        //add() 方法是给ArrayBlockingQueue添加元素,如果超过会抛出异常!
        System.out.println(blockingQueue.add("a"));//true
        System.out.println(blockingQueue.add("b"));//true
        System.out.println(blockingQueue.add("c"));//true
        //element是检查元素有没有? 检查的是出栈的元素
        blockingQueue.element();

        //remove()
        System.out.println(blockingQueue.remove());//a
        System.out.println(blockingQueue.remove());//b
        System.out.println(blockingQueue.remove());//c
    }

    @Test
    public void offerAndPoll() throws Exception {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        //前三个直接成功
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        //下面这个会阻塞2s
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
    }
}
