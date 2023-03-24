package it.softwareinside.Lezione25OneToOneMultiplo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.softwareinside.Lezione25OneToOneMultiplo.models.Persona;
import it.softwareinside.Lezione25OneToOneMultiplo.services.PersonaService;

@RequestMapping("/api/persona")
@RestController
public class PersonaRestController {

    @Autowired
    PersonaService personaService;

    @PostMapping("/add")
    public String addPersona(@RequestBody Persona persona) {
        return personaService.addPersona(persona);
    }

    @GetMapping("/get-all")
    public Iterable<Persona> getAllPersona() {
        return personaService.getAllPersona();
    }

    @GetMapping("/get")
    public Persona getById(@RequestParam(value = "id") int id) {
        return personaService.getPersonaById(id);
    }

    @DeleteMapping("/delete-by-id")
    public Persona deletePersonaById(@RequestParam(value = "id") int id) {
        return personaService.deletePersonaById(id);
    }

    @DeleteMapping("/delete-all")
    public boolean deleteAllPersona() {
        return personaService.deleteAllPersona();
    }

}
