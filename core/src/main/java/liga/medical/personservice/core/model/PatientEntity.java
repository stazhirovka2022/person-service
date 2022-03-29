package liga.medical.personservice.core.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientEntity {

    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String gender;

    private LocalDate birthdayDt;

    private String phoneNumber;

}
