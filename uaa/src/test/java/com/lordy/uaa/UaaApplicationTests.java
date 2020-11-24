package com.lordy.uaa;

import com.alibaba.fastjson.JSON;
import com.lordy.user.user_api.entity.RegisterDto;
import com.lordy.user.user_api.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class UaaApplicationTests {

	@Test
	void contextLoads() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String s = passwordEncoder.encode("uaa");
		System.out.println(s);
	}

	@Test
	void generateRegister(){
		RegisterDto registerDto = new RegisterDto();
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123456");
		user.setNickName("Lordy");
		registerDto.setUser(user);
		registerDto.setRoleId(1);
		System.out.println(JSON.toJSONString(registerDto));
	}

}
