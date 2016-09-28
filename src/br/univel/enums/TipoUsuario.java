package br.univel.enums;

public enum TipoUsuario {

	CLIENTE(0),

	BANCARIO(1);
	
	

	private Integer ordinal;

	private TipoUsuario(Integer ordinal) {
		this.ordinal = ordinal;
	}

	public Integer getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
	}

}
