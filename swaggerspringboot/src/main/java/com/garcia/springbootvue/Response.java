package com.garcia.springbootvue;

import java.util.List;

import lombok.Data;

@Data
public class Response {

	private String message;
	private List<Post> post;
	
	public Response() {}
	public Response(String message) {
		this.message = message;
	}
}
