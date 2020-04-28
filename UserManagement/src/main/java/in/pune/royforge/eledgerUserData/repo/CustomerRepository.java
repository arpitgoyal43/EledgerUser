package in.pune.royforge.eledgerUserData.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.pune.royforge.eledgerUserData.data.entity.CustomerDataEntity;

public interface CustomerRepository extends PagingAndSortingRepository<CustomerDataEntity, Long> {

}
