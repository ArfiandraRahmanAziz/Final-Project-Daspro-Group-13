public class Player{
    private String name;
    private int position;
    private boolean skipNextTurn;

    public Player(String name){
        this.name = name;
        this.position = 1;
        this.skipNextTurn = false;
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public void moveAround(int x){
        this.position += x;
        if (this.position > 100){
            this.position = 100 - (this.position - 100);
        }
    }

    public boolean isSkipNextTurn(){
        return this.skipNextTurn;
    }

    public void setSkipNextTurn(boolean skipNextTurn){
        this.skipNextTurn = skipNextTurn;
    }

    public int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }
}

