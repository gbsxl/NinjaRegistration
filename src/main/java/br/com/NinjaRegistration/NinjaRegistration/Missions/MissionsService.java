package br.com.NinjaRegistration.NinjaRegistration.Missions;

import br.com.NinjaRegistration.NinjaRegistration.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MissionsService {
    MissionsRepository missionsRepository;

    public MissionsService(MissionsRepository missionsRepository) {
        this.missionsRepository = missionsRepository;
    }

    public MissionsModel create(MissionsModel missionsModel) {
        return missionsRepository.save(missionsModel);
    }

    public List<MissionsModel> printAll() {
        return missionsRepository.findAll();
    }

    public MissionsModel printById(Long id) {
        Optional<MissionsModel> missionsModel = missionsRepository.findById(id);
        return missionsModel.orElse(null);
    }

    public List<NinjaModel> printNinjas(Long id){
        return missionsRepository.findById(id).orElseThrow().getNinja();
    }

    public MissionsModel update(MissionsModel missionsModel, Long id) {
        Optional<MissionsModel> missionsModelAux = missionsRepository.findById(id);
        if(missionsModelAux.equals(Optional.of(missionsModel))){
            return missionsRepository.findById(id).orElse(null);
        }
        return missionsRepository.save(missionsModel);
    }

    public void delete(Long id) {
        if (missionsRepository.findById(id).isPresent()) {
            missionsRepository.deleteById(id);
        }
    }
}
