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
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name = "rank")
    private String rank;

    //One Ninja haves a one Mission
    @ManyToOne
    @JoinColumn(name = "missions_id")// Foreign Key
    private MissionsModel missions;
}
