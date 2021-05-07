package me.partharaj.prescription.prescription;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    List<Prescription> findPrescriptionByPrescriptionDateGreaterThanEqualAndPrescriptionDateLessThanEqual(Date from, Date to);
}
