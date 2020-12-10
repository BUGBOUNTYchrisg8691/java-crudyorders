package com.lambdaschool.crudyorders.controllers;

import com.lambdaschool.crudyorders.models.Agent;
import com.lambdaschool.crudyorders.services.AgentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Agent controller.
 */
@RestController
@RequestMapping("/agents")
public class AgentController
{
	@Autowired
	private AgentServices agentServices;
	
	/**
	 * Gets agent by id.
	 *
	 * @param agentid the agentid
	 * @return the agent by id
	 */
	//	GET /agents/agent/{id} - Returns the agent and their customers with the given agent id
	@GetMapping(value = "/agent/{agentid}", produces = {"application/json"})
	public ResponseEntity<?> getAgentById(@PathVariable long agentid)
	{
		Agent retAgent = agentServices.findAgentById(agentid);
		return new ResponseEntity<>(retAgent, HttpStatus.OK);
	}
}
