package io.ianlcz.rapidcargo_api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.ianlcz.rapidcargo_api.model.Movement;

public interface MovementRepository extends MongoRepository<Movement, String> {
  List<Movement> findTop50ByOrderByCreationDateDesc();
}
