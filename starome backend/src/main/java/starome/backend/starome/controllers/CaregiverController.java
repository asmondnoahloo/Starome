package starome.backend.starome.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import starome.backend.starome.entities.Caregiver;
import starome.backend.starome.services.CaregiverService;

@RestController
@RequestMapping("/api/caregiver")
public class CaregiverController {

    @Autowired
    public CaregiverService caregiverService;

    @PostMapping("/addCaregiver")
    public ResponseEntity<?> addCaregiver( @Valid @RequestBody Caregiver caregiver, BindingResult result, @RequestParam("caregiverImage") MultipartFile imgFile) {

        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        Caregiver savedCaregiver = caregiverService.addCaregiver(caregiver, result, imgFile);

        return new ResponseEntity<>(savedCaregiver, HttpStatus.CREATED);
    }

}
