public class Essential {
    private int x;
    private int y;

    public Essential(int x, int y) {
        setX(x);
        setY(y);
    }

    public Essential() {}

    public void setX(int x) {
        this.x = x;
    }

    public void incrementX() {
        this.x++;
    }

    public void decrementX() {
        this.x--;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void incrementY() {
        this.y++;
    }

    public void decrementY() {
        this.y--;
    }

    public int getY() {
        return this.y;
    }
}
