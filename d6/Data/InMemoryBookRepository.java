package d6.Data;

import java.util.ArrayList;
import java.util.List;

import d6.Domain.Book;

public class InMemoryBookRepository implements BookRepository {
    private List<Book> books;

    public InMemoryBookRepository() {
        books = new ArrayList<>();
    }

    
    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }
}
