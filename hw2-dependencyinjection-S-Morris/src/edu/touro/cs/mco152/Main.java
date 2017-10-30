package edu.touro.cs.mco152;

interface ElapsedTimeClockI{
    long currentTimeMillis();
}
class ElapsedTimeClock implements ElapsedTimeClockI{
    public long currentTimeMillis(){
        return System.currentTimeMillis();
    }
}
class ElapsedTimeClock2 implements ElapsedTimeClockI{
    public long currentTimeMillis(){
        return System.nanoTime() / 1_000_000;
    }
}
class Timer {

    public Timer(ElapsedTimeClockI etc){ // dependency injection Timer is dependent on ElapsedTimeClockI
        clock = etc;
    }
    private long startMs;
    private long stopMs;
    private boolean isStopped;
    private ElapsedTimeClockI clock;

    public void start() {

        isStopped = true;
        startMs = clock.currentTimeMillis();
    }

    public void stop() {
        isStopped = true;
        stopMs = clock.currentTimeMillis();
    }

    public void reset() {
        startMs = clock.currentTimeMillis();
    }

    public long getElapsedTime() {
        return (isStopped ? stopMs : clock.currentTimeMillis()) - startMs;
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println("Hooray!");
    }

    int foo(){
        return 1;
    }
}
