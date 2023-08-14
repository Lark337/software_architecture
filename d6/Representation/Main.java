package d6.Representation;

import java.util.List;

import d6.Data.BookRepository;
import d6.Data.InMemoryBookRepository;
import d6.Domain.Book;

public class Main {
    public static void main(String[] args) {
        BookRepository bookStore = new InMemoryBookRepository();

        Book book1 = new Book("1", "Clean Code", "Robert C. Martin", 34.99);
        Book book2 = new Book("2", "Effective Java", "Joshua Bloch", 29.99);
        bookStore.addBook(book1);
        bookStore.addBook(book2);

        List<Book> allBooks = bookStore.getAllBooks();
        for (Book book : allBooks) {
            System.out.println("Книга: " + book.getTitle() + ", Автор: " + book.getAuthor() + ", Цена: $" + book.getPrice());
        }
        
    }
}
