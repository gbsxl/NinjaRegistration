package br.com.NinjaRegistration.NinjaRegistration.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
public class NinjaController {
    //Add Ninja (CREATE)
    @PostMapping("/create-ninja")
    public String createNinja(){
        return "created Ninja";
    }

    //Print all Ninjas (READ)
    @GetMapping("/print-ninjas")
    public String printAllNinjas(){
        return "printed all Ninjas";
    }

    //Print Ninja by ID (READ)
    @GetMapping("/print-ninja-by-id")
    public String printNinjaByID(){
        return "printed Ninja by id";
    }

    //Modify Ninja's Data (UPDATE)
    @PutMapping("/modify-ninja-data-by-id")
    public String modifyNinjaDataByID(){
        return "modified ninja data by ID";
    }
    //Delete Ninja (DELETE)
    @DeleteMapping("/delete-ninja-by-id")
    public String deleteNinja(){
        return "ninja deleted";
    }
}
