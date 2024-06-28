public class Main{
    public static void main(String[] args){
        SnL g1 = new SnL(100);
        g1.initiateGame();
        Player p1 = new Player("Charles");
        Player p2 = new Player("Carlos");

        g1.addPlayer(p1);
        g1.addPlayer(p2);

        do{
            System.out.println("====================================================================");

            Player nowPlaying = g1.getTurn();
            System.out.println("Now Playing: " + nowPlaying.getName() + " the current position is " + nowPlaying.getPosition());

            int x = nowPlaying.rollDice();
            System.out.println(nowPlaying.getName() + " is rolling dice and gets number: " + x);
            g1.movePlayer(nowPlaying, x);
            System.out.println(nowPlaying.getName() + " the current position is " + nowPlaying.getPosition());
        }while (g1.getGameStatus() != 2);

        System.out.println("The game is over, the winner is: " + g1.getWinner());
    }
}
