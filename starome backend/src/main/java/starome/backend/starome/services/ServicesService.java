package starome.backend.starome.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.AllArgsConstructor;
import starome.backend.starome.entities.Services;
import starome.backend.starome.repositories.ServiceRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class ServicesService {

    @Autowired
    public ServiceRepository servicesRepository;

    public Services addService(@ModelAttribute Services service) {
        return servicesRepository.save(service);
    }

    public List<Services> getServices() {
        return servicesRepository.findAll();
    }
}
