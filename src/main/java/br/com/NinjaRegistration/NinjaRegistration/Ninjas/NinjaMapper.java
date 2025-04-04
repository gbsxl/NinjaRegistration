package br.com.NinjaRegistration.NinjaRegistration.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public NinjaModel map(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setName(ninjaDTO.getName());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setAge(ninjaDTO.getAge());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setMissions(ninjaDTO.getMissions());
        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setName(ninjaModel.getName());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setAge(ninjaModel.getAge());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setMissions(ninjaModel.getMissions());
        return ninjaDTO;
    }

    public void updateFromDto(NinjaDTO dto, NinjaModel model) {
        if (dto.getAge() != null) model.setAge(dto.getAge());
        if (dto.getName() != null) model.setName(dto.getName());
        if (dto.getRank() != null) model.setRank(dto.getRank());
        if (dto.getEmail() != null) model.setEmail(dto.getEmail());
        if (dto.getMissions() != null) model.setMissions(dto.getMissions());
    }


}
