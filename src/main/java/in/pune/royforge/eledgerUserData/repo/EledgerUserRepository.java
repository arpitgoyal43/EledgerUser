package in.pune.royforge.eledgerUserData.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.pune.royforge.eledgerUserData.data.entity.LenderDataEntity;

public interface EledgerUserRepository extends PagingAndSortingRepository<LenderDataEntity, Long> {

}