package com.lambda.crudyorders.controllers;

import com.lambda.crudyorders.models.Agent;
import com.lambda.crudyorders.services.AgentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agents")
public class AgentController
{
	@Autowired
	AgentServices agentServices;
	
	// GET /agents/agent/{id}
	@GetMapping(value = "/agent/{id}", produces = {"application/json"})
	public ResponseEntity<?> getAgentById(@PathVariable long id)
	{
		Agent retAgent = agentServices.findAgentById(id);
		return new ResponseEntity<>(retAgent, HttpStatus.OK);
	}
}
