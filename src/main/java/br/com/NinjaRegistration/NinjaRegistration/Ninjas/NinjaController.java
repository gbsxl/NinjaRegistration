package br.com.NinjaRegistration.NinjaRegistration.Ninjas;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {
    NinjaService ninjaService;


    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //Add Ninja (CREATE)
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody NinjaDTO ninjaDTO){
        ninjaService.createNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja " + ninjaDTO.getName() + " created");
    }

    //Print all Ninjas (READ)
    @GetMapping("/print/all")
    public List<NinjaDTO> printAll(){
        return ninjaService.printAll();
    }

    //Print Ninja by ID (READ)
    @GetMapping("/print/{id}")
    public NinjaDTO printByID(@PathVariable Long id){
        return ninjaService.printByID(id);
    }

    //Modify Ninja's Data (UPDATE)
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateData(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO){
        if(printByID(id) != null){
            ninjaService.updateData(ninjaDTO, id);
            return ResponseEntity.status(HttpStatus.OK).body("Ninja ID: " + id + " data updated");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja ID: " + id + " was not found and also not updated");
        }
    }

    //Delete Ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if (ninjaService.printByID(id) != null) {
            ninjaService.delete(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja id: " + id + " not found");
        }
    }
}
