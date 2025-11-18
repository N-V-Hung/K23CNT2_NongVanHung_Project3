package K23CNT2.nvhDay07.service;

import K23CNT2.nvhDay07.Entity.Category;
import K23CNT2.nvhDay07.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public List<Category> getAll() {
        return repo.findAll();
    }

    public Optional<Category> getById(Long id) {
        return repo.findById(id);
    }

    public Category save(Category c) {
        return repo.save(c);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

