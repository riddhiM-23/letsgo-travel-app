package ToursAndTravel.LetsGo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ToursAndTravel.LetsGo.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    public default List<Booking> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public default Booking save(Booking booking) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}
