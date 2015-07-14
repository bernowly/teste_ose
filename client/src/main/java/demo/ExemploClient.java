package demo;

import feign.RequestLine;

public interface ExemploClient {
	
	@RequestLine("GET /hello")
	String hello();

}
