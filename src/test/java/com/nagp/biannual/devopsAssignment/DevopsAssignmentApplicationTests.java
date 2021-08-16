package com.nagp.biannual.devopsAssignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DevopsAssignmentApplicationTests {
	
	@Autowired
	UserService us;

	@Test
	void verifyUserDetails() {
		
		String name = us.getUser();
		assertEquals("Himanshi",name);
		assertNotNull(name);
	}

}
