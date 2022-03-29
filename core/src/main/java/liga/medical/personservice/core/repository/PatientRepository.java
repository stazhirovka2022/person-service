package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.PatientEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PatientRepository {

    @Select("select * from patient where id = #{patientId}")
    PatientEntity findById(Long patientId);

    @Insert("insert into patient (first_name, last_name, middle_name, gender, birthday_dt, phone_number) " +
            "values(#{firstName}, #{last_name}, #{middle_name}, #{gender}, #{birthdayDt}, #{phoneNumber}  )")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(PatientEntity patientEntity);

    List<PatientEntity> findByIds(@Param("patientIds") List<Long> patientIds);

    int insertAll(@Param("patientList") List<PatientEntity> patientEntityList);

    Boolean updateById(@Param("patientEntity") PatientEntity patientEntity);

    Boolean deleteById(@Param("patientId") Long patientId);
}
