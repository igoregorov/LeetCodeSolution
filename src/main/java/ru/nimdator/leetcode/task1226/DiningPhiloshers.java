package ru.nimdator.leetcode.task1226;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {
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
                           Runnable putRightFork) throws InterruptedException {

        int leftFork = philosopher;
        int rightFork = philosopher != 4 ? philosopher + 1 : 0;

        if (philosopher % 2 == 0) {
            forks[rightFork].lock();
            pickRightFork.run();

            forks[leftFork].lock();
            pickLeftFork.run();
        } else {
            forks[leftFork].lock();
            pickLeftFork.run();

            forks[rightFork].lock();
            pickRightFork.run();
        }

        eat.run();

        if (philosopher % 2 == 0) {
            putRightFork.run();
            forks[rightFork].unlock();

            putLeftFork.run();
            forks[leftFork].unlock();
        } else {
            putLeftFork.run();
            forks[leftFork].unlock();

            putRightFork.run();
            forks[rightFork].unlock();
        }
    }
}
