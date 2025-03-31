package br.com.NinjaRegistration.NinjaRegistration.Missions;

import br.com.NinjaRegistration.NinjaRegistration.Ninjas.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_missions")
public class MissionsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rank")
    private String rank;

    //Many Ninjas can have the same Mission
    @OneToMany(mappedBy = "missions")
    @JsonIgnore
    private List<NinjaModel> ninja;
}
