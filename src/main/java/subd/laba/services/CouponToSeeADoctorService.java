package subd.laba.services;

import subd.laba.models.CouponToSeeADoctor;
import subd.laba.models.Doctor;
import subd.laba.models.Patient;

import java.util.List;
import java.util.Optional;

public interface CouponToSeeADoctorService {
    List<CouponToSeeADoctor> findAll();

    Optional<CouponToSeeADoctor> findById(long id);

    void save(CouponToSeeADoctor coupon);

    List<CouponToSeeADoctor> findCouponToSeeADoctorsByPatient(Patient patient);

    List<CouponToSeeADoctor> findCouponToSeeADoctorsByDoctor(Doctor doctor);

    void delete(CouponToSeeADoctor coupon);

    void delete(List<CouponToSeeADoctor> coupon);
}
