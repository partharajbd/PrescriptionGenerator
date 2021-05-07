package me.partharaj.prescription.prescription;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Prescription {
    @Id
    @SequenceGenerator(
            name = "prescription_sequence",
            sequenceName = "prescription_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "prescription_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prescriptionDate;
    private String patientName;
    private Integer age;
    private String gender;
    private String diagnosis;
    private String medicines;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nextVisitDate;

    public Prescription(Date prescriptionDate, String patientName, Integer age, String gender, String diagnosis, String medicines, Date nextVisitDate) {
        this.prescriptionDate = prescriptionDate;
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.diagnosis = diagnosis;
        this.medicines = medicines;
        this.nextVisitDate = nextVisitDate;
    }
}
