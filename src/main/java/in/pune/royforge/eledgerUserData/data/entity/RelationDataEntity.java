package in.pune.royforge.eledgerUserData.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RelationDataEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String borrowId;

	@Column
	private String lenderId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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