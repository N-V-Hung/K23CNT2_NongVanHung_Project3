package K23CNT2.nvhDay08.repostoty;

import K23CNT2.nvhDay08.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository  extends JpaRepository<Author, Long> {
}
