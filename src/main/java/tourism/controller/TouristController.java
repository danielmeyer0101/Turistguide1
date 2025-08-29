package tourism.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {

    private final TouristService service;

    public TouristController(TouristService service) {
        this.service = service;
    }

@GetMapping()
    public ResponseEntity<List<TouristAttraction>> getTuristAttractions() {
    List<TouristAttraction> listOfTuristAttractions = service.getListOfTouristattractions();
    return new ResponseEntity<>(listOfTuristAttractions, HttpStatus.OK);
    }

@GetMapping ("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionsName(@PathVariable String name) {
        TouristAttraction attraction = service.getAttractionByName(name);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }

@PostMapping("/add")
public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction touristattraction) {
    TouristAttraction newTouristAttraction = service.add(touristattraction);
    return new ResponseEntity<> (newTouristAttraction, HttpStatus.CREATED);
}

@PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name) {
    TouristAttraction deletedTouristAttraction = service.deleteAttractionByName(name);
    return new ResponseEntity<> (deletedTouristAttraction, HttpStatus.OK);
}

@PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction touristattraction) {
    TouristAttraction updatedTouristAttraction = service.updateTuristAttraction(touristattraction);
    return new ResponseEntity<> (updatedTouristAttraction, HttpStatus.OK);
}



}
