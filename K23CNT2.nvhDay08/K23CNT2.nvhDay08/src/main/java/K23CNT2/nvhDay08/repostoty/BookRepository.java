package K23CNT2.nvhDay08.repostoty;

import K23CNT2.nvhDay08.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
