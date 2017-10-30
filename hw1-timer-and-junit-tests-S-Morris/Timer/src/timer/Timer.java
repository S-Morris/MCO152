package timer;

/**
 *
 * @author Shmuel
 */
interface ElapsedTimeClock {

    Long currentTimeMill();
}

    class elapsedTimeClock implements ElapsedTimeClock{

    @Override
    public Long currentTimeMill() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    }

public class Timer {

    private long startTimeMillis;
    private boolean startTimeBool = false;

    private long stopTimeMillis;
    private boolean stopTimeBool = false;

    public void startTimer() {
        startTimeMillis = System.currentTimeMillis();
        startTimeBool = true;
        stopTimeBool = false;
    }

    public void stopTimer() {
        stopTimeMillis = System.currentTimeMillis();
        stopTimeBool = true;
    }

    public void resetTimer() {
        startTimeMillis = System.currentTimeMillis();
        stopTimeBool = false;
    }

    public long getAccumulatedTimer() {
        if (startTimeBool && stopTimeBool) {
            return (long) stopTimeMillis - (long) startTimeMillis;

        } else if (startTimeBool) {

            return (long) System.currentTimeMillis() - (long) startTimeMillis;
        } else {
            throw new IllegalArgumentException("The StartTimer Method wasn't called");
        }

    }

    public static void main(String[] args) {

    }
}
