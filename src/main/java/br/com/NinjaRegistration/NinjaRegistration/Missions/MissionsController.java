package br.com.NinjaRegistration.NinjaRegistration.Missions;

import br.com.NinjaRegistration.NinjaRegistration.Ninjas.NinjaDTO;
import br.com.NinjaRegistration.NinjaRegistration.Ninjas.NinjaModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/missions")
public class MissionsController {
    MissionsService missionsService;

    public MissionsController(MissionsService missionsService) {
        this.missionsService = missionsService;
    }

    //create Missions (CREATE)
    @PostMapping("/create")
    public ResponseEntity<String> createMissions(@RequestBody MissionsDTO missionsDTO){
        missionsService.create(missionsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Mission '" + missionsDTO.getName() + "' created");
    }

    @GetMapping("/print/all")
    public List<MissionsDTO> printAll(){
        return missionsService.printAll();
    }

    @GetMapping("/print/{id}")
    public MissionsDTO printById(@PathVariable Long id){
        return missionsService.printById(id);
    }

    @GetMapping("/print/{id}/ninjas")
    public List<NinjaDTO> printNinjas(@PathVariable Long id){
        return missionsService.printNinjas(id);
    }

    //Modify mission by id (UPDATE)
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody MissionsDTO missionsDTO, @PathVariable Long id){
        if(printById(id) != null){
            missionsService.update(missionsDTO, id);
            return ResponseEntity.status(HttpStatus.OK).body("Mission " + printById(id).getName() + " data updated");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mission " + printById(id).getName() + " was not found and also not updated");
        }
    }

    //Delete missions by id (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if (missionsService.printById(id) != null) {
            missionsService.delete(id);
            return ResponseEntity.ok().body("ID: " + id +", Mission " + printById(id).getName() + " deleted");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mission id: " + id + " not found");
        }
    }
}
