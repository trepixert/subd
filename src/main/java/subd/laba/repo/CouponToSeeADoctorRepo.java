package subd.laba.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import subd.laba.models.CouponToSeeADoctor;
import subd.laba.models.Doctor;
import subd.laba.models.Patient;

import java.util.List;

public interface CouponToSeeADoctorRepo extends JpaRepository<CouponToSeeADoctor,Long> {
    List<CouponToSeeADoctor> findCouponToSeeADoctorsByPatient(Patient patient);
    List<CouponToSeeADoctor> findCouponToSeeADoctorsByDoctor(Doctor doctor);
}
