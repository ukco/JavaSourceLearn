package cn.humblecodeukco.test.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author lyr
 * @Date 2020/12/22 12:12
 * @Version 1.0
 * @Description HJ49. 多线程
 */
public class HJ49Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            CountDownLatch countDownLatch = new CountDownLatch(4);
            AlternativePrint alternativePrint = new AlternativePrint();
            // 创建四个线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < n; ++i) { alternativePrint.printA(); }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < n; ++i) { alternativePrint.printB(); }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < n; ++i) { alternativePrint.printC(); }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < n; ++i) { alternativePrint.printD(); }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }).start();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}

class AlternativePrint {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    private Condition conditionD = lock.newCondition();
    private int number = 1;

    void printA() {
        lock.lock();
        try {
            if (number != 1) { conditionA.await(); }
            System.out.print("A");
            // "A"打印结束，标记置为2，并唤醒打印"B"的线程
            number = 2;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void printB() {
        lock.lock();
        try {
            if (number != 2) { conditionB.await(); }
            System.out.print("B");
            // "B"打印结束，标记置为3，并唤醒打印"C"的线程
            number = 3;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void printC() {
        lock.lock();
        try {
            if (number != 3) { conditionC.await(); }
            System.out.print("C");
            // "C"打印结束，标记置为4，并唤醒打印"D"的线程
            number = 4;
            conditionD.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void printD() {
        lock.lock();
        try {
            if (number != 4) { conditionD.await(); }
            System.out.print("D");
            // "D"打印结束，标记置为1，并唤醒打印"A"的线程
            number = 1;
            conditionA.signal();
        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
