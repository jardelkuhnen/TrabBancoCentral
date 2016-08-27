package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.univel.enun.TipoConta;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadConta extends PadraoBancario {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtCpf;
	private JTextField txtAgencia;
	private JTextField txtSenhaAcesso;
	private JTextField txtSenhaOpera;

	public CadConta() {
		super();
		setExtendedState(PadraoBancario.MAXIMIZED_BOTH);
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane().getLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0 };

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 197, 225, 0, 0 };
		gbl_panel.rowHeights = new int[] { 30, 14, 20, 14, 20, 14, 20, 14, 20, 23, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNome.anchor = GridBagConstraints.NORTH;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 1;
		gbc_lblNome.gridy = 1;
		panel.add(lblNome, gbc_lblNome);

		txtNome = new JTextField();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.anchor = GridBagConstraints.NORTH;
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtNome.gridwidth = 2;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 2;
		panel.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

		JLabel lblIdade = new JLabel("Idade");
		GridBagConstraints gbc_lblIdade = new GridBagConstraints();
		gbc_lblIdade.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIdade.anchor = GridBagConstraints.NORTH;
		gbc_lblIdade.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdade.gridx = 1;
		gbc_lblIdade.gridy = 3;
		panel.add(lblIdade, gbc_lblIdade);

		JLabel lblCpf = new JLabel("CPF");
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCpf.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpf.gridx = 2;
		gbc_lblCpf.gridy = 3;
		panel.add(lblCpf, gbc_lblCpf);

		try {
			txtIdade = new JFormattedTextField(new MaskFormatter("##"));
			GridBagConstraints gbc_txtIdade = new GridBagConstraints();
			gbc_txtIdade.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtIdade.anchor = GridBagConstraints.NORTH;
			gbc_txtIdade.insets = new Insets(0, 0, 5, 5);
			gbc_txtIdade.gridx = 1;
			gbc_txtIdade.gridy = 4;
			panel.add(txtIdade, gbc_txtIdade);
			txtIdade.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			GridBagConstraints gbc_txtCpf = new GridBagConstraints();
			gbc_txtCpf.anchor = GridBagConstraints.NORTH;
			gbc_txtCpf.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCpf.insets = new Insets(0, 0, 5, 5);
			gbc_txtCpf.gridx = 2;
			gbc_txtCpf.gridy = 4;
			panel.add(txtCpf, gbc_txtCpf);
			txtCpf.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JLabel lblAg = new JLabel("AG");
		GridBagConstraints gbc_lblAg = new GridBagConstraints();
		gbc_lblAg.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblAg.insets = new Insets(0, 0, 5, 5);
		gbc_lblAg.gridx = 1;
		gbc_lblAg.gridy = 5;
		panel.add(lblAg, gbc_lblAg);

		JLabel lblTipoConta = new JLabel("Tipo Conta");
		GridBagConstraints gbc_lblTipoConta = new GridBagConstraints();
		gbc_lblTipoConta.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTipoConta.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoConta.gridx = 2;
		gbc_lblTipoConta.gridy = 5;
		panel.add(lblTipoConta, gbc_lblTipoConta);

		txtAgencia = new JTextField();
		GridBagConstraints gbc_txtAgencia = new GridBagConstraints();
		gbc_txtAgencia.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAgencia.anchor = GridBagConstraints.NORTH;
		gbc_txtAgencia.insets = new Insets(0, 0, 5, 5);
		gbc_txtAgencia.gridx = 1;
		gbc_txtAgencia.gridy = 6;
		panel.add(txtAgencia, gbc_txtAgencia);
		txtAgencia.setColumns(10);

		JComboBox cmbTipoConta = new JComboBox(TipoConta.values());
		GridBagConstraints gbc_cmbTipoConta = new GridBagConstraints();
		gbc_cmbTipoConta.anchor = GridBagConstraints.NORTH;
		gbc_cmbTipoConta.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbTipoConta.insets = new Insets(0, 0, 5, 5);
		gbc_cmbTipoConta.gridx = 2;
		gbc_cmbTipoConta.gridy = 6;
		panel.add(cmbTipoConta, gbc_cmbTipoConta);

		JLabel lblSenhaAcesso = new JLabel("Senha Acesso");
		GridBagConstraints gbc_lblSenhaAcesso = new GridBagConstraints();
		gbc_lblSenhaAcesso.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSenhaAcesso.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenhaAcesso.gridx = 1;
		gbc_lblSenhaAcesso.gridy = 7;
		panel.add(lblSenhaAcesso, gbc_lblSenhaAcesso);

		JLabel lblNewLabel = new JLabel("Senha Opera��es");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 7;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		txtSenhaAcesso = new JTextField();
		GridBagConstraints gbc_txtSenhaAcesso = new GridBagConstraints();
		gbc_txtSenhaAcesso.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSenhaAcesso.anchor = GridBagConstraints.NORTH;
		gbc_txtSenhaAcesso.insets = new Insets(0, 0, 5, 5);
		gbc_txtSenhaAcesso.gridx = 1;
		gbc_txtSenhaAcesso.gridy = 8;
		panel.add(txtSenhaAcesso, gbc_txtSenhaAcesso);
		txtSenhaAcesso.setColumns(10);

		try {
			txtSenhaOpera = new JFormattedTextField(new MaskFormatter("######"));
			GridBagConstraints gbc_txtSenhaOpera = new GridBagConstraints();
			gbc_txtSenhaOpera.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtSenhaOpera.anchor = GridBagConstraints.NORTH;
			gbc_txtSenhaOpera.insets = new Insets(0, 0, 5, 5);
			gbc_txtSenhaOpera.gridx = 2;
			gbc_txtSenhaOpera.gridy = 8;
			panel.add(txtSenhaOpera, gbc_txtSenhaOpera);
			txtSenhaOpera.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JButton btnConfrime = new JButton("Confirme");
		btnConfrime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		GridBagConstraints gbc_btnConfrime = new GridBagConstraints();
		gbc_btnConfrime.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfrime.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnConfrime.gridx = 2;
		gbc_btnConfrime.gridy = 9;
		panel.add(btnConfrime, gbc_btnConfrime);

	}
}
