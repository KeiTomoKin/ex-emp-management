package jp.co.sample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

/**
 * administeratorsテーブルを操作するリポジトリ.
 * 
 * @author keita.tomooka
 *
 */
@Repository
public class AdministratorRepository {
	private RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs, i) -> {
		Administrator administrator = new Administrator();
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAddress("mail_address");
		administrator.setPassword(rs.getString("password"));
		return administrator;
	};
	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * 管理者情報を挿入する.
	 * 
	 * @param administrator 管理者情報
	 */
	public void insert(Administrator administrator) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
//		if (administrator.getId() == null) {
		String insertSql = "INSERT INTO administrators(name,mail_address,password) VALUES(:name,:mailAddress,:password)";
		template.update(insertSql, param);
//		} else {
//			String insertSql = "UPDATE administrators SET id=:id,name=:name,mail_address=:mailAddress,password=:password)";
//			template.update(insertSql, param);
//		}
	}

	/**
	 * メールアドレスをパスワードから管理者情報を取得する. 
	 * もし、存在しない場合はnullを返す。
	 * 
	 * @param mailAddress メールアドレス
	 * @param password    パスワード
	 * @return 管理者情報（あるいはnull）
	 */
	public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
		String sql = "SELECT id,name,mail_address,password FROM administrators WHERE mail_Address=:mailAddress AND password=:password";
		SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("password",
				password);
		Administrator administrator=null;
		try {
			administrator = template.queryForObject(sql, param, ADMINISTRATOR_ROW_MAPPER);			
		} catch (EmptyResultDataAccessException e) {
		 administrator=null;
		}
		return administrator;
		
	}
}
