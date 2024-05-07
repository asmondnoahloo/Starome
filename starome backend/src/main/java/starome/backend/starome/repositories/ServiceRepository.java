package starome.backend.starome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import starome.backend.starome.entities.Services;

public interface ServiceRepository extends JpaRepository<Services, Long>{
    

}
