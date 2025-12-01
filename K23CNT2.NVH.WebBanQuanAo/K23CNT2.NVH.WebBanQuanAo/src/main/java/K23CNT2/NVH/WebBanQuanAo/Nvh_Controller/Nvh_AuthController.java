package K23CNT2.nvh.WebBanQuanAo.Nvh_Controller;



import K23CNT2.nvh.WebBanQuanAo.Nvh_Entity.Nvh_Users;
import K23CNT2.nvh.WebBanQuanAo.Nvh_Server.Nvh_UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class Nvh_AuthController {

    private final Nvh_UserService userService;

    // ---------------------- ĐĂNG KÝ KHÁCH HÀNG ----------------------
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Nvh_Users user) {

        if (userService.findByEmail(user.getNvh_email()) != null) {
            return ResponseEntity.badRequest().body("Email đã tồn tại!");
        }

        if (userService.findByUsername(user.getNvh_username()) != null) {
            return ResponseEntity.badRequest().body("Tên đăng nhập đã tồn tại!");
        }

        user.setNvh_role("USER"); // mặc định khách hàng

        Nvh_Users created = userService.save(user);
        return ResponseEntity.ok(created);
    }

    // ---------------------- ĐĂNG NHẬP KHÁCH HÀNG ----------------------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Nvh_Users req) {

        Nvh_Users user = userService.findByUsername(req.getNvh_username());
        if (user == null) {
            return ResponseEntity.badRequest().body("Sai tên đăng nhập!");
        }

        if (!user.getNvh_password().equals(req.getNvh_password())) {
            return ResponseEntity.badRequest().body("Sai mật khẩu!");
        }

        if (!"USER".equals(user.getNvh_role())) {
            return ResponseEntity.badRequest().body("Tài khoản không phải khách hàng!");
        }

        return ResponseEntity.ok(user);
    }

    // ---------------------- ĐĂNG NHẬP ADMIN ----------------------
    @PostMapping("/admin/login")
    public ResponseEntity<?> loginAdmin(@RequestBody Nvh_Users req) {

        Nvh_Users admin = userService.findByUsername(req.getNvh_username());
        if (admin == null) {
            return ResponseEntity.badRequest().body("Sai tên đăng nhập admin!");
        }

        if (!admin.getNvh_password().equals(req.getNvh_password())) {
            return ResponseEntity.badRequest().body("Sai mật khẩu admin!");
        }

        if (!"ADMIN".equals(admin.getNvh_role())) {
            return ResponseEntity.badRequest().body("Bạn không có quyền admin!");
        }

        return ResponseEntity.ok(admin);
    }
}

