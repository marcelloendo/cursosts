package com.macelloendo.cursosts.domain.enums;

public enum ClientType {

	PESSOA_FISICA(1, "Pessoa Física"), PESSOA_JURIDICA(2, "Pessoa Jurídica");

	private int cod;
	private String description;

	private ClientType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static ClientType toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (ClientType x : ClientType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("ID Inválido: " + cod);
	}
}
