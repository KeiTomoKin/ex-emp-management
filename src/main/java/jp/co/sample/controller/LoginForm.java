package jp.co.sample.controller;

/**
 * ログイン時に使用するフォーム.
 * 
 * @author keita.tomooka
 *
 */
public class LoginForm {
	/** メールアドレス */
	public String mailAddress;
	/** パスワード */
	public String password;

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
