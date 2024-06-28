import java.util.ArrayList;

public class SnL {
    private int boardSize;
    private ArrayList<Player> players;
    private ArrayList<Snake> snakes;
    private ArrayList<Ladder> ladders;
    private ArrayList<Swap> swaps;
    private ArrayList<Skip> skips;
    private int gameStatus;
    private int currentTurn;

    //Constructor
    public SnL(int boardSize) {
        this.boardSize = boardSize;
        this.snakes = new ArrayList<Snake>();
        this.ladders = new ArrayList<Ladder>();
        this.swaps = new ArrayList<Swap>();
        this.skips = new ArrayList<Skip>();
        this.players = new ArrayList<Player>();
        this.gameStatus = 0;
        this.currentTurn = 0;
    }

    //Initialize game with ladders, snakes, swaps, and skips
    public void initiateGame() {
        int[][] ladders = {
                {2, 23},
                {8, 34},
                {20, 77},
                {32, 68},
                {41, 78},
                {74, 88},
                {82, 100},
                {85, 95}
        };
        setLadders(ladders);

        int[][] snakes = {
                {47, 5},
                {29, 9},
                {38, 15},
                {97, 25},
                {53, 33},
                {92, 70},
                {86, 54},
                {97, 25}
        };
        setSnakes(snakes);

        int[] swaps = {10,25,50,75};
        setSwaps(swaps);

        int[] skips = {14,28,42,56};
        setSkips(skips);
    }

    public Player getTurn() {
        Player currentPlayer = this.players.get(this.currentTurn);
        if (currentPlayer.isSkipNextTurn()) {
            currentPlayer.setSkipNextTurn(false);
            switchTurn();
            currentPlayer = this.players.get(this.currentTurn);
        }
        switchTurn();
        return currentPlayer;
    }

    private void switchTurn() {
        if (this.currentTurn == 0) {
            this.currentTurn = 1;
        } else {
            this.currentTurn = 0;
        }
    }

    public void setSizeBoard(int size) {
        this.boardSize = size;
    }

    public void addPlayer(Player p) {
        this.players.add(p);
    }

    public void setLadders(int[][] ladders) {
        for (int[] ladder : ladders) {
            this.ladders.add(new Ladder(ladder[0], ladder[1]));
        }
    }

    public void setSnakes(int[][] snakes) {
        for (int[] snake : snakes) {
            this.snakes.add(new Snake(snake[0], snake[1]));
        }
    }

    public void setSwaps(int[] swaps) {
        for (int swap : swaps) {
            this.swaps.add(new Swap(swap));
        }
    }

    public void setSkips(int[] skips) {
        for (int skip : skips) {
            this.skips.add(new Skip(skip));
        }
    }

    public String getWinner() {
        if (this.gameStatus == 0) {
            return "The game is not over yet";
        } else {
            if (this.players.get(0).getPosition() == 100) {
                return this.players.get(0).getName();
            } else {
                return this.players.get(1).getName();
            }
        }
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public ArrayList<Snake> getSnakes() {
        return this.snakes;
    }

    public ArrayList<Ladder> getLadders() {
        return this.ladders;
    }

    public ArrayList<Swap> getSwaps() {
        return this.swaps;
    }

    public ArrayList<Skip> getSkips() {
        return this.skips;
    }

    public int getBoardSize() {
        return this.boardSize;
    }

    public int getGameStatus() {
        return this.gameStatus;
    }

    public void movePlayer(Player p, int x) {
        this.gameStatus = 1;
        p.moveAround(x);

        for (Ladder l : this.ladders) {
            if (l.getFromPosition() == p.getPosition()) {
                p.setPosition(l.getToPosition());
                System.out.println(p.getName() + " got ladder so jumps to " + p.getPosition());
            }
        }

        for (Snake s : this.snakes) {
            if (s.getHead() == p.getPosition()) {
                p.setPosition(s.getTail());
                System.out.println(p.getName() + " got snake so slides to " + p.getPosition());
            }
        }

        for (Swap t : this.swaps) {
            if (t.getPosition() == p.getPosition()) {
                System.out.println(p.getName() + " landed on a swap tile! Swapping positions with the other player.");
                Player otherPlayer = this.players.get(0).equals(p) ? this.players.get(1) : this.players.get(0);
                t.applyEffect(p, otherPlayer);
            }
        }

        for (Skip t : this.skips) {
            if (t.getPosition() == p.getPosition()) {
                System.out.println(p.getName() + " landed on a skip tile! Skipping their next turn.");
                t.applyEffect(p);
            }
        }

        if (p.getPosition() == this.boardSize) {
            this.gameStatus = 2;
        }
    }
}
