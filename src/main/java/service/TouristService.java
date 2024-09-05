package service;

import model.TouristAttraction;
import org.springframework.stereotype.Service;
import repository.TouristRepository;

import java.util.List;

@Service
public class TouristService {

    private TouristRepository tr;

    public TouristService(TouristRepository tr) {
        this.tr = tr;
    }

    ////////////////////CRUD//////////////////////////////
    public void addTouristAttraction(String name, String description) {
        tr.addTouristAttraction(name, description);
    }
    public List<TouristAttraction> getListOfAttractions() {
        return tr.getFullTouristRepository();
    }
    public TouristAttraction getSpecificTouristAttraction(String name) {
        return tr.getByNameTouristRepository(name);
    }

    //MANGLER UPDATE??
    public void deleteAttraction(String name) {
        tr.deleteAttraction(name);
    }

}
