package io.ianlcz.rapidcargo_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ianlcz.rapidcargo_api.model.Movement;
import io.ianlcz.rapidcargo_api.service.MovementService;

@RestController
@RequestMapping("/api/movements")
public class MovementController {
  
  @Autowired
  private MovementService service;
  
  @PostMapping
  public Movement declareMovement(@RequestBody Movement movement) {
    return service.saveMovement(movement);
  }

  @GetMapping
  public List<Movement> listLast50Movements() {
    return service.getLast50Movements();
  }
}
