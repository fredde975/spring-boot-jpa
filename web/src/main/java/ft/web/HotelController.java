package ft.web;

import ft.domain.Hotel;
import ft.persistance.HotelRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/hotels")
    public List<Hotel> getHotels(){
        try {
            return hotelRepository.findAll();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
