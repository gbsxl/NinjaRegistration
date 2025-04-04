package br.com.NinjaRegistration.NinjaRegistration.Missions;

import br.com.NinjaRegistration.NinjaRegistration.Ninjas.NinjaDTO;
import br.com.NinjaRegistration.NinjaRegistration.Ninjas.NinjaMapper;
import br.com.NinjaRegistration.NinjaRegistration.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissionsService {
    private MissionsRepository missionsRepository;
    private MissionsMapper missionsMapper;
    private NinjaMapper ninjaMapper;

    public MissionsService(MissionsRepository missionsRepository, MissionsMapper missionsMapper, NinjaMapper ninjaMapper) {
        this.missionsRepository = missionsRepository;
        this.missionsMapper = missionsMapper;
        this.ninjaMapper = ninjaMapper;
    }

    public MissionsDTO create(MissionsDTO missionsDTO) {
        MissionsModel missionsModel = missionsMapper.mapToModel(missionsDTO);
        missionsModel = missionsRepository.save(missionsModel);
        return missionsMapper.mapToDTO(missionsModel);
    }

    public List<MissionsDTO> printAll() {
        List<MissionsModel> missions = missionsRepository.findAll();
        return missions.stream()
                .map(missionsMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public MissionsDTO printById(Long id) {
        Optional<MissionsModel> missionsModel = missionsRepository.findById(id);
        return missionsModel.map(missionsMapper::mapToDTO).orElse(null);
    }

    public List<NinjaDTO> printNinjas(Long id){
        List<NinjaModel> ninjas = missionsRepository.findById(id).orElseThrow().getNinja();
        return ninjas.stream().map(ninjaMapper::map).collect(Collectors.toList());
    }

    public MissionsDTO update(MissionsDTO missionsDTO, Long id) {
        Optional<MissionsModel> base = missionsRepository.findById(id);
        if(base.isPresent()){
            MissionsModel original = base.get();
            missionsMapper.updateFromDTO(missionsDTO, original);
            original = missionsRepository.save(original);
            return missionsMapper.mapToDTO(original);
        }
        return null;
    }

    public void delete(Long id) {
        if (missionsRepository.findById(id).isPresent()) {
            missionsRepository.deleteById(id);
        }
    }
}
