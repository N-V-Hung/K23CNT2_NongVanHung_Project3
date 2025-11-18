package K23CNT2.nvhDay07.controller;



import  K23CNT2.nvhDay07.Entity.Category;
import K23CNT2.nvhDay07.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("categories", service.getAll());
        return "category/category-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/category-form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Category category) {
        service.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        model.addAttribute("category", service.getById(id).orElse(null));
        return "category/category-form";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Category category) {
        category.setId(id);
        service.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/categories";
    }
}

