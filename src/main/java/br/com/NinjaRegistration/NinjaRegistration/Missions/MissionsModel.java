package br.com.NinjaRegistration.NinjaRegistration.Missions;

import br.com.NinjaRegistration.NinjaRegistration.Ninjas.NinjaModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_missions")
public class MissionsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private char rank;

    //Many Ninjas can have the same Mission
    @OneToMany(mappedBy = "ninja")
    private NinjaModel ninja;
}
