package lk.pabc.restfulapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lk.pabc.restfulapi.model.agent;

@Repository
public interface AgentDAO extends CrudRepository<agent, String>{

}
