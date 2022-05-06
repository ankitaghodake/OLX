package com.zensar.stockapplication.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Endpoint(id="custom")
@Component
public class CustomEndpoints {
@ReadOperation
	public String myOwnEndpoint() {
		return "My Own Endpoint";
	}
}
