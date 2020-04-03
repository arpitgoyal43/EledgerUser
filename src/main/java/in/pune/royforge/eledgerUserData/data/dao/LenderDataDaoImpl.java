package in.pune.royforge.eledgerUserData.data.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.pune.royforge.eledgerUserData.data.entity.LenderDataEntity;
import in.pune.royforge.eledgerUserData.data.model.LenderData;
import in.pune.royforge.eledgerUserData.repo.EledgerUserRepository;

@Repository
public class LenderDataDaoImpl implements ILenderDataDao {

	@Autowired
	EledgerUserRepository eledgerUserRepository;

	@Override
	public LenderDataEntity save(LenderData lenderData) {
		LenderDataEntity lenderDataEntity = new LenderDataEntity();
		createUser(lenderData, lenderDataEntity);
		return eledgerUserRepository.save(lenderDataEntity);
	}

	private void createUser(LenderData lenderData, LenderDataEntity lenderDataEntity) {
		lenderDataEntity.setUserName(lenderData.getUserName());
		lenderDataEntity.setUserPassword(lenderData.getUserPassword());
		lenderDataEntity.setUserEmail(lenderData.getUserEmail());
		lenderDataEntity.setUserPhoneNo(lenderData.getUserPhoneNo());
		lenderDataEntity.setLenderId((lenderData.getLenderId()));
		lenderDataEntity.setUserShopName(lenderData.getUserShopName());
	}

	private void getUserData(LenderData lenderData, LenderDataEntity lenderDataEntity) {
		lenderData.setUserId(lenderDataEntity.getUserId());
		lenderData.setUserName(lenderDataEntity.getUserName());
		lenderData.setUserPassword(lenderDataEntity.getUserPassword());
		lenderData.setUserEmail(lenderDataEntity.getUserEmail());
		lenderData.setUserPhoneNo(lenderDataEntity.getUserPhoneNo());
		lenderData.setLenderId(lenderDataEntity.getLenderId());
		lenderData.setUserShopName(lenderDataEntity.getUserShopName());
	}

	public List<LenderData> getLenders() {
		List<LenderData> lenders = new ArrayList<>();
		Iterable<LenderDataEntity> lendersList = eledgerUserRepository.findAll();
		if (null != lendersList) {
			for (LenderDataEntity lenderDataEntity : lendersList) {
				LenderData lenderData = new LenderData();
				getUserData(lenderData, lenderDataEntity);
				lenders.add(lenderData);
			}
		}
		return lenders;
	}
}