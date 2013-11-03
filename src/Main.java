public class Main {

    public static void main(String[] args) {
        System.out.println("Rock, Paper, Scissors");

        Game prsGame = new Game();

        prsGame.start();

        // 1. Show menu

        Countdown countdown = new Countdown();
        countdown.run();




        // Presume two pc players
        prsGame.newRound(new ComputerPlayer(), new ComputerPlayer());


    }
}
