package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.service.AdministratorService;

/**
 * 管理者登録時に使用するフォーム.
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
	 * @return InsertAdministratorFormオブジェクト
	 */
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm () {
		InsertAdministratorForm insertAdministratorForm = new InsertAdministratorForm();
		return insertAdministratorForm;
	}
	
	/**
	 * administrator/insert.htmlにフォワードする.
	 * @return "administrator/insert"
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
}
