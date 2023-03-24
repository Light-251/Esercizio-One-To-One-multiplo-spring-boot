package it.softwareinside.Lezione25OneToOneMultiplo.repository;

import org.springframework.data.repository.CrudRepository;

import it.softwareinside.Lezione25OneToOneMultiplo.models.Persona;

public interface PersonaRepo extends CrudRepository<Persona, Integer> {
    
}
