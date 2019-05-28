package subd.laba.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import subd.laba.models.CouponToSeeADoctor;
import subd.laba.models.Patient;
import subd.laba.repo.PatientRepo;
import subd.laba.services.CouponToSeeADoctorService;
import subd.laba.services.PatientService;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private CouponToSeeADoctorService couponToSeeADoctorService;

    public List<Patient> findAll(){
           return patientRepo.findAll();
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return patientRepo.findById(id);
    }

    @Override
    public void save(Patient patient) {
        patientRepo.save(patient);
    }

    @Override
    public void delete(Patient patient) {
        couponToSeeADoctorService.findCouponToSeeADoctorsByPatient(patient).clear();
        patient.getCouponToSeeADoctors().clear();
        patientRepo.delete(patient);
    }

    @Override
    public List<Patient> findAllByQuery() {
        return patientRepo.findAllByQuery();
    }

    @Override
    public Patient findPatientByCouponToSeeADoctors(List<CouponToSeeADoctor> coupon) {
        return patientRepo.findPatientByCouponToSeeADoctors(coupon);
    }

}
