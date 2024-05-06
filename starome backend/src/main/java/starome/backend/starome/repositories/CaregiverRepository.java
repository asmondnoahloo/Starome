package starome.backend.starome.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import starome.backend.starome.entities.Caregiver;

public interface CaregiverRepository extends JpaRepository<Caregiver, Long>{
    List<Caregiver> findByServiceId(Long id);
}
