package ToursAndTravel.LetsGo.config;

import ToursAndTravel.LetsGo.model.TourPackage;
import ToursAndTravel.LetsGo.repository.PackageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PackageRepository repository;

    public DataInitializer(PackageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (repository.count() == 0) {

            repository.save(new TourPackage(
                    "Goa Beach Vacation",
                    "Goa",
                    "Enjoy beaches, nightlife and water sports",
                    12000,
                    "https://images.unsplash.com/photo-1507525428034-b723cf961d3e"));

            repository.save(new TourPackage(
                    "Kerala Backwaters",
                    "Kerala",
                    "Peaceful houseboat stay with nature",
                    15000,
                    "https://images.unsplash.com/photo-1500375592092-40eb2168fd21"));

            repository.save(new TourPackage(
                    "Manali Adventure Trip",
                    "Manali",
                    "Snow mountains and adventure sports",
                    18000,
                    "https://images.unsplash.com/photo-1605540436563-5bca919ae766"));

            repository.save(new TourPackage(
                    "Jaipur Heritage Tour",
                    "Jaipur",
                    "Royal palaces and cultural heritage",
                    10000,
                    "https://images.unsplash.com/photo-1477587458883-47145ed94245"));

            System.out.println("Sample travel packages inserted!");
        }
    }
}