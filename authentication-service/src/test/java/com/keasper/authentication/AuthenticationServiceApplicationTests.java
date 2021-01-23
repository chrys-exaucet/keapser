package com.keasper.authentication;



import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@WebMvcTest(AuthenticationServiceApplication.class)
class AuthenticationServiceApplicationTests {


	@Test
	void contextLoads() {
		withSuccess();	
	}

}
