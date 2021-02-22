public class PieceOfSnake extends Essential{
    private int turn;

    public PieceOfSnake(int x, int y) {
        super(x, y);
    }

    public PieceOfSnake() {
        super();
    }

    public void setTurn(int turn) {                             // Setter of direction_id of snake's move
        this.turn = turn;
    }

    public int getTurn() {                                      // Getter of direction_id of snake's move
        return this.turn;
    }
}
