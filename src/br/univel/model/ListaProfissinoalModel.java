package br.univel.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ListaProfissinoalModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Profissional> profissionais = new ArrayList<>();

	public ListaProfissinoalModel(List<Profissional> profissionais) {
		this.profissionais = profissionais;

	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return this.profissionais.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		final Profissional profissional = this.profissionais.get(rowIndex);

		switch (columnIndex) {
		case -1:
			return profissional.getId();
		case 0:
			return profissional.getNome();
		case 1:
			return profissional.getUserName();

		default:
			return "Erro";
		}

	}

	@Override
	public String getColumnName(int column) {

		switch (column) {
		case 0:
			return "Nome";
		case 1:
			return "Usuario";

		default:
			return "Erro";
		}

	}

	public void incluir(List<Profissional> profissionais) {
		this.profissionais = profissionais;
		fireTableDataChanged();
	}

}
