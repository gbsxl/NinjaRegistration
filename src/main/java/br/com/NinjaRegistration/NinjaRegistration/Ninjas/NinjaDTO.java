package br.com.NinjaRegistration.NinjaRegistration.Ninjas;

import br.com.NinjaRegistration.NinjaRegistration.Missions.MissionsModel;
import ch.qos.logback.core.model.INamedModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NinjaDTO {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String rank;
    private MissionsModel missions;
}
