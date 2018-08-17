package ds.dsknowledges.exeption;

public class NoSuchArticleExeption extends RuntimeException {

    public NoSuchArticleExeption() {
    }

    public NoSuchArticleExeption(String message) {
        super(message);
    }
}
