package K23CNT2.nvhDay07.controller;



import K23CNT2.nvhDay07.Entity.Book;
import K23CNT2.nvhDay07.service.BookService;
import K23CNT2.nvhDay07.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final CategoryService categoryService;

    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "book/book-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryService.getAll());
        return "book/book-form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getById(id).orElse(null));
        model.addAttribute("categories", categoryService.getAll());
        return "book/book-form";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Book book) {
        book.setId(id);
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}
