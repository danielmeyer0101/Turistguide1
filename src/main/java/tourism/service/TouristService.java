package tourism.service;

import org.springframework.stereotype.Service;
import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;

import java.util.List;

@Service
public class TouristService {

private final TouristRepository repository;

public TouristService(TouristRepository repository) {
    this.repository = repository;
}

public List<TouristAttraction> getListOfTouristattractions() {
    return repository.getListOfTouristAttractions();
}

public TouristAttraction getAttractionByName(String name) {
    return repository.GetTouristAttractionByName(name);
        }

    public TouristAttraction add(TouristAttraction touristAttraction) {
        repository.add(touristAttraction);
        return touristAttraction;
    }

    public TouristAttraction deleteAttractionByName(String name) {
        return repository.deleteAttractionByName(name);

    }

    public TouristAttraction updateTuristAttraction(TouristAttraction touristAttraction) {
    return repository.updateTuristAttraction(touristAttraction);
    }
    }




