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
	 * @param id the id
	 * @return the agent
	 */
	Agent findAgentById(long id);
	
	/**
	 * Save agent.
	 *
	 * @param agent the agent
	 * @return the agent
	 */
	Agent save(Agent agent);
	
	/**
	 * Delete all agents.
	 */
	void deleteAllAgents();
}
