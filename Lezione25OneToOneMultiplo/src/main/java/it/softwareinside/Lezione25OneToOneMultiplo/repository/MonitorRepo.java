package it.softwareinside.Lezione25OneToOneMultiplo.repository;

import org.springframework.data.repository.CrudRepository;

import it.softwareinside.Lezione25OneToOneMultiplo.models.Monitor;

public interface MonitorRepo extends CrudRepository<Monitor, Integer> {
    
}
