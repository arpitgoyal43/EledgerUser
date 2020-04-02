package in.pune.royforge.eledgerUserData.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.pune.royforge.eledgerUserData.data.entity.UserDataEntity;

public interface EledgerUserRepository extends PagingAndSortingRepository<UserDataEntity, Long> {

}