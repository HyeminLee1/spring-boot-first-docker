package com.javis.UserService.inheritance;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<ItemDTO, Long> {
}
