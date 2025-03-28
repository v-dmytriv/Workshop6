package pl.coderslab.workshop6.book;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {
    private BookService service;

    @GetMapping
    public List<Book> getAllBooks(){
        return service.findAll();
    }

    @GetMapping("/{id:\\d+}")
    public Book getBookById(@PathVariable long id){
        return this.service.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Book with id " + id + " not found")
        );
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        service.add(book);
    }

    @PutMapping
    public void updateBook(@RequestBody Book book){
        service.update(book);
    }

    @DeleteMapping("/{id:\\d+}")
    public void deleteBook(@PathVariable long id){
        service.delete(id);
    }
}

