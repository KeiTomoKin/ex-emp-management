package jp.co.sample.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

/**
 * 従業員情報更新時に使用するフォーム
 * 
 * @author keita.tomooka
 *
 */
public class UpdateEmployeeForm {
	/** 従業員ID */
	private String id;
	/** 扶養家族 */
	@Range(min=0,message="数値を入力してください")
	private String dependentsCount;

	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDependentsCount() {
		return dependentsCount;
	}

	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}

}
