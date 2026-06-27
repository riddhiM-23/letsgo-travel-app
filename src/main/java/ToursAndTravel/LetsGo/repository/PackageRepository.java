package ToursAndTravel.LetsGo.repository;

import ToursAndTravel.LetsGo.model.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageRepository extends JpaRepository<TourPackage, Long> {

    List<TourPackage> findByLocationContainingIgnoreCase(String location);

}