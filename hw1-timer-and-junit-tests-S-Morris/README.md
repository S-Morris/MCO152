# 152-hw1-TimerAndTests

Create a `Timer` class and JUnit tests
===================
#### <i class="icon-file"></i> **Implement using Best Practices**
    class Timer
    {
	    void start() // starts the Timer; elapsedTime will start to accumulate. Calling start when the Timer is active (i.e. started) will result in a thrown IllegalStateException
	    void stop() // stops the Timer; elapsedTime will stop accumulating. Calling stop when the Timer is inactive (i.e. stopped) is legal and does nothing
	    void reset() // resets the elapsedTime to 0. If the Timer is active elapsedTime will continue accumulating time. If inactive elapsedTime will remain 0 and not accumulate
	    long getAccumulatedTimer()// returns the time in milliseconds between start/stop or reset/stop or the current accumulated time if the Timer is active

#### <i class="icon-file"></i> **Testing**
Test each method as thoroughly as you can to verify that each behaves according to specs You will likely need to refernce the JUnit textbook or online resources.

---
This was designed using  **StackEdit**[^stackedit]. 


  [^stackedit]: [StackEdit](https://stackedit.io/) is a full-featured, open-source Markdown editor based on PageDown, the Markdown library used by Stack Overflow and the other Stack Exchange sites.


  [1]: http://math.stackexchange.com/
