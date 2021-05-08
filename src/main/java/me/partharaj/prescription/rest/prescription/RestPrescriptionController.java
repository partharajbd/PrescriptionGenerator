package me.partharaj.prescription.rest.prescription;

import lombok.AllArgsConstructor;
import me.partharaj.prescription.prescription.Prescription;
import me.partharaj.prescription.prescription.PrescriptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/prescription")
public class RestPrescriptionController {

    PrescriptionService prescriptionService;

    @GetMapping
    public List<Prescription> getPrescriptions(){
        return prescriptionService.getAll();
    }

}
