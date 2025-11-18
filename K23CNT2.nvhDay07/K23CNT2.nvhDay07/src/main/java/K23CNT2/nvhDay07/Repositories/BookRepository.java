package K23CNT2.nvhDay07.Repositories;




import K23CNT2.nvhDay07.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}

