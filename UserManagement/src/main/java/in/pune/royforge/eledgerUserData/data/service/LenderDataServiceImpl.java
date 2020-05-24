package in.pune.royforge.eledgerUserData.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pune.royforge.eledgerUserData.data.dao.ILenderDataDao;
import in.pune.royforge.eledgerUserData.data.entity.LenderDataEntity;
import in.pune.royforge.eledgerUserData.data.model.LenderData;

@Service
public class LenderDataServiceImpl implements ILenderDataService {

	@Autowired
	private ILenderDataDao userEntityDao;

	@Override
	public LenderDataEntity save(LenderData userData) {
		return userEntityDao.save(userData);
	}

	@Override
	public List<LenderData> getLenders() {
		return userEntityDao.getLenders();
	}

	@Override
	public LenderData getLender(Long userId) {
		return userEntityDao.getLender(userId);
	}

	@Override
	public String checkForSignUp(LenderData lenderData) {
		return userEntityDao.checkForSignUp(lenderData);
	}
}
