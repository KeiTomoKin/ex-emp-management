package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

/**
 * 管理者関連機能の処理を制御を行うコントローラ.
 * 
 * @author keita.tomooka
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
	@Autowired
	private HttpSession session;

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
	 * 登録画面に遷移する.
	 * 
	 * @return 登録画面
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}

	/**
	 * 管理者情報を登録する.
	 * 
	 * @param form 管理者登録情報
	 * @return ログイン画面
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
	 * 
	 * @return ログイン情報
	 */
	@ModelAttribute
	public LoginForm setUpForm() {
		LoginForm loginForm = new LoginForm();
		return loginForm;
	}

	/**
	 * ログイン画面に遷移する.
	 * 
	 * @return administrator/login
	 */
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}

	/**
	 * 管理者の入力情報を元にログインする.
	 * ログインに失敗した場合はエラーメッセージを表示する
	 * 
	 * @param form  管理者の入力情報
	 * @param model リクエストスコープ
	 * @return 従業員一覧画面（あるいはログイン画面）
	 */
	@RequestMapping("/login")
	public String login(LoginForm form, Model model) {
		Administrator administrator = administratorService.login(form.getMailAddress(), form.getPassword());
		if (administrator == null) {
			model.addAttribute("message", "メールアドレスまたはパスワードが不正です。");
			return "administrator/login";
		} else {
			session.setAttribute("administrationName", administrator.getName());
			return "forward:/employee/showList";
		}
	}
}
