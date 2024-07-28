package io.ianlcz.rapidcargo_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ianlcz.rapidcargo_api.model.Movement;
import io.ianlcz.rapidcargo_api.repository.MovementRepository;

@Service
public class MovementService {

  @Autowired
  private MovementRepository repository;

    public Movement saveMovement(Movement movement) {
        return repository.save(movement);
    }

    public List<Movement> getLast50Movements() {
        return repository.findTop50ByOrderByCreationDateDesc();
    }
}
