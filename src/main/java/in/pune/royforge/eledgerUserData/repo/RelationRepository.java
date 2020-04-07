package in.pune.royforge.eledgerUserData.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.pune.royforge.eledgerUserData.data.entity.RelationDataEntity;

public interface RelationRepository extends PagingAndSortingRepository<RelationDataEntity, Long> {

}
