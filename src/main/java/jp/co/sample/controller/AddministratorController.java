package jp.co.sample.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.service.AdministratorService;

/**
 * 管理者登録時に使用するフォーム.
 * 
 * @author keita.tomooka
 *
 */
@Controller
@RequestMapping("/")
public class AddministratorController {

	@Autowired
	private AdministratorService administratorService;

	/**
	 * InsertAdministratorFormをインスタンス化する.
	 * 
	 * @return InsertAdministratorFormオブジェクト
	 */
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		InsertAdministratorForm insertAdministratorForm = new InsertAdministratorForm();
		return insertAdministratorForm;
	}

	/**
	 * administrator/insert.htmlにフォワードする.
	 * 
	 * @return "administrator/insert"
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}

	/**
	 * 管理者情報を登録する.
	 * 
	 * @param form 管理者登録情報
	 * @return /にリダイレクト
	 */
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		Administrator administrator = new Administrator();
		BeanUtils.copyProperties(form, administrator);
		administratorService.insert(administrator);
		return "redirect:/";
	}
	
	/**
	 * LoginFormのインスタンス化.
	 * @return ログイン情報
	 */
	@ModelAttribute
	public LoginForm setUpForm() {
		LoginForm loginForm = new LoginForm();
		return loginForm;
	}
	
	/**
	 * administrator/login.htmlにフォワードする.
	 * @return administrator/login
	 */
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}
}
