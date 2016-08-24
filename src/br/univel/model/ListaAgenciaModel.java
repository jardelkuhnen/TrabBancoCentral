package br.univel.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ListaAgenciaModel extends AbstractTableModel {

	List<Agencia> lista = new ArrayList<>();

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {

		return null;
	}

	public void incluir(List<Agencia> agencia) {
		this.lista = agencia;
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int col) {

		switch (col) {
		case 0:
			return "Nome";
		case 1:
			return "Número";
		case 2:
			return "Cidade";
		default:
			return "Erro";
		}
	}

}
