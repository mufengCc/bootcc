package com.cc.sys.Day03;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
@NoArgsConstructor
class FooBar5 {

    private int n;

    public FooBar5(int n) {
        this.n = n;
    }

    CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    volatile boolean flag = true;

    public void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (flag) {
                System.out.println("你");
                flag = false;
            }
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }

    }

    public void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("好");
            flag = true;
        }
    }


    public static void main(String[] args) {
        FooBar5 fooBar2 = new FooBar5(2);

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