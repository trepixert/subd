package subd.laba.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import subd.laba.models.CouponToSeeADoctor;
import subd.laba.models.Doctor;
import subd.laba.models.Patient;
import subd.laba.repo.CouponToSeeADoctorRepo;
import subd.laba.services.CouponToSeeADoctorService;
import subd.laba.services.DoctorService;
import subd.laba.services.PatientService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CouponToSeeADoctorServiceImpl implements CouponToSeeADoctorService {
    @Autowired
    private CouponToSeeADoctorRepo couponToSeeADoctorRepo;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Override
    public List<CouponToSeeADoctor> findAll() {
        return couponToSeeADoctorRepo.findAll();
    }

    @Override
    public Optional<CouponToSeeADoctor> findById(long id) {
        return couponToSeeADoctorRepo.findById(id);
    }

    @Override
    public void save(CouponToSeeADoctor coupon) {
        CouponToSeeADoctor c = couponToSeeADoctorRepo.findById(coupon.getId())
                .orElseThrow(IllegalArgumentException::new);
        c.setDateOfAppointment(coupon.getDateOfAppointment());
        c.setNumberOfCoupon(coupon.getNumberOfCoupon());
        c.setTimeOfIssue(coupon.getTimeOfIssue());
        couponToSeeADoctorRepo.save(c);
    }

    @Override
    public List<CouponToSeeADoctor> findCouponToSeeADoctorsByPatient(Patient patient) {
        return couponToSeeADoctorRepo.findCouponToSeeADoctorsByPatient(patient);
    }

    @Override
    public List<CouponToSeeADoctor> findCouponToSeeADoctorsByDoctor(Doctor doctor) {
        return couponToSeeADoctorRepo.findCouponToSeeADoctorsByDoctor(doctor);
    }

    @Override
    public void delete(CouponToSeeADoctor coupon) {
        Patient patient = patientService.findPatientByCouponToSeeADoctors(Collections.singletonList(coupon));
        Doctor doctor = doctorService.findDoctorByCouponToSeeADoctors(Collections.singletonList(coupon));
        patient.getCouponToSeeADoctors().remove(coupon);
        doctor.getCouponToSeeADoctors().remove(coupon);
        patientService.save(patient);
        doctorService.save(doctor);
    }

    @Override
    public void delete(List<CouponToSeeADoctor> coupon) {

    }


}
