package com.lambda.crudyorders.services;

import com.lambda.crudyorders.models.Agent;
import com.lambda.crudyorders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

/**
 * The type Agent services.
 */
@Transactional
@Service(value = "agentservices")
public class AgentServicesImpl implements AgentServices
{
	/**
	 * The Agentrepos.
	 */
	@Autowired
	AgentRepository agentrepos;
	
	@Override public Agent findAgentById(long id)
	{
		return agentrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Agent " + id + " not found"));
	}
	
	@Transactional
	@Override public Agent save(Agent agent)
	{
		return agentrepos.save(agent);
	}
	
	@Transactional
	@Override public void deleteAllAgents()
	{
		agentrepos.deleteAll();
	}
}
