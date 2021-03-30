package com.kidongyun.algorithm.queue;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class QueueRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        Queue<Integer> q = new Queue<>();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        System.out.println(q.dequeue());
        System.out.println(q.isEmpty());
        System.out.println(q.dequeue());
        System.out.println(q.isEmpty());
    }
}
