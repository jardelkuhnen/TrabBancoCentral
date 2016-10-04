package br.univel.model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.interfaces.Coluna;

public class ListaAgenciaModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Agencia> agencias = new ArrayList<>();

	public ListaAgenciaModel(final List<Agencia> agencias) {
		this.agencias = agencias;
	}

	@Override
	public int getColumnCount() {

		Object objeto = agencias.get(0);
		Class<?> classe = objeto.getClass();

		int colunas = 0;
		for (Method metodo : classe.getDeclaredMethods()) {
			if (metodo.isAnnotationPresent(Coluna.class)) {
				colunas++;
			}
		}

		return colunas;
	}

	@Override
	public int getRowCount() {
		return this.agencias.size();
	}

	@Override
	public Object getValueAt(int row, int column) {

		Object objeto = agencias.get(0);
		Class<?> classe = objeto.getClass();

		try {

			for (Method metodo : classe.getDeclaredMethods()) {
				if (metodo.isAnnotationPresent(Coluna.class)) {
					Coluna anotacao = metodo.getAnnotation(Coluna.class);

					if (anotacao.posicao() == column) {
						return metodo.invoke(objeto);
					}
				}
			}
			return "";
		} catch (Exception e) {
			return "Erro";
		}

	}

	public void incluir(List<Agencia> agencia) {
		this.agencias = agencia;
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int col) {

		Object objeto = agencias.get(0);
		Class<?> classe = objeto.getClass();

		for (Method metodo : classe.getDeclaredMethods()) {

			if (metodo.isAnnotationPresent(Coluna.class)) {

				Coluna anotacao = metodo.getAnnotation(Coluna.class);
				if (anotacao.posicao() == col) {
					return anotacao.nome();
				}
			}
		}
		return "";

	}
}
