package br.com.NinjaRegistration.NinjaRegistration.Missions;

import org.springframework.stereotype.Component;

@Component
public class MissionsMapper {

    public MissionsModel mapToModel(MissionsDTO missionsDTO){
        MissionsModel missionsModel = new MissionsModel();
        missionsModel.setId(missionsDTO.getId());
        missionsModel.setName(missionsDTO.getName());
        missionsModel.setDifficulty(missionsDTO.getDifficulty());
        missionsModel.setNinja(missionsDTO.getNinja());
        return missionsModel;
    }
    public MissionsDTO mapToDTO(MissionsModel missionsModel){
        MissionsDTO missionsDTO = new MissionsDTO();
        missionsDTO.setId(missionsModel.getId());
        missionsDTO.setName(missionsModel.getName());
        missionsDTO.setDifficulty(missionsModel.getDifficulty());
        missionsDTO.setNinja(missionsModel.getNinja());
        return missionsDTO;
    }

    public void updateFromDTO(MissionsDTO dto, MissionsModel model){
        if (dto.getName() != null) model.setName(dto.getName());
        if (dto.getDifficulty() != null) model.setDifficulty(dto.getDifficulty());
        if (dto.getNinja() != null) model.setNinja(dto.getNinja());
    }
}
