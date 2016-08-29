package br.univel.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.univel.controller.ContaController;
import br.univel.model.Conta;
import br.univel.model.ListaClienteModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaCliente extends PadraoBancario implements WindowListener {

	private JPanel contentPane;
	private JTable tblContas;
	private List<Conta> contas;
	private ListaClienteModel model;

	public ListaCliente() {
		super();
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane().getLayout();
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0 };
		setTitle("Listagem de Clientes");
		addWindowListener(this);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		getContentPane().add(scrollPane, gbc_scrollPane);

		tblContas = new JTable();
		scrollPane.setViewportView(tblContas);

	}

	private void preencherTela() {

		try {
			contas = new ContaController().buscarContas();
			model = new ListaClienteModel(contas);
			tblContas.setModel(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		preencherTela();
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowOpened(WindowEvent e) {
		preencherTela();

	}

}
