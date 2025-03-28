package pl.coderslab.workshop6.book;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.workshop6.service.ServiceInterface;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class BookService implements ServiceInterface {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void add(Book book) {
        repository.save(book);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Book book) {
        repository.save(book);
    }
}
