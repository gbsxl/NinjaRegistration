package br.com.NinjaRegistration.NinjaRegistration.Missions;

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
    public MissionsModel createMissions(@RequestBody MissionsModel missionsModel){
        return missionsService.create(missionsModel);
    }

    @GetMapping("/print/all")
    public List<MissionsModel> printAll(){
        return missionsService.printAll();
    }

    @GetMapping("/print/{id}")
    public MissionsModel printById(@PathVariable Long id){
        return missionsService.printById(id);
    }

    @GetMapping("/print/{id}/ninjas")
    public List<NinjaModel> printNinjas(@PathVariable Long id){
        return missionsService.printNinjas(id);
    }

    //Modify mission by id (UPDATE)
    @PutMapping("/update/{id}")
    public MissionsModel update(@RequestBody MissionsModel missionsModel, @PathVariable Long id){
        return missionsService.update(missionsModel, id);
    }

    //Delete missions by id (DELETE)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        missionsService.delete(id);
    }
}
