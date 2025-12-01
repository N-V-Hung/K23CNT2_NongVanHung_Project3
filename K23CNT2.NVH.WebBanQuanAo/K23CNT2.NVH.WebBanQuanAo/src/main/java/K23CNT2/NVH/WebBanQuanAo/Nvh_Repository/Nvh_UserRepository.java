package K23CNT2.nvh.WebBanQuanAo.Nvh_Repository;

import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Nvh_UserRepository extends JpaRepository<Nvh_Users, Integer> {
    Nvh_Users findByEmail(String nvhEmail);
    Nvh_Users findByUsername(String nvhUsername);
}
