/**
 * Created with IntelliJ IDEA.
 * User: tjunghans
 * Date: 29.10.2013
 * Time: 9:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Countdown {
    private int seconds = 4;
    private int counter;

    public int getSeconds() {
        return this.seconds;
    }

    public int startCountdown() {
        this.counter = this.seconds;

        return this.counter;
    }

    public int resetCountdown() {
        return this.counter = this.seconds;
    }
}

