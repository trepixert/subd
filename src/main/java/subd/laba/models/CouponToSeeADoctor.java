package subd.laba.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "coupontoseeadoctor")
public class CouponToSeeADoctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value = TemporalType.DATE)
    private Date dateOfAppointment;

    @DateTimeFormat(pattern = "hh:mm:ss")
    @Temporal(value = TemporalType.TIME)
    private Date timeOfIssue;

    @ManyToMany(mappedBy = "couponToSeeADoctors")
    private List<Patient> patient;

    @ManyToMany(mappedBy = "couponToSeeADoctors")
    private List<Doctor> doctor;

    private String numberOfCoupon;

    public CouponToSeeADoctor(Date dateOfAppointment, Date timeOfIssue, String numberOfCoupon) {
        this.dateOfAppointment = dateOfAppointment;
        this.timeOfIssue = timeOfIssue;
        this.numberOfCoupon = numberOfCoupon;
    }

    public CouponToSeeADoctor(String numberOfCoupon) {
        this.numberOfCoupon = numberOfCoupon;
    }

    public CouponToSeeADoctor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(Date dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public Date getTimeOfIssue() {
        return timeOfIssue;
    }

    public void setTimeOfIssue(Date timeOfIssue) {
        this.timeOfIssue = timeOfIssue;
    }

    public List<Patient> getPatient() {
        return patient;
    }

    public void setPatient(List<Patient> patient) {
        this.patient = patient;
    }

    public List<Doctor> getDoctor() {
        return doctor;
    }

    public void setDoctor(List<Doctor> doctor) {
        this.doctor = doctor;
    }

    public String getNumberOfCoupon() {
        return numberOfCoupon;
    }

    public void setNumberOfCoupon(String numberOfCoupon) {
        this.numberOfCoupon = numberOfCoupon;
    }
}
