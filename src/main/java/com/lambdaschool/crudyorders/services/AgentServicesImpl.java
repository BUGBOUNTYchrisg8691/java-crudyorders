package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Agent;
import com.lambdaschool.crudyorders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

/**
 * The type Agent services.
 */
@Transactional
@Service(value = "agentServices")
public class AgentServicesImpl implements AgentServices
{
	/**
	 * The Agentrepos.
	 */
	@Autowired
	AgentRepository agentrepos;
	
	@Transactional
	@Override
	public Agent save(Agent agent)
	{
		return agentrepos.save(agent);
	}
	
	@Override
	public Agent findAgentById(long agentid)
	{
		return agentrepos.findById(agentid).orElseThrow(() -> new EntityNotFoundException("Agent " + agentid + " not found"));
	}
}
