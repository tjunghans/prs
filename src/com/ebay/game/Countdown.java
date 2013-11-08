package com.ebay.game;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * Created with IntelliJ IDEA.
 * User: tjunghans
 * Date: 29.10.2013
 * Time: 9:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Countdown {
    private int seconds = 4;
    private int counter = 0;
    private String[] countdownLabels = {
            "Rock", "Paper", "Scissors!"
    };



    public void run() {
        final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        class RequestProgressRunnable implements Runnable {

            public void run() {

                // do stuff
                System.out.println(Countdown.this.countdownLabels[counter]);

                // Increment progress value
                counter += 1;

                // Check progress value
                if (counter < seconds) {
                    executor.schedule(this, 1, TimeUnit.SECONDS);
                }

            }
        }

        executor.schedule(new RequestProgressRunnable(), 1, TimeUnit.SECONDS);

    }
}

