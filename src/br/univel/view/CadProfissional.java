package br.univel.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadProfissional extends PadraoBancario {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtSenhaOperacoes;
	private JTextField txtUsuario;
	private JTextField txtSenha;

	public CadProfissional(Integer idProfissional) {
		super();
		setResizable(false);
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane().getLayout();
		gridBagLayout.columnWidths = new int[] { 0, 503, 103 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0 };

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 64, 63, 123, 179, 0 };
		gbl_panel.rowHeights = new int[] { 20, 0, 0, 14, 20, 14, 20, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.NORTH;
		gbc_lblNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 1;
		gbc_lblNome.gridy = 1;
		panel.add(lblNome, gbc_lblNome);

		txtNome = new JTextField();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.anchor = GridBagConstraints.SOUTH;
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.insets = new Insets(0, 0, 5, 0);
		gbc_txtNome.gridwidth = 3;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 2;
		panel.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

		JLabel lblIdade = new JLabel("Idade");
		GridBagConstraints gbc_lblIdade = new GridBagConstraints();
		gbc_lblIdade.anchor = GridBagConstraints.NORTH;
		gbc_lblIdade.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIdade.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdade.gridx = 1;
		gbc_lblIdade.gridy = 3;
		panel.add(lblIdade, gbc_lblIdade);

		JLabel lblSenhaOperaes = new JLabel("Senha Opera\u00E7\u00F5es");
		GridBagConstraints gbc_lblSenhaOperaes = new GridBagConstraints();
		gbc_lblSenhaOperaes.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSenhaOperaes.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenhaOperaes.gridx = 2;
		gbc_lblSenhaOperaes.gridy = 3;
		panel.add(lblSenhaOperaes, gbc_lblSenhaOperaes);

		txtIdade = new JTextField();
		GridBagConstraints gbc_txtIdade = new GridBagConstraints();
		gbc_txtIdade.anchor = GridBagConstraints.NORTH;
		gbc_txtIdade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdade.insets = new Insets(0, 0, 5, 5);
		gbc_txtIdade.gridx = 1;
		gbc_txtIdade.gridy = 4;
		panel.add(txtIdade, gbc_txtIdade);
		txtIdade.setColumns(10);

		txtSenhaOperacoes = new JTextField();
		GridBagConstraints gbc_txtSenhaOperacoes = new GridBagConstraints();
		gbc_txtSenhaOperacoes.anchor = GridBagConstraints.NORTH;
		gbc_txtSenhaOperacoes.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSenhaOperacoes.insets = new Insets(0, 0, 5, 5);
		gbc_txtSenhaOperacoes.gridx = 2;
		gbc_txtSenhaOperacoes.gridy = 4;
		panel.add(txtSenhaOperacoes, gbc_txtSenhaOperacoes);
		txtSenhaOperacoes.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.NORTH;
		gbc_lblUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 5;
		panel.add(lblUsername, gbc_lblUsername);

		JLabel lblSenha = new JLabel("Senha Acesso");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 0);
		gbc_lblSenha.gridx = 3;
		gbc_lblSenha.gridy = 5;
		panel.add(lblSenha, gbc_lblSenha);

		txtUsuario = new JTextField();
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.anchor = GridBagConstraints.NORTH;
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.gridwidth = 2;
		gbc_txtUsuario.gridx = 1;
		gbc_txtUsuario.gridy = 6;
		panel.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);

		txtSenha = new JTextField();
		GridBagConstraints gbc_txtSenha = new GridBagConstraints();
		gbc_txtSenha.insets = new Insets(0, 0, 5, 0);
		gbc_txtSenha.anchor = GridBagConstraints.NORTH;
		gbc_txtSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSenha.gridx = 3;
		gbc_txtSenha.gridy = 6;
		panel.add(txtSenha, gbc_txtSenha);
		txtSenha.setColumns(10);
		
				JButton btnConfirmar = new JButton("Confirmar");
				btnConfirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

					}
				});
				GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
				gbc_btnConfirmar.insets = new Insets(0, 0, 0, 5);
				gbc_btnConfirmar.anchor = GridBagConstraints.SOUTHEAST;
				gbc_btnConfirmar.gridx = 1;
				gbc_btnConfirmar.gridy = 2;
				getContentPane().add(btnConfirmar, gbc_btnConfirmar);
		setTitle("Cadastro de Profissionais");

	}

}
