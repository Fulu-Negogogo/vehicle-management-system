package za.co.protogen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.protogen.domain.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
    // You can define custom query methods here if needed, for example:
    // List<Car> findByMake(String make);
}
