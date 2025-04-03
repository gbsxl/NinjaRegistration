package br.com.NinjaRegistration.NinjaRegistration.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> printAll(){
        return ninjaRepository.findAll();
    }

    public NinjaModel printByID(Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }

    public NinjaModel createNinja(NinjaModel ninjaModel){
        return ninjaRepository.save(ninjaModel);
    }

    public void delete(Long id){
        ninjaRepository.deleteById(id);
    }

    public NinjaModel updateData(NinjaModel ninjaModel, Long id){
        Optional<NinjaModel> ninjaModelAux = ninjaRepository.findById(id);
        if(ninjaModelAux.equals(Optional.of(ninjaModel))){
            return ninjaRepository.findById(id).orElse(null);
        }
        return ninjaRepository.save(ninjaModel);
    }

}
