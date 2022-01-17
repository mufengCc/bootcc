package com.cc.sys.Day01;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

class Foo4 {

    public Foo4() {
        
    }

    CyclicBarrier semaphore_se = new CyclicBarrier(0);
    CyclicBarrier semaphore_third = new CyclicBarrier(0);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();

    }

    public void second(Runnable printSecond) throws InterruptedException {
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        printThird.run();
    }

}