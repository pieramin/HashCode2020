public class Book {
    private static int idCounter = 0;
    private int id;
    private int score;
    private boolean scanned = false;
    private int cont = 0;

    public Book(int score) {
        this.id = idCounter++;
        this.score = score;

    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public boolean isScanned() {
        return scanned;
    }

    public void setScanned(boolean scanned) {
        this.scanned = scanned;
    }

    public int getCont() {
        return cont;
    }

    public void addCont() {
         cont++;
    }

}
