package com.garcia.springbootvue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	private Logger log = LoggerFactory.getLogger(PostController.class);
	
	@Autowired
	private PostRepository repo;
	
	@PostMapping(value="/addpost", produces = "application/json")
	public ResponseEntity<Response> post(@RequestBody Post post){
		try {
			log.info("Invoking '/addpost' endpoint");
			Response response = new Response();
			repo.save(post);
			response.setPost(repo.findAll());
			response.setMessage("Posted Message(s)");
			
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<Response>(new Response("Endpoint invocation failed! Error : ["+e+"]"), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
