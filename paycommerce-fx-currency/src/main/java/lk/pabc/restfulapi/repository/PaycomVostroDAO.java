package lk.pabc.restfulapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lk.pabc.restfulapi.model.paycommercevostrodetails;

@Repository
public interface PaycomVostroDAO extends CrudRepository<paycommercevostrodetails, String>{

}
