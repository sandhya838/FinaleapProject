package com.example.demo.controller;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;

@RestController
public class DroolsControlerSimple {

	private final KieContainer kieContainer;
	
	public DroolsControlerSimple(KieContainer kieContainer) {
		this.kieContainer= kieContainer;
		}
	
@PostMapping("/product-discount")
public Product getDispalyDetails(@RequestBody Product product) {
	KieSession kieSession = kieContainer.newKieSession();
	kieSession.insert(product);
	kieSession.fireAllRules();
	kieSession.dispose();
	return product;
}
}
