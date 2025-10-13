package el.development.LabNotes.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {
    @GetMapping("/hello")
    public String getHello(){
        return "Hello from api";
    }
    @GetMapping("/helloprivatee")
    public String getHelloprivate(){
        return "private hello from api";
    }
}
