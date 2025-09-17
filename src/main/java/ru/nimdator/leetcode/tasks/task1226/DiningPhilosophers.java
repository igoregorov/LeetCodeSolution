package ru.nimdator.leetcode.tasks.task1226;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class DiningPhilosophers {
    private final Lock[] forks = new Lock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) {

        int rightFork = philosopher != 4 ? philosopher + 1 : 0;

        if (philosopher % 2 == 0) {
            forks[rightFork].lock();
            pickRightFork.run();

            forks[philosopher].lock();
            pickLeftFork.run();
        } else {
            forks[philosopher].lock();
            pickLeftFork.run();

            forks[rightFork].lock();
            pickRightFork.run();
        }

        eat.run();

        if (philosopher % 2 == 0) {
            putRightFork.run();
            forks[rightFork].unlock();

            putLeftFork.run();
            forks[philosopher].unlock();
        } else {
            putLeftFork.run();
            forks[philosopher].unlock();

            putRightFork.run();
            forks[rightFork].unlock();
        }
    }
}
