package edu.touro.cs.mco152;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// imitation clock...pretends to behave like a clock
class MockClock implements ElapsedTimeClockI{

    MockClock(long ... vals){
        returnValues = vals;
    }
    private int counter = 0;
    private long returnValues[];

    @Override
    public long currentTimeMillis() {
        return returnValues[counter++];
    }
}

public class TimerTest {

    @Test
    void getElapsedTimeWhenStartStopShouldBe1003() {
        ElapsedTimeClockI clock = new MockClock(13, 1016, -1);
        Timer t = new Timer( clock );

        t.start();
        t.stop();

        assertEquals(1003, t.getElapsedTime());
    }

}
