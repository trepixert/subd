package subd.laba.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import subd.laba.models.CouponToSeeADoctor;
import subd.laba.models.Patient;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient,Long> {
    @Query(value = "SELECT DISTINCT p.id, p.fio,p.gender,p.date " +
            "FROM patient p join coupontoseeadoctor c on p.id = c.patient_id " +
            "JOIN doctor d on c.doctor_id = d.id",nativeQuery = true)
    List<Patient> findAllByQuery();
    Patient findPatientByFio(String fio);

    Patient findPatientByCouponToSeeADoctors(List<CouponToSeeADoctor> coupon);
}
