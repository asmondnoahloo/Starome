package starome.backend.starome.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import starome.backend.starome.entities.Caregiver;
import starome.backend.starome.repositories.CaregiverRepository;

@Service
@AllArgsConstructor
public class CaregiverService {
    

    @Autowired
    public CaregiverRepository caregiverRepository;


    public Caregiver addCaregiver(@Valid Caregiver caregiver, BindingResult result,
            @RequestParam("caregiverImage") MultipartFile imgFile) {

        String imgName = imgFile.getOriginalFilename();

        caregiver.setImg(imgName);
        Caregiver savedCaregiver = caregiverRepository.save(caregiver);
       

        try {
            // Preparing the directory path
            String uploadDir = "uploads/caregivers/" + savedCaregiver.getId();
            Path uploadPath = Paths.get(uploadDir);
            System.out.println("Directory path: " + uploadPath);

            // Checking if the upload path exists, if not it will be created.
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Prepare path for file
            Path fileToCreatePath = uploadPath.resolve(imgName);
            System.out.println("File path: " + fileToCreatePath);

            // Copy file to the upload location
            Files.copy(imgFile.getInputStream(), fileToCreatePath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException io) {
            io.printStackTrace();
        }

        return savedCaregiver;
}

}
