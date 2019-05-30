package subd.laba.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fio;
    private String position;

    public Doctor() {
    }

    public Doctor(String fio, String position) {
        this.fio = fio;
        this.position = position;
    }

    @OneToMany
    @JoinTable(name = "coupontoseeadoctor" ,
            joinColumns = @JoinColumn (name = "doctor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
    private List<Patient> couponToSeeADoctors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Patient> getCouponToSeeADoctors() {
        return couponToSeeADoctors;
    }

    public void setCouponToSeeADoctors(List<Patient> couponToSeeADoctors) {
        this.couponToSeeADoctors = couponToSeeADoctors;
    }
}
