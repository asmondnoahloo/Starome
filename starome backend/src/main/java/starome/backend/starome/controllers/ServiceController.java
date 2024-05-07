package starome.backend.starome.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starome.backend.starome.entities.Services;
import starome.backend.starome.services.ServicesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/api")
@RestController
public class ServiceController {


    @Autowired
    public ServicesService servicesService;


    @PostMapping("/addService")
    public ResponseEntity<Services> addService(@RequestBody Services service) {
       Services savedService = servicesService.addService(service);
        return new ResponseEntity<>(savedService, HttpStatus.CREATED);
    }

    @GetMapping("/getServices")
    public ResponseEntity<?> getServices() {
        return new ResponseEntity<>(servicesService.getServices(), HttpStatus.OK);
    }
    

    
   
}
