package com.lambda.crudyorders.repositories;

import com.lambda.crudyorders.models.Agent;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Agent repository.
 */
public interface AgentRepository extends CrudRepository<Agent, Long>
{
}
