package it.softwareinside.Lezione25OneToOneMultiplo.repository;

import org.springframework.data.repository.CrudRepository;

import it.softwareinside.Lezione25OneToOneMultiplo.models.Computer;

public interface ComputerRepo extends CrudRepository<Computer, Integer> {

}
