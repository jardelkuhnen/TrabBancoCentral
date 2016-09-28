package br.univel.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ListaSaldoModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Movimentacao> movimentacao = new ArrayList<>();

	public ListaSaldoModel(final List<Movimentacao> movimentacao) {
		this.movimentacao = movimentacao;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return this.movimentacao.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		final Movimentacao movimentacao = this.movimentacao.get(rowIndex);

		switch (columnIndex) {
		case -1:
			return movimentacao.getId();
		case 0:
			return movimentacao.getOperacao();
		case 1:
			return movimentacao.getData().toGMTString();
		case 2:

			switch (movimentacao.getOperacao()) {
			case "saque":
				return "R$ -" + movimentacao.getValor();
			case "tranferência":
				return "R$ -" + movimentacao.getValor();
			default:
				return "R$ " + movimentacao.getValor();
			}

		case 10:
			return movimentacao.getId();
		default:
			return "Erro";
		}
	}

	public void incluir(List<Movimentacao> movimentacao) {
		this.movimentacao = movimentacao;
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int col) {

		switch (col) {
		case 0:
			return "Operação";
		case 1:
			return "Data";
		case 2:
			return "Valor";
		default:
			return "Erro";
		}
	}

}
