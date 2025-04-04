package br.com.NinjaRegistration.NinjaRegistration.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaModel> printAll(){
        return ninjaRepository.findAll();
    }

    public NinjaModel printByID(Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }

    public NinjaDTO createNinja(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO); // map NinjaModel with DTO arguments
        ninjaModel = ninjaRepository.save(ninjaModel); // Did a query POST using NinjaModel
        return ninjaMapper.map(ninjaModel); // return map from NinjaModel to NinjaDTO
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
