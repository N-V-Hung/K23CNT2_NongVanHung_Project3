package K23CNT2.nvhDay07.Repositories;


import K23CNT2.nvhDay07.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
