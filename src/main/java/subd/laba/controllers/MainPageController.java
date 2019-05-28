package subd.laba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import subd.laba.models.CouponToSeeADoctor;
import subd.laba.models.Doctor;
import subd.laba.models.Patient;
import subd.laba.services.CouponToSeeADoctorService;
import subd.laba.services.DoctorService;
import subd.laba.services.PatientService;

import javax.validation.Valid;

@Controller
public class MainPageController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private CouponToSeeADoctorService couponToSeeADoctorService;

    @GetMapping
    public String main(Model model){
        model.addAttribute("patients",patientService.findAll());
        model.addAttribute("doctors", doctorService.findAll());
        model.addAttribute("coupons",couponToSeeADoctorService.findAll());
        model.addAttribute("patientsWithCoupons",patientService.findAllByQuery());
        return "main";
    }

    @GetMapping("patient/edit/{id}")
    public String patientEdit(@PathVariable(name = "id") long id, Model model){
        Patient patient = patientService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:"+id));
        model.addAttribute("patient", patient);
        return "parts/patientEdit";
    }

    @PostMapping("patient/edit/{id}")
    public String patientEdit(@PathVariable(name = "id") long id, @Valid Patient patient,
                              BindingResult result, Model model){
        if(result.hasErrors()){
            patient.setId(id);
            return "parts/patientEdit";
        }
        patientService.save(patient);
        model.addAttribute("patients",patientService.findAll());
        return "redirect:/home";
    }

    @GetMapping("doctor/edit/{id}")
    public String doctorEdit(@PathVariable(name = "id") long id, Model model){
        Doctor doctor = doctorService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:"+id));
        model.addAttribute("doctor", doctor);
        return "parts/doctorEdit";
    }

    @PostMapping("doctor/edit/{id}")
    public String doctorEdit(@PathVariable(name = "id") long id, @Valid Doctor doctor,
                              BindingResult result, Model model){
        if(result.hasErrors()){
            doctor.setId(id);
            return "parts/doctorEdit";
        }
        doctorService.save(doctor);
        model.addAttribute("doctors",doctorService.findAll());
        return "redirect:/home";
    }

    @GetMapping("couponToSeeADoctorEdit/edit/{id}")
    public String couponToSeeADoctorEdit(@PathVariable(name = "id") long id, Model model){
        CouponToSeeADoctor coupon = couponToSeeADoctorService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:"+id));
        model.addAttribute("coupon", coupon);
        return "parts/couponEdit";
    }

    @PostMapping("couponToSeeADoctorEdit/edit/{id}")
    public String couponToSeeADoctorEdit(@PathVariable(name = "id") long id, @Valid CouponToSeeADoctor coupon,
                             BindingResult result, Model model){
        if(result.hasErrors()){
            coupon.setId(id);
            return "parts/couponEdit";
        }
        couponToSeeADoctorService.save(coupon);
        model.addAttribute("doctors",doctorService.findAll());
        return "redirect:/home";
    }

    @GetMapping("patient/delete/{id}")
    public String deletePatient(@PathVariable("id") long id, Model model) {
        Patient patient = patientService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        patientService.delete(patient);
        model.addAttribute("patients", patientService.findAll());
        return "redirect:/home";
    }

    @GetMapping("doctor/delete/{id}")
    public String deleteDoctor(@PathVariable("id") long id, Model model) {
        Doctor doctor = doctorService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        doctorService.delete(doctor);
        model.addAttribute("doctors", doctorService.findAll());
        return "redirect:/home";
    }

/*    @GetMapping("/addPatient")
    public String addPatient(){

    }*/
}
