public class Swap {
    private int position;

    public Swap(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public void applyEffect(Player p1, Player p2) {
        int tempPosition = p1.getPosition();
        p1.setPosition(p2.getPosition());
        p2.setPosition(tempPosition);
    }
}

