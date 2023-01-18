package quiz;

public enum Level {
    EASY(1), MEDIUM(2), HARD(3);

    private int point;

    Level(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }
}
