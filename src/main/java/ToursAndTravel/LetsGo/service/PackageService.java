package ToursAndTravel.LetsGo.service;

import ToursAndTravel.LetsGo.model.TourPackage;

import java.util.List;
import java.util.Optional;

public interface PackageService {

    List<TourPackage> getAllPackages();

    Optional<TourPackage> getPackageById(Long id);

    TourPackage addPackage(TourPackage tourPackage);

    TourPackage updatePackage(Long id, TourPackage tourPackage);

    void deletePackage(Long id);

    List<TourPackage> searchByLocation(String location);
}