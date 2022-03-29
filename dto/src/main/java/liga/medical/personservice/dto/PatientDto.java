package liga.medical.personservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    private String firstName;

    private String lastName;

    private String middleName;

    private String gender;

    private LocalDate birthdayDt;

    private String phoneNumber;

}
