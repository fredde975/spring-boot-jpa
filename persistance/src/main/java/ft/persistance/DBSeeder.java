package ft.persistance;

import ft.domain.Hotel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBSeeder implements CommandLineRunner {
    HotelRepository hotelRepository;
    private static Logger logger = LoggerFactory.getLogger(DBSeeder.class);

    public DBSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.debug("My persistance message");
//        hotelRepository.save(new Hotel("Marriot", 5, true));
//        hotelRepository.save(new Hotel("Scandic", 3, true));
//        hotelRepository.save(new Hotel("ibis", 4, true));
    }
}

