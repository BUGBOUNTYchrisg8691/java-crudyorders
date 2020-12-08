package com.lambda.crudyorders.services;

import com.lambda.crudyorders.models.Agent;
import com.lambda.crudyorders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "agentservices")
public class AgentServicesImpl implements AgentServices
{
	@Autowired
	AgentRepository agentrepos;
	
	@Override
	public Agent save(Agent agent)
	{
		return agentrepos.save(agent);
	}
}
