package com.nagp.biannual.devopsAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssignmentController {
	
	@Autowired
	UserService us;
	
	@RequestMapping("/")
	public String index()
	{
		return "Welcome to Himanshi Verma application";
	}
	
	@GetMapping("/getName")
	public ResponseEntity<String> getName(){
		String name=us.getUser();
		return new ResponseEntity<>(name,HttpStatus.OK);
	}

}
