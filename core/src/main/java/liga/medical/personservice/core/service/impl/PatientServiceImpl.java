package liga.medical.personservice.core.service.impl;

import api.PatientServiceFeignClient;
import liga.medical.personservice.core.model.PatientEntity;
import liga.medical.personservice.core.repository.PatientRepository;
import liga.medical.personservice.core.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientServiceFeignClient patientServiceFeignClient;

    @Override
    public PatientEntity findById(Long patientId) {
        return patientRepository.findById(patientId);
    }

    @Override
    public int insert(PatientEntity patientEntity) {
        return patientRepository.insert(patientEntity);
    }

    @Override
    public List<PatientEntity> findByIds(List<Long> patientIds) {
        return patientRepository.findByIds(patientIds);
    }

    @Override
    public int insertAll(List<PatientEntity> patientEntityList) {
        return patientRepository.insertAll(patientEntityList);
    }

    @Override
    public Boolean updateById(PatientEntity patientEntity) {
        return patientRepository.updateById(patientEntity);
    }

    @Override
    public Boolean deleteById(Long patientId) {
        return patientRepository.deleteById(patientId);
    }
}
