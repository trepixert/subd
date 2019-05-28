package subd.laba.services;

import subd.laba.models.CouponToSeeADoctor;
import subd.laba.models.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> findAll();
    Optional<Patient> findById(Long id);
    void save(Patient patient);
    void delete(Patient patient);
    List<Patient> findAllByQuery();
    Patient findPatientByCouponToSeeADoctors(List<CouponToSeeADoctor> coupon);
}
