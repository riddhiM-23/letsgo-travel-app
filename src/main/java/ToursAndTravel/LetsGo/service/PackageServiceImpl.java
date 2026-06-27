package ToursAndTravel.LetsGo.service;

import ToursAndTravel.LetsGo.model.TourPackage;
import ToursAndTravel.LetsGo.repository.PackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageServiceImpl implements PackageService {

    private final PackageRepository repository;

    public PackageServiceImpl(PackageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TourPackage> getAllPackages() {
        return repository.findAll();
    }

    @Override
    public Optional<TourPackage> getPackageById(Long id) {
        return repository.findById(id);
    }

    @Override
    public TourPackage addPackage(TourPackage tourPackage) {
        return repository.save(tourPackage);
    }

    @Override
    public TourPackage updatePackage(Long id, TourPackage tourPackage) {

        TourPackage existingPackage = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package not found"));

        existingPackage.setTitle(tourPackage.getTitle());
        existingPackage.setLocation(tourPackage.getLocation());
        existingPackage.setDescription(tourPackage.getDescription());
        existingPackage.setPrice(tourPackage.getPrice());
        existingPackage.setImageUrl(tourPackage.getImageUrl());

        return repository.save(existingPackage);
    }

    @Override
    public void deletePackage(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TourPackage> searchByLocation(String location) {
        return repository.findByLocationContainingIgnoreCase(location);
    }
}