package com.example.demo.controller;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.OrderRequest;


@RestController
public class DroolsController {

	private final KieContainer kieContainer;
	
	public DroolsController(KieContainer kieContainer) {
		this.kieContainer= kieContainer;
		}
	
	@PostMapping("/discount")
	public OrderRequest getDiscountPercent(@RequestBody OrderRequest orderRequest){
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(orderRequest);
		kieSession.fireAllRules();
		kieSession.dispose();
		return orderRequest;
	}
}
