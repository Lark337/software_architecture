package d6.Data;

import java.util.List;
import d6.Domain.Book;

public interface BookRepository {

    /** 
     * @return список всех книг
     */
    List<Book> getAllBooks();

    /** 
     * Добавляет книгу в список
     * 
     * @param book книга
     */
    void addBook(Book book);

    /** 
     * Удаляет книгу из списка
     * 
     * @param book книга
     */
    void removeBook(Book book);
}
