package in.pune.royforge.eledgerUserData.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pune.royforge.eledgerUserData.data.dao.ILenderDataDao;
import in.pune.royforge.eledgerUserData.data.entity.LenderDataEntity;
import in.pune.royforge.eledgerUserData.data.model.LenderData;
import in.pune.royforge.eledgerUserData.exceptionhandler.RecordNotFoundException;

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
	public LenderData getLender(Long userId) throws RecordNotFoundException {
		LenderData lenderData = userEntityDao.getLender(userId);
		if (null == lenderData) {
			throw new RecordNotFoundException("User Not Found in Record");
		}
		return lenderData;
	}

}
