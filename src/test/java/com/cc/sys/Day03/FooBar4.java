package com.cc.sys.Day03;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
@NoArgsConstructor
class FooBar4 {

    private int n;

    public FooBar4(int n) {
        this.n = n;
    }

    private Lock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();
    volatile boolean flag = true;

    public void foo() throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                while (!flag) {
                    condition.await();
                }
                System.out.println("你");
                flag = false;
                condition.signal();
            }
        } finally {
            lock.unlock();
        }

    }

    public void bar() throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                while (flag) {
                    condition.await();
                }
                System.out.println("好");
                flag = true;
                condition.signal();
            }
        } catch (Exception e) {
            lock.unlock();
        }

    }


    public static void main(String[] args) {
        FooBar4 fooBar2 = new FooBar4(2);

        new Thread(() -> {
            try {
                fooBar2.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fooBar2.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }


}