package br.com.NinjaRegistration.NinjaRegistration.Ninjas;

import br.com.NinjaRegistration.NinjaRegistration.Missions.MissionsModel;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_ninja_registration")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private int age;

    //One Ninja haves a one Mission
    @ManyToOne
    @JoinColumn(name = "mission_id") // Foreign Key
    private MissionsModel mission;
}
