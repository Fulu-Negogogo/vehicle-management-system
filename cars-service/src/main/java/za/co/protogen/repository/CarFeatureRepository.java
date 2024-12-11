package za.co.protogen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.protogen.domain.CarFeature;

public interface CarFeatureRepository extends JpaRepository<CarFeature, Long> {

    // Custom method to delete car features by carId
    void deleteByCarId(Long carId);
}
