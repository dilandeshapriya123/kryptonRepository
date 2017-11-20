package lk.pabc.restfulapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lk.pabc.restfulapi.model.*;


@Repository
public interface CommonPropertiesDAO extends CrudRepository<CommonProperties, String>{

}
