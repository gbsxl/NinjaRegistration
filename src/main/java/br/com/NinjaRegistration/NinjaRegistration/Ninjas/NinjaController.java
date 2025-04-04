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
    public NinjaDTO create(@RequestBody NinjaDTO ninjaDTO){
        return ninjaService.createNinja(ninjaDTO);
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
    public NinjaDTO updateData(@PathVariable Long id, @RequestBody NinjaDTO ninjaModel){
        return ninjaService.updateData(ninjaModel, id);
    }

    //Delete Ninja (DELETE)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        ninjaService.delete(id);
    }
}
