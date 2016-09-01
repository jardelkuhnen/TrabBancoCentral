package br.univel.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.univel.controller.ProfissionalController;
import br.univel.model.ListaProfissinoalModel;
import br.univel.model.Profissional;

public class ListaProfissionais extends PadraoBancario implements WindowListener {

	private JPanel contentPane;
	private JTable tblProfissionais;
	private List<Profissional> profissionais;
	private ListaProfissinoalModel model;

	public ListaProfissionais() {
		super();
		setTitle("Listagem de Profissionais");
		addWindowListener(this);
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane().getLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0 };
		setTitle("Listagem de Profissionais");

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		tblProfissionais = new JTable();
		scrollPane.setViewportView(tblProfissionais);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				final Integer rowSelected = tblProfissionais.getSelectedRow();

				if (rowSelected < 0) {
					JOptionPane.showMessageDialog(ListaProfissionais.this, "Selecione um profissional para editar!",
							"Atenção", JOptionPane.WARNING_MESSAGE);
				} else {
					final Integer rowIndex = tblProfissionais.convertRowIndexToModel(rowSelected);
					final Integer idProfissinal = (Integer) tblProfissionais.getModel().getValueAt(rowIndex, -1);
					new CadProfissional(idProfissinal).setVisible(true);
				}

			}
		});
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditar.gridx = 1;
		gbc_btnEditar.gridy = 2;
		getContentPane().add(btnEditar, gbc_btnEditar);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new CadProfissional(null).setVisible(true);

			}
		});
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.gridx = 2;
		gbc_btnAdicionar.gridy = 2;
		getContentPane().add(btnAdicionar, gbc_btnAdicionar);

	}

	private void preencheTela() {
		profissionais = new ProfissionalController().buscarProfissionais();
		model = new ListaProfissinoalModel(profissionais);
		tblProfissionais.setModel(model);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		preencheTela();
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

		preencheTela();
	}

}
