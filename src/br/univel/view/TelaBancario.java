package br.univel.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TelaBancario extends PadraoBancario {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TelaBancario() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Área do Bancario");
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane().getLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0 };

		JPanel corpo = new JPanel();
		GridBagConstraints gbc_corpo = new GridBagConstraints();
		gbc_corpo.insets = new Insets(0, 0, 0, 5);
		gbc_corpo.gridheight = 2;
		gbc_corpo.gridwidth = 3;
		gbc_corpo.fill = GridBagConstraints.BOTH;
		gbc_corpo.gridx = 0;
		gbc_corpo.gridy = 1;
		getContentPane().add(corpo, gbc_corpo);
		GridBagLayout gbl_corpo = new GridBagLayout();
		gbl_corpo.columnWidths = new int[] { 1, 0, 0 };
		gbl_corpo.rowHeights = new int[] { 1, 0, 0, 0 };
		gbl_corpo.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_corpo.rowWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		corpo.setLayout(gbl_corpo);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.gridheight = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		corpo.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 279, 243, 0 };
		gbl_panel.rowHeights = new int[] { 55, 64, 68, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JButton btnInfo = new JButton("1 - Informa\u00E7\u00F5es de Contas");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				PopupConta popUp = new PopupConta();
				popUp.setLocationRelativeTo(TelaBancario.this);
				popUp.setVisible(true);

			}
		});
		GridBagConstraints gbc_btnInfo = new GridBagConstraints();
		gbc_btnInfo.fill = GridBagConstraints.BOTH;
		gbc_btnInfo.insets = new Insets(0, 0, 5, 5);
		gbc_btnInfo.gridx = 0;
		gbc_btnInfo.gridy = 0;
		panel.add(btnInfo, gbc_btnInfo);

		JButton btnProfi = new JButton("4 - Profissionais");
		btnProfi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ListaProfissionais listProfissionais = new ListaProfissionais();
				listProfissionais.setVisible(true);

			}
		});
		GridBagConstraints gbc_btnProfi = new GridBagConstraints();
		gbc_btnProfi.fill = GridBagConstraints.BOTH;
		gbc_btnProfi.insets = new Insets(0, 0, 5, 0);
		gbc_btnProfi.gridx = 1;
		gbc_btnProfi.gridy = 0;
		panel.add(btnProfi, gbc_btnProfi);

		JButton btnNovaConta = new JButton("2 - Nova Conta");
		btnNovaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new CadConta().setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNovaConta = new GridBagConstraints();
		gbc_btnNovaConta.fill = GridBagConstraints.BOTH;
		gbc_btnNovaConta.insets = new Insets(0, 0, 5, 5);
		gbc_btnNovaConta.gridx = 0;
		gbc_btnNovaConta.gridy = 1;
		panel.add(btnNovaConta, gbc_btnNovaConta);

		JButton btnBalanco = new JButton("5 - Balan\u00E7o");
		GridBagConstraints gbc_btnBalanco = new GridBagConstraints();
		gbc_btnBalanco.fill = GridBagConstraints.BOTH;
		gbc_btnBalanco.insets = new Insets(0, 0, 5, 0);
		gbc_btnBalanco.gridx = 1;
		gbc_btnBalanco.gridy = 1;
		panel.add(btnBalanco, gbc_btnBalanco);

		JButton btnClientes = new JButton("3 - Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ListaCliente listaClientes = new ListaCliente();
				listaClientes.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnClientes = new GridBagConstraints();
		gbc_btnClientes.fill = GridBagConstraints.BOTH;
		gbc_btnClientes.insets = new Insets(0, 0, 0, 5);
		gbc_btnClientes.gridx = 0;
		gbc_btnClientes.gridy = 2;
		panel.add(btnClientes, gbc_btnClientes);

		JButton btnAgencias = new JButton("6 - Ag\u00EAncias");
		btnAgencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ListaAgencia listaAgen = new ListaAgencia();
				listaAgen.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnAgencias = new GridBagConstraints();
		gbc_btnAgencias.fill = GridBagConstraints.BOTH;
		gbc_btnAgencias.gridx = 1;
		gbc_btnAgencias.gridy = 2;
		panel.add(btnAgencias, gbc_btnAgencias);

	}
}
