package com.lambda.crudyorders.services;

import com.lambda.crudyorders.models.Agent;

/**
 * The interface Agent services.
 */
public interface AgentServices
{
	/**
	 * Find agent by id agent.
	 *
	 * @param agentid the agentid
	 * @return the agent
	 */
	Agent findAgentById(long agentid);
	
	/**
	 * Save agent.
	 *
	 * @param agent the agent
	 * @return the agent
	 */
	Agent save(Agent agent);
}
