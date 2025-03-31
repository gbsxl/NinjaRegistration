package br.com.NinjaRegistration.NinjaRegistration.Ninjas;

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
    public String create(){
        return "created Ninja";
    }

    //Print all Ninjas (READ)
    @GetMapping("/print-all")
    public List<NinjaModel> printAll(){
        return ninjaService.printAll();
    }

    //Print Ninja by ID (READ)
    @GetMapping("/print-by-id")
    public String printByID(){
        return "printed Ninja by id";
    }

    //Modify Ninja's Data (UPDATE)
    @PutMapping("/update-by-id")
    public String modifyDataByID(){
        return "modified ninja data by ID";
    }
    //Delete Ninja (DELETE)
    @DeleteMapping("/delete-by-id")
    public String deleteByID(){
        return "ninja deleted";
    }
}
