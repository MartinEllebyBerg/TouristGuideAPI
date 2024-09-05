package repository;

import model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    private List<TouristAttraction> touristRepository = new ArrayList<>();

    public TouristRepository() {
        addHardcodetDataTilListe();
    }

    /////////////////////CRUD/////////////////////
    public void addHardcodetDataTilListe() {
        touristRepository.add(new TouristAttraction("Tivoli", "Forlystelsespark i centrum af KBH"));
        touristRepository.add(new TouristAttraction("Frederiksberg Have", "Åben park midt på Frederiksberg"));
        touristRepository.add(new TouristAttraction("Københavns Museum", "Museum i KBH der dækker over københavns historie"));;
    }

    public void addTouristAttraction(String name, String description) {
        touristRepository.add(new TouristAttraction(name, description));
    }

    public List<TouristAttraction> getFullTouristRepository() {
        return touristRepository;
    }

    public TouristAttraction getByNameTouristRepository(String name) {
        for (TouristAttraction t : touristRepository) {
            if (t.getName().equalsIgnoreCase(name)) {
                return t;
            }
        }
        return null;
    }

    //MANGLER UPDATE??

    public void deleteAttraction(String name) {
        for (TouristAttraction t : touristRepository) {
            if (t.getName().equalsIgnoreCase(name)) {
                touristRepository.remove(t);
            }
        }
    }
}
