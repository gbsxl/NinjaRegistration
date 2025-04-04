package br.com.NinjaRegistration.NinjaRegistration.Missions;

import br.com.NinjaRegistration.NinjaRegistration.Ninjas.NinjaDTO;
import br.com.NinjaRegistration.NinjaRegistration.Ninjas.NinjaModel;
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
    public MissionsDTO createMissions(@RequestBody MissionsDTO missionsDTO){
        return missionsService.create(missionsDTO);
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
    public MissionsDTO update(@RequestBody MissionsDTO missionsDTO, @PathVariable Long id){
        return missionsService.update(missionsDTO, id);
    }

    //Delete missions by id (DELETE)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        missionsService.delete(id);
    }
}
