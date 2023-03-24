package it.softwareinside.Lezione25OneToOneMultiplo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.softwareinside.Lezione25OneToOneMultiplo.models.Computer;
import it.softwareinside.Lezione25OneToOneMultiplo.services.ComputerService;
@RequestMapping("/api/computer")
@RestController
public class ComputerRestController {

    @Autowired
    ComputerService computerService;

    
    @GetMapping("/get-all")
    public Iterable<Computer> getAllComputer() {
        return computerService.getAllComputer();
    }

    @GetMapping("/get")
    public Computer getById(@RequestParam(value = "id") int id) {
        return computerService.getComputerById(id);
    }

    @DeleteMapping("/delete-by-id")
    public Computer deleteComputerById(@RequestParam(value = "id") int id) {
        return computerService.deleteComputerById(id);
    }

    @DeleteMapping("/delete-all")
    public boolean deleteAllComputer() {
        return computerService.deleteAllComputer();
    }

}
