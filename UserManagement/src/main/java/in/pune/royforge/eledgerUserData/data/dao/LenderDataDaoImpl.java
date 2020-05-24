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
			if (null == lenderData.getId()) {
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

	/*
	 * Set lenderData to lenderEntity object for Create POST API
	 */
	private void createLender(LenderData lenderData, LenderDataEntity lenderDataEntity) {
		lenderDataEntity.setName(lenderData.getName());
		lenderDataEntity.setPassword(lenderData.getPassword());
		lenderDataEntity.setEmail(lenderData.getEmail());
		lenderDataEntity.setPhone(lenderData.getPhone());
		lenderDataEntity.setLenderId((lenderData.getLenderId()));
		lenderDataEntity.setShopName(lenderData.getShopName());
	}

	/*
	 * Set lenderData to lenderEntity object for Update POST API
	 */
	private void updateLender(LenderData lenderData, LenderDataEntity lenderDataEntity) {
		lenderDataEntity.setId(lenderData.getId());
		lenderDataEntity.setName(lenderData.getName());
		lenderDataEntity.setPassword(lenderData.getPassword());
		lenderDataEntity.setEmail(lenderData.getEmail());
		lenderDataEntity.setPhone(lenderData.getPhone());
		lenderDataEntity.setLenderId((lenderData.getLenderId()));
		lenderDataEntity.setShopName(lenderData.getShopName());
	}

	private void getLenderData(LenderData lenderData, LenderDataEntity lenderDataEntity) {
		lenderData.setId(lenderDataEntity.getId());
		lenderData.setName(lenderDataEntity.getName());
		lenderData.setPassword(lenderDataEntity.getPassword());
		lenderData.setEmail(lenderDataEntity.getEmail());
		lenderData.setPhone(lenderDataEntity.getPhone());
		lenderData.setLenderId(lenderDataEntity.getLenderId());
		lenderData.setShopName(lenderDataEntity.getShopName());
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
			lenderData.setId(existedLender.get().getId());
			lenderData.setName(existedLender.get().getName());
			lenderData.setPassword(existedLender.get().getPassword());
			lenderData.setLenderId(existedLender.get().getLenderId());
			lenderData.setEmail(existedLender.get().getEmail());
			lenderData.setPhone(existedLender.get().getPhone());
			lenderData.setShopName(existedLender.get().getShopName());
		}
		return lenderData;
	}

	/*
	 * return true if new lender's phone number or email not present in database,
	 * otherwise false
	 */
	@Override
	public String checkForSignUp(LenderData lenderData) {
		if (null != lenderData) {
			LenderDataEntity lender = null;
			boolean isLenderPhoneAlreadyPresent = false;
			boolean isLenderMailAlreadyPresent = false;


			if (lenderData.getEmail() != null) {
				lender = eledgerUserRepository.findByEmail(lenderData.getEmail());
				if (lender != null) {
					isLenderMailAlreadyPresent = true;
					return "EMail Already Present";
				}
			}
			if (lenderData.getPhone() != null) {
				lender = eledgerUserRepository.findByPhone(lenderData.getPhone());
				if (lender != null) {
					isLenderPhoneAlreadyPresent = true;
					return "Phone Already Present";
				}
			}
			if (!isLenderPhoneAlreadyPresent && !isLenderMailAlreadyPresent) {
				save(lenderData);
			}
			return "Success";
		} else {
			return "Already Present";
		}
	}
}