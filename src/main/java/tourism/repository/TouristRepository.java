package tourism.repository;

import org.springframework.stereotype.Repository;
import tourism.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    private List<TouristAttraction> listOfTouristAttractions = new ArrayList<>();

    public TouristRepository() {
        addTouristAttractions();
    }

    private void addTouristAttractions() {

        listOfTouristAttractions.add(new TouristAttraction("TuristAttraction1", "Description1"));
        listOfTouristAttractions.add(new TouristAttraction("TuristAttraction2", "Description2"));
    }

    public List<TouristAttraction> getListOfTouristAttractions() {
        return listOfTouristAttractions;
    }

    public TouristAttraction GetTouristAttractionByName(String name) {
        TouristAttraction touristAttraction = null;
        for (int i = 0; i < listOfTouristAttractions.size(); i++) {
            if (name.equals(listOfTouristAttractions.get(i).getName())) {
                touristAttraction = listOfTouristAttractions.get(i);
            }
        }
        return touristAttraction;
    }

    public TouristAttraction add(TouristAttraction touristAttraction) {
        listOfTouristAttractions.add(touristAttraction);
        return touristAttraction;
    }

    public TouristAttraction deleteAttractionByName(String name) {
        TouristAttraction touristAttraction = null;
        for (int i = 0; i < listOfTouristAttractions.size(); i++) {
            if (name.equals(listOfTouristAttractions.get(i).getName())) {
                touristAttraction = listOfTouristAttractions.get(i);
                listOfTouristAttractions.remove(touristAttraction);
            }

        }
        return touristAttraction;
    }

    public TouristAttraction updateTuristAttraction(TouristAttraction touristAttraction) {
        for (TouristAttraction t: listOfTouristAttractions) {
            if (t.getName().equals(touristAttraction.getName())) {
                t.setDescription(touristAttraction.getDescription());
            }
        }
        /*for (int i = 0; i < listOfTouristAttractions.size(); i++) {
            if (listOfTouristAttractions.get(i).getName().equals(touristAttraction.getName())) {
                listOfTouristAttractions.get(i).setDescription(touristAttraction.getDescription());
            }

        }*/
        return touristAttraction;
    }
}