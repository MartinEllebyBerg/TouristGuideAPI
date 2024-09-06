package controller;

import model.TouristAttraction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repository.TouristRepository;
import service.TouristService;

import java.util.List;

@RestController
@RequestMapping("attractions")
public class TouristController {

    private final TouristService ts;

    public TouristController(TouristService ts) {
        this.ts = ts;
    }

    @GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getFullTouristRepository() {
        List<TouristAttraction> attractions = ts.getListOfAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getByNameTouristRepository(@PathVariable String name) {
        TouristAttraction ta = ts.getSpecificTouristAttraction(name);
        if (ta != null) {
            return new ResponseEntity<>(ta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> updateTouristAttraction(@RequestBody TouristAttraction touristAttraction) {
        TouristAttraction ta = ts.getSpecificTouristAttraction(touristAttraction.getName());
        return new ResponseEntity<>(ta, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction touristAttraction) {
        TouristAttraction ta = ts.getSpecificTouristAttraction(touristAttraction.getName());

        ta.setDescription(touristAttraction.getDescription());

        return new ResponseEntity<>(ta, HttpStatus.OK);
    }

    @PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteTouristAttraction(@PathVariable String name) {
        TouristAttraction ta = ts.getSpecificTouristAttraction(name);

        ts.deleteAttraction(ta);

        return new ResponseEntity<>(ta, HttpStatus.OK);
    }

}
