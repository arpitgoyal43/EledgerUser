package in.pune.royforge.eledgerUserData.data.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.pune.royforge.eledgerUserData.data.entity.LenderDataEntity;
import in.pune.royforge.eledgerUserData.data.model.LenderData;
import in.pune.royforge.eledgerUserData.repo.EledgerUserRepository;

@Repository
public class LenderDataDaoImpl implements ILenderDataDao {

	@Autowired
	EledgerUserRepository eledgerUserRepository;

	/*
	 * save(lenderData) method to save the data to the database by either creating
	 * the lender or updating the lender.
	 */
	@Override
	public LenderDataEntity save(LenderData lenderData) {
		if (null != lenderData) {
			LenderDataEntity lenderDataEntity = new LenderDataEntity();
			LenderDataEntity lenderDataEntityObj;
			if (null == lenderData.getUserId()) {
				createLender(lenderData, lenderDataEntity);
				lenderDataEntityObj = eledgerUserRepository.save(lenderDataEntity);
			} else {
				updateLender(lenderData, lenderDataEntity);
				lenderDataEntityObj = eledgerUserRepository.save(lenderDataEntity);
			}
			return lenderDataEntityObj;

		} else {
			return new LenderDataEntity();
		}
	}

	private void createLender(LenderData lenderData, LenderDataEntity lenderDataEntity) {
		lenderDataEntity.setUserName(lenderData.getUserName());
		lenderDataEntity.setUserPassword(lenderData.getUserPassword());
		lenderDataEntity.setUserEmail(lenderData.getUserEmail());
		lenderDataEntity.setUserPhoneNo(lenderData.getUserPhoneNo());
		lenderDataEntity.setLenderId((lenderData.getLenderId()));
		lenderDataEntity.setUserShopName(lenderData.getUserShopName());
	}

	private void updateLender(LenderData lenderData, LenderDataEntity lenderDataEntity) {
		lenderDataEntity.setUserId(lenderData.getUserId());
		lenderDataEntity.setUserName(lenderData.getUserName());
		lenderDataEntity.setUserPassword(lenderData.getUserPassword());
		lenderDataEntity.setUserEmail(lenderData.getUserEmail());
		lenderDataEntity.setUserPhoneNo(lenderData.getUserPhoneNo());
		lenderDataEntity.setLenderId((lenderData.getLenderId()));
		lenderDataEntity.setUserShopName(lenderData.getUserShopName());
	}

	private void getLenderData(LenderData lenderData, LenderDataEntity lenderDataEntity) {
		lenderData.setUserId(lenderDataEntity.getUserId());
		lenderData.setUserName(lenderDataEntity.getUserName());
		lenderData.setUserPassword(lenderDataEntity.getUserPassword());
		lenderData.setUserEmail(lenderDataEntity.getUserEmail());
		lenderData.setUserPhoneNo(lenderDataEntity.getUserPhoneNo());
		lenderData.setLenderId(lenderDataEntity.getLenderId());
		lenderData.setUserShopName(lenderDataEntity.getUserShopName());
	}

	/*
	 * getLenders() method return complete list of lenders.
	 */
	public List<LenderData> getLenders() {
		List<LenderData> lenders = new ArrayList<>();
		Iterable<LenderDataEntity> lendersList = eledgerUserRepository.findAll();
		if (null != lendersList) {
			for (LenderDataEntity lenderDataEntity : lendersList) {
				LenderData lenderData = new LenderData();
				getLenderData(lenderData, lenderDataEntity);
				lenders.add(lenderData);
			}
		}
		return lenders;
	}

	/*
	 * getLender() method return lender data with specific userId.
	 */
	@Override
	public LenderData getLender(Long userId) {
		Optional<LenderDataEntity> existedLender = eledgerUserRepository.findById(userId);
		LenderData lenderData = null;
		if (existedLender.isPresent()) {
			lenderData = new LenderData();
			lenderData.setUserId(existedLender.get().getUserId());
			lenderData.setUserName(existedLender.get().getUserName());
			lenderData.setUserPassword(existedLender.get().getUserPassword());
			lenderData.setLenderId(existedLender.get().getLenderId());
			lenderData.setUserEmail(existedLender.get().getUserEmail());
			lenderData.setUserPhoneNo(existedLender.get().getUserPhoneNo());
			lenderData.setUserShopName(existedLender.get().getUserShopName());
		}
		return lenderData;
	}
}