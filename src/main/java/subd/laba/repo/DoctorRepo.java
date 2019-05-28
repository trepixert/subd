package subd.laba.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import subd.laba.models.CouponToSeeADoctor;
import subd.laba.models.Doctor;

import java.util.List;

public interface DoctorRepo extends JpaRepository<Doctor,Long> {
    Doctor findDoctorByCouponToSeeADoctors(List<CouponToSeeADoctor> coupon);
}
