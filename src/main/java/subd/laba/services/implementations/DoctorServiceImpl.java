package subd.laba.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import subd.laba.models.CouponToSeeADoctor;
import subd.laba.models.Doctor;
import subd.laba.repo.DoctorRepo;
import subd.laba.services.CouponToSeeADoctorService;
import subd.laba.services.DoctorService;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private CouponToSeeADoctorService couponToSeeADoctorService;

    @Override
    public List<Doctor> findAll() {
        return doctorRepo.findAll();
    }

    @Override
    public Optional<Doctor> findById(long id) {
        return doctorRepo.findById(id);
    }

    @Override
    public void save(Doctor doctor) {
        Doctor d = doctorRepo.findById(doctor.getId())
                .orElseThrow(IllegalArgumentException::new);
        d.setFio(doctor.getFio());
        d.setPosition(doctor.getPosition());
        doctorRepo.save(d);
    }

    @Override
    public void delete(Doctor doctor) {
        List<CouponToSeeADoctor> coupon = couponToSeeADoctorService.findCouponToSeeADoctorsByDoctor(doctor);
        couponToSeeADoctorService.delete(coupon);
        doctorRepo.delete(doctor);
    }

    @Override
    public Doctor findDoctorByCouponToSeeADoctors(List<CouponToSeeADoctor> coupon) {
        return doctorRepo.findDoctorByCouponToSeeADoctors(coupon);
    }
}
