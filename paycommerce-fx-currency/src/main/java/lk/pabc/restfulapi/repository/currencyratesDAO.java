package lk.pabc.restfulapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lk.pabc.restfulapi.model.currencyrates;

@Repository
public interface currencyratesDAO extends CrudRepository<currencyrates, String>{

}
