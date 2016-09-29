package br.univel.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ListaBalancoModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<Balanco> balancos = new ArrayList<Balanco>();

	public ListaBalancoModel(List<Balanco> balancos) {
		this.balancos = balancos;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return balancos.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		final Balanco balanco = this.balancos.get(rowIndex);

		switch (columnIndex) {
		case -1:
			return balanco.getId();
		case 0:
			return balanco.getAgenca();
		case 1:
			return balanco.getConta();
		case 2:
			return balanco.getOperacao();
		case 3:

			switch (balanco.getOperacao()) {
			case "saque":
				return "R$ -" + balanco.getValor();
			case "tranferência":
				return "R$ -" + balanco.getValor();
			default:
				return "R$ " + balanco.getValor();
			}

		default:
			return "Erro";
		}

	}

	public void incluir(List<Balanco> balanco) {
		this.balancos = balanco;
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int column) {

		switch (column) {
		case 0:
			return "Agência";
		case 1:
			return "Conta";
		case 2:
			return "Operação";
		case 3:
			return "Valor";

		default:
			return "Erro";
		}

	}

}
