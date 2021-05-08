package me.partharaj.prescription.prescription;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PrescriptionService {

    PrescriptionRepository prescriptionRepository;

    public List<Prescription> findByDateRange(Date fromDate, Date toDate) {
        return prescriptionRepository.findPrescriptionByPrescriptionDateGreaterThanEqualAndPrescriptionDateLessThanEqual(fromDate, toDate);
    }

    public void savePrescription(PrescriptionRequest prescriptionRequest) {
        prescriptionRepository.save(new Prescription(
                prescriptionRequest.getPrescriptionDate(),
                prescriptionRequest.getPatientName(),
                prescriptionRequest.getAge(),
                prescriptionRequest.getGender(),
                prescriptionRequest.getDiagnosis(),
                prescriptionRequest.getMedicines(),
                prescriptionRequest.getNextVisitDate()
        ));
    }

    public boolean deletePrescription(Long prescriptionId) {
        Prescription prescription = prescriptionRepository.findById(prescriptionId).orElse(null);
        if(prescription == null)
            return false;

        prescriptionRepository.delete(prescription);
        return true;
    }

    public Prescription findById(Long prescriptionId) {
        return prescriptionRepository.findById(prescriptionId).orElse(null);
    }

    public void updatePrescription(Long prescriptionId, PrescriptionRequest prescriptionRequest) {
        prescriptionRepository.save(new Prescription(
                prescriptionId,
                prescriptionRequest.getPrescriptionDate(),
                prescriptionRequest.getPatientName(),
                prescriptionRequest.getAge(),
                prescriptionRequest.getGender(),
                prescriptionRequest.getDiagnosis(),
                prescriptionRequest.getMedicines(),
                prescriptionRequest.getNextVisitDate()
        ));
    }

    public List<Map<Date, Long>> getDateWisePrescriptionCount() {
        return prescriptionRepository.getDateWisePrescriptionCount();
    }
}
