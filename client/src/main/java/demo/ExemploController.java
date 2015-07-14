package demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import feign.Feign;

/**
 * 
 * @author bernowly
 *
 */
@RestController
public class ExemploController {

	/**
	 * 
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, value="/home")
	public String home() {
		ExemploClient client = Feign.builder().target(ExemploClient.class, getUrl("EXEMPLO_SERVICO"));
		return client.hello();
	}

	/**
	 * 
	 * @param service
	 * @return
	 */
	private String getUrl(String service) {
		String host = System.getenv().get(String.format("%s_SERVICE_HOST", service));
		String port = System.getenv().get(String.format("%s_SERVICE_PORT", service));
		return String.format("http://%s:%s", host, port);
	}


}
