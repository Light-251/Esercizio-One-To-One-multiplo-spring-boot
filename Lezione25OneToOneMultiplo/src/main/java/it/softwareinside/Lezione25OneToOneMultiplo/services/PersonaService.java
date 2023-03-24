package it.softwareinside.Lezione25OneToOneMultiplo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareinside.Lezione25OneToOneMultiplo.models.Persona;
import it.softwareinside.Lezione25OneToOneMultiplo.repository.PersonaRepo;
import jakarta.validation.Valid;

@Service
public class PersonaService {
    @Autowired
    PersonaRepo personaRepo;

    /**
     * Aggiunge una Persona al DB
     * 
     * @param persona
     * @return
     */
    public String addPersona(@Valid Persona persona) {
        try {
            personaRepo.save(persona);
            return "Persona Aggiunta.";
        } catch (Exception e) {
            return "Persona NON Aggiunta.";
        }
    }
      /**
     * Ritorna la lista di tutte le persone nel DB
     * 
     * @return
     */
    public Iterable<Persona> getAllPersona() {
        try {
            return personaRepo.findAll();
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * Rimuove tutti le Persone dal DB
     * 
     * @param id
     * @return
     */
    public Persona deletePersonaById(int id) {
        try {
            Persona personaRimossa = personaRepo.findById(id).get();
            personaRepo.deleteById(id);
            return personaRimossa;
        } catch (Exception e) {
            System.err.println("ERRORE RIMOZIONE PERSONA: " + e);
            return null;
        }
    }
    
    /**
     * Rimuove tutte le persone dal DB
     * 
     * @return
     */
    public boolean deleteAllPersona() {
        try {
            personaRepo.deleteAll();
            ;
            return true;
        } catch (Exception e) {
            System.err.println("ERRORE RIMOZIONE TUTTI LE PERSONE: " + e);
            return false;
        }
    }
    /**
     * Ritorna una Persona tramite id
     * 
     * @param id
     * @return
     */
    public Persona getPersonaById(int id) {
        try {
            return personaRepo.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

}
