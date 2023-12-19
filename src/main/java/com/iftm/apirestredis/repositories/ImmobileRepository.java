package com.iftm.apirestredis.repositories;

import com.iftm.apirestredis.model.Immobile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImmobileRepository extends MongoRepository<Immobile, ObjectId> {
}
