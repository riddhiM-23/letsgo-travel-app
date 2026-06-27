package ToursAndTravel.LetsGo.controller;

import ToursAndTravel.LetsGo.model.TourPackage;
import ToursAndTravel.LetsGo.service.PackageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
@CrossOrigin(origins = "*")
public class PackageController {

    private final PackageService service;

    public PackageController(PackageService service) {
        this.service = service;
    }

    // Get all packages
    @GetMapping
    public List<TourPackage> getAllPackages() {
        return service.getAllPackages();
    }

    // Get package by ID
    @GetMapping("/{id}")
    public TourPackage getPackageById(@PathVariable Long id) {
        return service.getPackageById(id)
                .orElseThrow(() -> new RuntimeException("Package not found"));
    }

    // Add new package
    @PostMapping
    public TourPackage addPackage(@RequestBody TourPackage tourPackage) {
        return service.addPackage(tourPackage);
    }

    // Update package
    @PutMapping("/{id}")
    public TourPackage updatePackage(@PathVariable Long id,
            @RequestBody TourPackage tourPackage) {
        return service.updatePackage(id, tourPackage);
    }

    // Delete package
    @DeleteMapping("/{id}")
    public void deletePackage(@PathVariable Long id) {
        service.deletePackage(id);
    }

    // Search by location
    @GetMapping("/search")
    public List<TourPackage> searchPackages(@RequestParam String location) {
        return service.searchByLocation(location);
    }
}