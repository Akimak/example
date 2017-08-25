package pl.com.ak.service.dto;

import java.util.List;

public class ParamSqlServiceDTO {
	
	private String destDir;
	private List<ParamSqlCommandDTO> paramSqlCommDTOs;

	public List<ParamSqlCommandDTO> getParamSqlCommDTOs() {
		return paramSqlCommDTOs;
	}

	public void setParamSqlCommDTOs(final List<ParamSqlCommandDTO> paramSqlCommDTOs) {
		this.paramSqlCommDTOs = paramSqlCommDTOs;
	}

	public String getDestDir() {
		return destDir;
	}

	public void setDestDir(final String destDir) {
		this.destDir = destDir;
	}
}
