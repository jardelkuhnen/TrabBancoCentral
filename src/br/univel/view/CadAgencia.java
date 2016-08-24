package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadAgencia extends PadraoBancario {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private Integer idAgencia;

	public CadAgencia(Integer idAgencia) {
		super();
		this.idAgencia = idAgencia;
		setResizable(false);
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane().getLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0 };
		setLocationRelativeTo(null);
		setTitle("Cadastro de Agências");

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 85, 331, 180, 0 };
		gbl_panel.rowHeights = new int[] { 31, 14, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.anchor = GridBagConstraints.NORTH;
		gbc_lblNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNome.gridx = 1;
		gbc_lblNome.gridy = 1;
		panel.add(lblNome, gbc_lblNome);

		txtNome = new JTextField();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 2;
		panel.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel = new JLabel("N\u00FAmero");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		txtNumero = new JTextField();
		GridBagConstraints gbc_txtNumero = new GridBagConstraints();
		gbc_txtNumero.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumero.gridx = 1;
		gbc_txtNumero.gridy = 4;
		panel.add(txtNumero, gbc_txtNumero);
		txtNumero.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Cidade");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 5;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtCidade = new JTextField();
		GridBagConstraints gbc_txtCidade = new GridBagConstraints();
		gbc_txtCidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtCidade.anchor = GridBagConstraints.NORTH;
		gbc_txtCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCidade.gridx = 1;
		gbc_txtCidade.gridy = 6;
		panel.add(txtCidade, gbc_txtCidade);
		txtCidade.setColumns(10);

		JButton btnConfirma = new JButton("Confirme");
		GridBagConstraints gbc_btnConfirma = new GridBagConstraints();
		gbc_btnConfirma.anchor = GridBagConstraints.EAST;
		gbc_btnConfirma.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirma.gridx = 1;
		gbc_btnConfirma.gridy = 7;
		panel.add(btnConfirma, gbc_btnConfirma);

	}
}
