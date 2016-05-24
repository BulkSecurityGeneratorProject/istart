package com.istart.framework.repository;

import org.springframework.data.jpa.repository.Query;

import com.istart.framework.domain.Dic;
import com.istart.framework.domain.DicType;
import com.istart.framework.repository.base.JpaSpecificationPagingRepository;

/**
 * Spring Data JPA repository for the Dic entity.
 */
public interface DicRepository extends JpaSpecificationPagingRepository<Dic,Long> {

	@Query("select dicType from DicType dicType left outer join dicType.dics dic  where dicType.dicTypeCode = ?1 and dic.dicCode = ?2")
	public DicType findByDicTypeCodeAndDicCode(String dicTypeCode, String dicCode);
}
