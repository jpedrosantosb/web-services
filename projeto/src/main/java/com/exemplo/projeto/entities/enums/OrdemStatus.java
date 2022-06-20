package com.exemplo.projeto.entities.enums;

public enum OrdemStatus {

	AGUARDANDO_PAGAMENTO(1), PAGO(2), ENVIADO(3), ENTREGUE(4), CANCELADO(5);

	private int cod;

	private OrdemStatus(int cod) {
		this.cod = cod;
	}

	public int getCod() {
		return cod;
	}

	public static OrdemStatus valueOf(int cod) {
		for (OrdemStatus value : OrdemStatus.values()) {
			if (value.getCod() == cod) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de Status de Ordem inválido!");
	}
}
