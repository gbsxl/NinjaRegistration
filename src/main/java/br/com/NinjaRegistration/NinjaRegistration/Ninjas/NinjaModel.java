package br.com.NinjaRegistration.NinjaRegistration.Ninjas;

import br.com.NinjaRegistration.NinjaRegistration.Missions.MissionsModel;
import jakarta.persistence.*;

import java.util.List;

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

    public NinjaModel(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
