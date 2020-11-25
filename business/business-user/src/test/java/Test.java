import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {

    @org.junit.jupiter.api.Test
    public void testEncode(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass = "123456";
        System.out.println(passwordEncoder.encode(pass));
    }
}
