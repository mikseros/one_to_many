package com.mikseros.onetomany.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mikseros.onetomany.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{

}
