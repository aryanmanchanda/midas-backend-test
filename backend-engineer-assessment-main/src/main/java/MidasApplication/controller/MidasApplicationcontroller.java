package MidasApplication.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MidasApplicationcontroller {

	@Value("${stripe.api-key}")
	String Stripekey;
	@RequestMapping("/")
	public String index() {
		return "hello";
	}
}
