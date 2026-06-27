package ToursAndTravel.LetsGo.controller;

import ToursAndTravel.LetsGo.model.Booking;
import ToursAndTravel.LetsGo.repository.BookingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    private final BookingRepository repo;

    // Constructor injection (BEST PRACTICE)
    public BookingController(BookingRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        booking.setStatus("CONFIRMED");
        return repo.save(booking);
    }

    @GetMapping
    public List<Booking> getAll() {
        return repo.findAll();
    }
}