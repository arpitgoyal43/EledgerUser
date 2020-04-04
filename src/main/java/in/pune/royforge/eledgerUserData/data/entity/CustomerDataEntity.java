package in.pune.royforge.eledgerUserData.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerDataEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;

	@Column
	private String customerName;

	@Column
	private Long customerPhoneNo;

	@Column
	private String borrowId;

	@Column
	private String lenderId;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getCustomerPhoneNo() {
		return customerPhoneNo;
	}

	public void setCustomerPhoneNo(Long customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}

	public String getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(String borrowId) {
		this.borrowId = borrowId;
	}

	public String getLenderId() {
		return lenderId;
	}

	public void setLenderId(String lenderId) {
		this.lenderId = lenderId;
	}

}
