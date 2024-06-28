public class Skip {
    private int position;

    public Skip(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public void applyEffect(Player p) {
        p.setSkipNextTurn(true);
    }
}

