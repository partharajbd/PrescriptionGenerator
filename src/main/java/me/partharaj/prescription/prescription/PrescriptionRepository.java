package me.partharaj.prescription.prescription;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    List<Prescription> findPrescriptionByPrescriptionDateGreaterThanEqualAndPrescriptionDateLessThanEqual(Date from, Date to);

    @Query("select p.prescriptionDate as date, count(p) as countOf from Prescription p group by p.prescriptionDate")
    List<Map<Date, Long>> getDateWisePrescriptionCount();
}
