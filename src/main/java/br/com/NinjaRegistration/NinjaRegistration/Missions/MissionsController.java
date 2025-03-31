package br.com.NinjaRegistration.NinjaRegistration.Missions;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
public class MissionsController {
    //create Missions (CREATE)
    @PostMapping("/create")
    public String createMissions(){
        return "created missions";
    }

    //Print Ninjas on the Mission by id (READ)
    @GetMapping("/print-ninjas-by-id")
    public String printNinjasByID(){
        return "printed ninjas on the mission";
    }

    //Modify mission by id (UPDATE)
    @PutMapping("/update-by-id")
    public String updateById(){
        return "updated data mission by id";
    }

    //Delete missions by id (DELETE)
    @DeleteMapping("/delete-by-id")
    public String deleteByID(){
        return "deleted mission by id";
    }
}
