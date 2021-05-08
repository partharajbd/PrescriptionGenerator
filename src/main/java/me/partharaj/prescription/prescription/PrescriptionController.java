package me.partharaj.prescription.prescription;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@AllArgsConstructor
public class PrescriptionController {

    PrescriptionService prescriptionService;

    @GetMapping("/")
    public String prescriptionList(Model model,
                                   @RequestParam(value = "from", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
                                   @RequestParam(value = "to", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate){

        if (fromDate == null || toDate == null) {
            Calendar date = Calendar.getInstance();
            toDate = date.getTime();
            date.set(Calendar.DAY_OF_MONTH, 1);
            fromDate = date.getTime();
        }

        List<Prescription> prescriptions = prescriptionService.findByDateRange(fromDate, toDate);
        model.addAttribute("prescriptions", prescriptions);

        return "prescription/list_of_prescription";
    }

    @GetMapping("/prescription/{id}")
    public String prescriptionShow(@PathVariable("id") Long prescriptionId, Model model){
        Prescription prescription = prescriptionService.findById(prescriptionId);
        if (prescription == null) {
            return "redirect:/";
        }

        model.addAttribute(prescription);
        return "prescription/show_prescription";
    }

    @GetMapping("/prescription/create")
    public String prescriptionCreateForm(PrescriptionRequest prescriptionRequest){
        return "prescription/create_prescription";
    }

    @PostMapping("/prescription")
    public String prescriptionSave(@Valid PrescriptionRequest prescriptionRequest, BindingResult result){
        if (result.hasErrors()) {
            return "prescription/create_prescription";
        }
        prescriptionService.savePrescription(prescriptionRequest);
        return "redirect:/";
    }

    @GetMapping("/prescription/{id}/edit")
    public String prescriptionEditForm(PrescriptionRequest prescriptionRequest,
                                         @PathVariable("id") Long prescriptionId,
                                         Model model){
        Prescription prescription = prescriptionService.findById(prescriptionId);
        if (prescription == null)
            return "redirect:/";

        prescriptionRequest = new PrescriptionRequest(
                prescription.getPrescriptionDate(),
                prescription.getPatientName(),
                prescription.getAge(),
                prescription.getGender(),
                prescription.getDiagnosis(),
                prescription.getMedicines(),
                prescription.getNextVisitDate()
        );

        model.addAttribute(prescriptionRequest);
        model.addAttribute("id", prescriptionId);

        return "prescription/update_prescription";
    }

    @PutMapping("/prescription/{id}")
    public String prescriptionUpdate(@Valid PrescriptionRequest prescriptionRequest,
                                         BindingResult result,
                                         @PathVariable("id") Long prescriptionId,
                                         Model model){
        if (result.hasErrors()) {
            model.addAttribute(prescriptionRequest);
            model.addAttribute("id", prescriptionId);
            return "prescription/update_prescription";
        }

        prescriptionService.updatePrescription(prescriptionId, prescriptionRequest);

        return "redirect:/";
    }

    @DeleteMapping("/prescription/{id}")
    public String prescriptionCreateForm(@PathVariable("id") Long prescriptionId){
        prescriptionService.deletePrescription(prescriptionId);
        return "redirect:/";
    }

    @GetMapping("/prescription/report")
    public String report(Model model){
        List<Map<Date, Long>> counts = prescriptionService.getDateWisePrescriptionCount();
        model.addAttribute("counts", counts);
        return "prescription/report_prescription";
    }
}
