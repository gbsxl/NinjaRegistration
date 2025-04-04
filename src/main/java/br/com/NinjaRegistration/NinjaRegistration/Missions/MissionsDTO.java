package br.com.NinjaRegistration.NinjaRegistration.Missions;

import br.com.NinjaRegistration.NinjaRegistration.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionsDTO {
    private Long id;
    private String name;
    private String difficulty;
    private List<NinjaModel> ninja;
}
