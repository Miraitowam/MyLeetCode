package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    多个线程之间按顺序调用,实现A->B->C
三个线程启动,要求如下:
    AA打印5次,BB打印10次,CC打印15次
    接着
    AA打印5次,BB打印10次,CC打印15次
    ....来10轮
* */
public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) shareResource.print5();
        }, "线程A").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) shareResource.print10();
        }, "线程B").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) shareResource.print15();
        }, "线程C").start();
    }
}

class ShareResource {
    public ShareResource() {
    }

    //设置一个标识,如果是number=1,线程A执行...
    private int number = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    //打印5次
    public void print5() {
        lock.lock();
        //1.判断
        try {
            while (number != 1) {
                condition1.await();
            }
            //2.干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":\t" + i);
            }
            //3.唤醒
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            //1.判断
            while (number != 2) {
                condition2.await();
            }
            //2.干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":\t" + i);
            }
            //3.唤醒
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            //1.判断
            while (number != 3) {
                condition3.await();
            }
            //2.干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + ":\t" + i);
            }
            //3.唤醒
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
