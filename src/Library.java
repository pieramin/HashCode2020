import java.util.List;

public class Library {
    private List<Book> books;
    private int signTimeDays;
    private int maxBooksPerDay;
    private boolean isSigned = false;

    public Library(List<Book> books, int signTimeDays, int maxBooksPerDay) {
        this.books = books;
        this.signTimeDays = signTimeDays;
        this.maxBooksPerDay = maxBooksPerDay;
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getSignTimeDays() {
        return signTimeDays;
    }

    public int getMaxBooksPerDay() {
        return maxBooksPerDay;
    }

    public void setSigned(boolean signed) {
        isSigned = signed;
    }
}
