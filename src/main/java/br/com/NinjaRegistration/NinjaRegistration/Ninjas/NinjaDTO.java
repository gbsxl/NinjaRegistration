package br.com.NinjaRegistration.NinjaRegistration.Ninjas;

import br.com.NinjaRegistration.NinjaRegistration.Missions.MissionsModel;
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
    private int age;
    private String rank;
    private MissionsModel missions;
}
