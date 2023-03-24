package it.softwareinside.Lezione25OneToOneMultiplo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.softwareinside.Lezione25OneToOneMultiplo.models.Monitor;
import it.softwareinside.Lezione25OneToOneMultiplo.services.MonitorService;

@RequestMapping("/api/monitor")
@RestController
public class MonitorRestController {
    @Autowired
    MonitorService monitorService;

    @PostMapping("/add")
    public String addMonitor(@RequestBody Monitor monitor) {
        return monitorService.addMonitor(monitor);
    }

    @GetMapping("/get-all")
    public Iterable<Monitor> getAllMonitor() {
        return monitorService.getAllMonitor();
    }

    @GetMapping("/get")
    public Monitor getById(@RequestParam(value = "id") int id) {
        return monitorService.getMonitorById(id);
    }

    @DeleteMapping("/delete-by-id")
    public Monitor deleteMonitorById(@RequestParam(value = "id") int id) {
        return monitorService.deleteMonitorById(id);
    }

    @DeleteMapping("/delete-all")
    public boolean deleteAllMonitor() {
        return monitorService.deleteAllMonitor();
    }

}
