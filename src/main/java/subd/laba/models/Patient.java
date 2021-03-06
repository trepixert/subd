package subd.laba.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fio;
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private String gender;

    public Patient() {
    }

    @OneToMany
    @JoinTable(name = "coupontoseeadoctor" ,
            joinColumns = @JoinColumn (name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
    private List<CouponToSeeADoctor> couponToSeeADoctors;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public List<CouponToSeeADoctor> getCouponToSeeADoctors() {
        return couponToSeeADoctors;
    }

    public void setCouponToSeeADoctors(List<CouponToSeeADoctor> couponToSeeADoctors) {
        this.couponToSeeADoctors = couponToSeeADoctors;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
