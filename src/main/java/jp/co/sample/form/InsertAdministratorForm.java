package jp.co.sample.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 管理者登録時に使用するフォーム.
 * 
 * @author keita.tomooka
 *
 */
public class InsertAdministratorForm {
	/** 名前 */
	@NotBlank(message = "名前は必須です")
	private String name;
	/** メールアドレス */
	@Email(message = "Eメールの形式が不正です")
	@Size(min = 1, max = 127, message = "メールアドレスは1文字以上127文字以内で記載してください")

	private String mailAddress;
	/** パスワード */
//	@Pattern(regexp = "[1-9][0-9]+", message = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!-/:-@[-`{-~])[!-~]{8,48}$")
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!-~])[!-~]{8,48}$",message="パスワードは大小英数字記号を使った８文字以上４８文字以内である必要があります")
//	@Size(min = 1, max = 127, message = "パスワードは1文字以上127文字以内で記載してください")
	private String password;

	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
