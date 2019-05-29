package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

/**
 * 従業員関連機能の処理の制御を行うコントローラ
 * 
 * @author keita.tomooka
 *
 */
/**
 * @author keita.tomooka
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	/**
	 * 従業員一覧を出力する.
	 * 
	 * @param model リクエストスコープ
	 * @return 従業員一覧画面
	 */
	@RequestMapping("showList")
	public String showList(Model model) {
		List<Employee> employeeList = employeeService.showList();
		model.addAttribute("employeeList", employeeList);
		return "employee/list";
	}

	/**
	 * UpdateEmployeeFormをインスタンス化する.
	 * 
	 * @return UpdateEmployeeFormオブジェクト
	 */
	@ModelAttribute
	public UpdateEmployeeForm setUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}

	/**
	 * 従業員詳細画面を出力する
	 * 
	 * @param id    従業員ID
	 * @param model リクエストスコープ
	 * @return 従業員詳細画面
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Employee employee = employeeService.showDetail(Integer.valueOf(id));
		model.addAttribute("employee", employee);
		return "employee/detail";
	}

	/**
	 * 従業員情報を更新する.
	 * 
	 * @param form
	 * @param model
	 * @return 従業員一覧画面
	 */
	@RequestMapping("/update")
	public String update(UpdateEmployeeForm form) {
		Employee employee = employeeService.showDetail(Integer.valueOf(form.getId()));
		employee.setDependentsCount(Integer.valueOf(form.getDependentsCount()));
		employeeService.update(employee);
		return "redirect:/employee/showList";
	}

}
