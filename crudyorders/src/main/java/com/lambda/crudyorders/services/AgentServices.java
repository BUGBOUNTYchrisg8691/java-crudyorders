package com.lambda.crudyorders.services;

import com.lambda.crudyorders.models.Agent;

public interface AgentServices
{
	Agent findAgentById(long id);
	Agent save(Agent agent);
}
