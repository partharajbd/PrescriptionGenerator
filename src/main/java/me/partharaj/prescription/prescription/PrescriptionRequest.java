package me.partharaj.prescription.prescription;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@AllArgsConstructor
public class PrescriptionRequest {
    @NotNull(message = "Date field is mandatory")
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private final Date prescriptionDate;
    @NotBlank(message = "Patient name is mandatory")
    private final String patientName;
    @NotNull(message = "Age is mandatory")
    @Min(0)
    @Max(110)
    private final Integer age;
    @NotBlank(message = "Gender is mandatory")
    private final String gender;
    @NotBlank(message = "Diagnosis field is mandatory")
    private final String diagnosis;
    @NotBlank(message = "Medicine field is mandatory")
    private final String medicines;
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private final Date nextVisitDate;
}
