public class Ladder {
    private int fromPosition;
    private int toPosition;

    public Ladder(int fromPosition, int toPosition) {
        this.fromPosition = fromPosition;
        this.toPosition = toPosition;
    }

    public int getFromPosition() {
        return this.fromPosition;
    }

    public int getToPosition() {
        return this.toPosition;
    }
}