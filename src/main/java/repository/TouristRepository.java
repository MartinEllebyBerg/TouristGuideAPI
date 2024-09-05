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

    /////////////////////CREATE/////////////////////
    public void addHardcodetDataTilListe() {
        touristRepository.add(new TouristAttraction("Tivoli", "Forlystelsespark i centrum af KBH"));
        touristRepository.add(new TouristAttraction("Frederiksberg Have", "Åben park midt på Frederiksberg"));
        touristRepository.add(new TouristAttraction("Københavns Museum", "Museum i KBH der dækker over københavns historie"));;
    }

    public void addTouristAttraction(String name, String description) {
        touristRepository.add(new TouristAttraction(name, description));
    }

    /////////////////////READ/////////////////////
    //Henter alle turistattraktioner
    public List<TouristAttraction> getFullTouristRepository() {
        return touristRepository;
    }

    //Henter en turistattraktion basseret på input
    public TouristAttraction getByNameTouristRepository(String name) {
        for (TouristAttraction t : touristRepository) {
            if (t.getName().equalsIgnoreCase(name)) {
                return t;
            }
        }
        return null;
    }

    /////////////////////UPDATE/////////////////////
    //Opdaterer en turistattraktion baseret på input


    /////////////////////DELETE/////////////////////
    public void deleteAttraction(String name) {
        for (TouristAttraction t : touristRepository) {
            if (t.getName().equalsIgnoreCase(name)) {
                touristRepository.remove(t);
            }
        }
    }
}
