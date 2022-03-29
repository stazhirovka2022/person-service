package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.PatientEntity;
import liga.medical.personservice.core.service.PatientService;
import liga.medical.personservice.dto.PatientDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/save")
    void saveNewPatient(@RequestBody @Valid PatientDto patient) {
        PatientEntity patientEntity = modelMapper.map(patient, PatientEntity.class);
        patientService.insert(patientEntity);
    }

    @PostMapping("/save-all")
    void saveNewPatients(@RequestBody @Valid List<PatientDto> patient) {
        List<PatientEntity> patientEntityList = patient.stream()
                .map(el -> modelMapper.map(el, PatientEntity.class))
                .collect(Collectors.toList());
        patientService.insertAll(patientEntityList);
    }

    @GetMapping("/{id}")
    PatientDto getPatientById(@PathVariable Long id) {
        PatientEntity patient = patientService.findById(id);
        return modelMapper.map(patient, PatientDto.class);
    }

    @GetMapping("")
    List<PatientDto> getPatientsByIds(@RequestParam List<Long> ids) {
        List<PatientEntity> patient = patientService.findByIds(ids);
        return patient.stream()
                .map(el -> modelMapper.map(el, PatientDto.class))
                .collect(Collectors.toList());
    }
}
