package com.cc.sys.Day03;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.*;

@Getter
@Setter
@NoArgsConstructor
class FooBar3 {

    private int n;

    public FooBar3(int n) {
        this.n = n;
    }

    private BlockingQueue<Integer> bar = new LinkedBlockingQueue<>(1);
    private BlockingQueue<Integer> foo = new LinkedBlockingQueue<>(1);


    public void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.put(1);
            System.out.println("你");
            foo.take();

        }
    }

    public void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.take();
            System.out.println("好");
            foo.put(1);
        }
    }


    public static void main(String[] args) {
        FooBar3 fooBar2 = new FooBar3(2);


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