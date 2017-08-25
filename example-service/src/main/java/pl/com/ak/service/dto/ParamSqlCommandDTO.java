package pl.com.ak.service.dto;

public class ParamSqlCommandDTO {

	private String sql;
	private String fileName;
	
	public ParamSqlCommandDTO(final String sql, final String fileName) {
		this.sql = sql;
		this.fileName = fileName;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(final String sql) {
		this.sql = sql;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(final String fileName) {
		this.fileName = fileName;
	}
}
