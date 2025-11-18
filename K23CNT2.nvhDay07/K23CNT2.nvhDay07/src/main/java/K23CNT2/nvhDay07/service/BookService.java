package K23CNT2.nvhDay07.service;


import K23CNT2.nvhDay07.Repositories.BookRepository;
import  K23CNT2.nvhDay07.Repositories.CategoryRepository;
import K23CNT2.nvhDay07.Entity.Book;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAll() {
        return repo.findAll();
    }

    public Optional<Book> getById(Long id) {
        return repo.findById(id);
    }

    public Book save(Book b) {
        return repo.save(b);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
