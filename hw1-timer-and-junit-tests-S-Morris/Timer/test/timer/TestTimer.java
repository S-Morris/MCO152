/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shmuel
 */
public class TestTimer {

    @Test
    public void testStartTimerOrdinary() {
        Timer timer = new Timer();
        timer.startTimer();
        for (int i = 0; i < 10000; i++) {
            System.out.print("");
        }
        timer.stopTimer();

        long getTime = timer.getAccumulatedTimer();

        assertTrue(getTime > 0);
    }

    @Test
    public void testStartResetNoStop() {
        Timer timer = new Timer();
        timer.startTimer();
        waitTime();
        timer.resetTimer();

        long getTime = timer.getAccumulatedTimer();
        // this shows that the reset resets it to zero not sure how to

        assertTrue(getTime == 0);
    }

    // we showed that with waitTime() ordinary timer is more than 0 
    // we showed that without waittime() with reset the timer is at 0
    // This shows that if we reset the timer after StopTimer then wait time
    // it proves that it reset to zero than started counting

    @Test
    public void testStartStopReset() {
        Timer timer = new Timer();
        timer.startTimer();
        waitTime();
        timer.stopTimer();
        timer.resetTimer();
        waitTime();
        assertTrue(timer.getAccumulatedTimer() > 0);
    }

    // StopTimer

    @Test (expected = IllegalArgumentException.class)
    public void testStopTimerAccumulatedTimer() {
        Timer timer = new Timer();
        timer.stopTimer();
        timer.getAccumulatedTimer();
    }
    @Test
    public void testStopAfterResetShowsResetDoesntStop(){
        Timer timer = new Timer();
        timer.startTimer();
        waitTime();
        timer.resetTimer();
        long afterResetTime = timer.getAccumulatedTimer();
        waitTime();
        timer.stopTimer();
        long afterStopTime = timer.getAccumulatedTimer();
        assertTrue(afterResetTime < afterStopTime);
        
    }
    @Test
    public void testStartAccumulate(){
        Timer timer = new Timer();
        timer.startTimer();
        waitTime();
        long storeTime = timer.getAccumulatedTimer();
        assertTrue(storeTime > 0);
    }
     @Test (expected = IllegalArgumentException.class)
    public void testAccumulatedTimer() {
        Timer timer = new Timer();
        timer.getAccumulatedTimer();
    }

    public void waitTime() {
        for (int i = 0; i < 10000; i++) {
            System.out.print("");
        }
    }
}
