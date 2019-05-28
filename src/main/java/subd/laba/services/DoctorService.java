package subd.laba.services;

import subd.laba.models.CouponToSeeADoctor;
import subd.laba.models.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<Doctor> findAll();

    Optional<Doctor> findById(long id);

    void save(Doctor doctor);

    void delete(Doctor doctor);

    Doctor findDoctorByCouponToSeeADoctors(List<CouponToSeeADoctor> coupon);
}
