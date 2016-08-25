package br.univel.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.univel.dao.AgenciaDao;
import br.univel.model.Agencia;
import br.univel.model.ListaAgenciaModel;

public class ListaAgencia extends PadraoBancario {

	private JPanel contentPane;
	private JTable tblAgencia;
	private ListaAgenciaModel model;

	public ListaAgencia() {
		super();
		setTitle("Listagem de Agências");
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane()
				.getLayout();
		gridBagLayout.columnWidths = new int[] { 372, 73, 101 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0 };

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		tblAgencia = new JTable();
		scrollPane.setViewportView(tblAgencia);

		try {
			List<Agencia> agencias = new AgenciaDao().buscarAgencias();
			model = new ListaAgenciaModel(agencias);

			tblAgencia.setModel(model);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		JButton btnNewButton = new JButton("Editar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		getContentPane().add(btnNewButton, gbc_btnNewButton);

		JButton btnAdicionar = new JButton("Adicionar");
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnAdicionar.gridx = 2;
		gbc_btnAdicionar.gridy = 2;
		getContentPane().add(btnAdicionar, gbc_btnAdicionar);

		btnAdicionar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				final Integer rowSelected = tblAgencia.getSelectedRow();
				final Integer rowIndex = tblAgencia
						.convertRowIndexToModel(rowSelected);
				final Integer idPessoa = (Integer) tblAgencia.getModel()
						.getValueAt(rowIndex, -1);
				CadAgencia cadAgencia = new CadAgencia(idPessoa);
				cadAgencia.setVisible(true);

			}
		});

	}

}
