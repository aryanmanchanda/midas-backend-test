package MidasApplication.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import MidasApplication.model.CustomerData;

@RestController
@RequestMapping("/api")
public class MidasApplicationcontrollerAPI {
	private static final Logger logger = LoggerFactory.getLogger(MidasApplicationcontrollerAPI.class);
	@RequestMapping("/CreatingCustomer")
	public CustomerData index(@RequestBody CustomerData data) {
	    try {
	        CustomerCreateParams params = CustomerCreateParams.builder()
	                .setName(data.getName())
	                .setEmail(data.getEmail())
	                .build();
	        Customer customer = Customer.create(params);
	        data.setCustomerId(customer.getId());
	        logger.info("Customer created successfully");
            return data;
	    } catch (StripeException e) {
	        // Log the exception details
	        e.printStackTrace();
	        logger.error("Error creating customer", e);
            return null;
	        // You might want to return an error response or handle it accordingly
	    }
	}


}
