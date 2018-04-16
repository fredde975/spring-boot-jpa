package ft.persistance;

import ft.domain.Hotel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBSeeder implements CommandLineRunner {
    HotelRepository hotelRepository;

    public DBSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        hotelRepository.save(new Hotel("Marriot", 5, true));
        hotelRepository.save(new Hotel("Scandic", 3, true));
        hotelRepository.save(new Hotel("ibis", 4, true));
    }
}
