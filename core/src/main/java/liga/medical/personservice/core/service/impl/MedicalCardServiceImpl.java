package liga.medical.personservice.core.service.impl;

import liga.medical.personservice.core.model.MedicalCardEntity;
import liga.medical.personservice.core.repository.MedicalCardRepository;
import liga.medical.personservice.core.service.MedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalCardServiceImpl implements MedicalCardService {

    @Autowired
    MedicalCardRepository medicalCardRepository;

    @Override
    public MedicalCardEntity findById(Long cardId) {
        return medicalCardRepository.findById(cardId);
    }

    @Override
    public int insert(MedicalCardEntity cardEntity) {
        return medicalCardRepository.insert(cardEntity);
    }

    @Override
    public List<MedicalCardEntity> findByIds(List<Long> cardIds) {
        return medicalCardRepository.findByIds(cardIds);
    }

    @Override
    public int insertAll(List<MedicalCardEntity> cardEntityList) {
        return medicalCardRepository.insertAll(cardEntityList);
    }

    @Override
    public Boolean updateById(MedicalCardEntity cardEntity) {
        return medicalCardRepository.updateById(cardEntity);
    }

    @Override
    public Boolean deleteById(Long cardId) {
        return medicalCardRepository.deleteById(cardId);
    }
}
