package in.pune.royforge.eledgerUserData.data.dao;

import java.util.List;

import in.pune.royforge.eledgerUserData.data.entity.LenderDataEntity;
import in.pune.royforge.eledgerUserData.data.model.LenderData;

public interface ILenderDataDao {

	LenderDataEntity save(LenderData userData);

	List<LenderData> getLenders();
}
