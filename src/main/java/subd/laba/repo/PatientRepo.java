package subd.laba.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import subd.laba.models.CouponToSeeADoctor;
import subd.laba.models.Patient;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient,Long> {
    @Query(value = "SELECT DISTINCT p.id, p.fio,p.gender,p.date,d.fio,d.position " +
            "FROM patient p join coupon_patient_int cpi on p.id = cpi.patient_id " +
            "JOIN coupontoseeadoctor c on cpi.coupon_id = c.id " +
            "JOIN coupon_doctor_int cdi on c.id = cdi.coupon_id " +
            "JOIN doctor d on cdi.doctor_id = d.id",nativeQuery = true)
    List<Patient> findAllByQuery();

    Patient findPatientByCouponToSeeADoctors(List<CouponToSeeADoctor> coupon);
}
