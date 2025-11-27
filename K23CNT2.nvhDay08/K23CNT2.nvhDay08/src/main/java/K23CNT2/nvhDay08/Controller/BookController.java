package K23CNT2.nvhDay08.Controller;

import K23CNT2.nvhDay08.Service.AuthorService;
import K23CNT2.nvhDay08.Service.BookService;
import K23CNT2.nvhDay08.entity.Author;
import K23CNT2.nvhDay08.entity.Book;
import org.springframework.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    private static final String UPLOAD_DIR ="src/main/resources/static";

    private static final String UPLOAD_PathFile="/images/products";

    @GetMapping
    public String listBooks(Model model){
        model.addAttribute("books", bookService.getAllBooks());
        return "books/book-list";
    }

    @GetMapping("/new")
    public  String skowCreateForm(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "books/book-form";
    }

    @PostMapping("/new")
    public String saveBook(@ModelAttribute Book book,
                           @RequestParam List<Long> authorIds,
                           @RequestParam("imageBook") MultipartFile imageFile) {

        // Xử lý upload ảnh
        if (!imageFile.isEmpty()) {
            try {
                Path uploadPath = Paths.get(UPLOAD_DIR + UPLOAD_PathFile);

                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                String originalFilename = StringUtils.cleanPath(imageFile.getOriginalFilename());
                String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));

                String newFileName = book.getCode() + fileExtension;
                Path filePath = uploadPath.resolve(newFileName);
                Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                // FIX LỖI 1  ✔
                book.setImgUrl(UPLOAD_PathFile + "/" + newFileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // FIX LỖI 2  ✔
        List<Author> authors = authorService.findAllById(authorIds);
        book.setAuthors(authors);

        // Lưu Book
        bookService.saveBook(book);
        return "redirect:/books";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.getAllAuthors());
        return  "books/book-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return  "redirect:/books";
    }
}
