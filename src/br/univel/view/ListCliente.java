package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.controller.ContaController;
import br.univel.dao.ContaDao;
import br.univel.model.Conta;
import br.univel.model.ListaAgenciaModel;
import br.univel.model.ListaClienteModel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JTable;

public class ListCliente extends PadraoBancario implements WindowListener {

	private JPanel contentPane;
	private JTable tblContas;
	private List<Conta> contas;
	private ListaClienteModel model;

	public ListCliente() {
		super();
		setTitle("Listagem de Clientes");
		setExtendedState(PadraoBancario.MAXIMIZED_BOTH);
		addWindowListener(this);
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane().getLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0 };

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

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
