import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {

    @org.junit.jupiter.api.Test
    public void test(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass = "bussiness-shop";
        System.out.println(passwordEncoder.encode(pass));
    }

}
