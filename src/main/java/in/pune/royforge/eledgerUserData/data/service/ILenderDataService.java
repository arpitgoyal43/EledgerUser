package in.pune.royforge.eledgerUserData.data.service;

import java.util.List;

import in.pune.royforge.eledgerUserData.data.entity.LenderDataEntity;
import in.pune.royforge.eledgerUserData.data.model.LenderData;

public interface ILenderDataService {

	LenderDataEntity save(LenderData userData);

	List<LenderData> getLenders();
	
	LenderData getLender(Long userId);
}
