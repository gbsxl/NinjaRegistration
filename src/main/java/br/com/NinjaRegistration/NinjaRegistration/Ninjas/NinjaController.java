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
    public NinjaModel create(@RequestBody NinjaModel ninjaModel){
        return ninjaService.createNinja(ninjaModel);
    }

    //Print all Ninjas (READ)
    @GetMapping("/print/all")
    public List<NinjaModel> printAll(){
        return ninjaService.printAll();
    }

    //Print Ninja by ID (READ)
    @GetMapping("/print/{id}")
    public NinjaModel printByID(@PathVariable Long id){
        return ninjaService.printByID(id);
    }

    //Modify Ninja's Data (UPDATE)
    @PutMapping("/update/{id}")
    public NinjaModel updateData(@PathVariable Long id, @RequestBody NinjaModel ninjaModel){
        return ninjaService.updateData(ninjaModel, id);
    }

    //Delete Ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        ninjaService.delete(id);
    }
}
