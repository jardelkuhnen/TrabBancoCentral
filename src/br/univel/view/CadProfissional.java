package br.univel.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.univel.controller.ProfissionalController;
import br.univel.enun.TipoUsuario;
import br.univel.model.Profissional;

public class CadProfissional extends PadraoBancario {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtSenhaOperacoes;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private JComboBox cmbTipoProfissional;

	public CadProfissional(Integer idProfissional) {
		super();
		setResizable(false);
		setTitle("Cadastro de Profissionais");
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane().getLayout();
		gridBagLayout.columnWidths = new int[] { 36, 530, 0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0 };

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 64, 63, 123, 207, 0 };
		gbl_panel.rowHeights = new int[] { 20, 0, 0, 14, 20, 14, 20, 38, 0 };
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

		JLabel lblSenha = new JLabel("Senha Acesso");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 0);
		gbc_lblSenha.gridx = 3;
		gbc_lblSenha.gridy = 3;
		panel.add(lblSenha, gbc_lblSenha);

		try {
			txtIdade = new JFormattedTextField(new MaskFormatter("##"));
			GridBagConstraints gbc_txtIdade = new GridBagConstraints();
			gbc_txtIdade.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtIdade.insets = new Insets(0, 0, 5, 5);
			gbc_txtIdade.gridx = 1;
			gbc_txtIdade.gridy = 4;
			panel.add(txtIdade, gbc_txtIdade);
			txtIdade.setColumns(10);
		} catch (ParseException e2) {
			e2.printStackTrace();
		}

		try {
			txtSenhaOperacoes = new JFormattedTextField(new MaskFormatter("########"));
			GridBagConstraints gbc_txtSenhaOperacoes = new GridBagConstraints();
			gbc_txtSenhaOperacoes.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtSenhaOperacoes.insets = new Insets(0, 0, 5, 5);
			gbc_txtSenhaOperacoes.gridx = 2;
			gbc_txtSenhaOperacoes.gridy = 4;
			panel.add(txtSenhaOperacoes, gbc_txtSenhaOperacoes);
			txtSenhaOperacoes.setColumns(10);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		txtSenha = new JTextField();
		GridBagConstraints gbc_txtSenha = new GridBagConstraints();
		gbc_txtSenha.insets = new Insets(0, 0, 5, 0);
		gbc_txtSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSenha.gridx = 3;
		gbc_txtSenha.gridy = 4;
		panel.add(txtSenha, gbc_txtSenha);
		txtSenha.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.NORTH;
		gbc_lblUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 5;
		panel.add(lblUsername, gbc_lblUsername);

		JLabel lblTipoProfissional = new JLabel("Tipo Profissional");
		GridBagConstraints gbc_lblTipoProfissional = new GridBagConstraints();
		gbc_lblTipoProfissional.anchor = GridBagConstraints.WEST;
		gbc_lblTipoProfissional.insets = new Insets(0, 0, 5, 0);
		gbc_lblTipoProfissional.gridx = 3;
		gbc_lblTipoProfissional.gridy = 5;
		panel.add(lblTipoProfissional, gbc_lblTipoProfissional);

		txtUsuario = new JTextField();
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.gridwidth = 2;
		gbc_txtUsuario.gridx = 1;
		gbc_txtUsuario.gridy = 6;
		panel.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);

		cmbTipoProfissional = new JComboBox(TipoUsuario.values());
		GridBagConstraints gbc_cmbTipoProfissional = new GridBagConstraints();
		gbc_cmbTipoProfissional.insets = new Insets(0, 0, 5, 0);
		gbc_cmbTipoProfissional.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbTipoProfissional.gridx = 3;
		gbc_cmbTipoProfissional.gridy = 6;
		panel.add(cmbTipoProfissional, gbc_cmbTipoProfissional);

		JButton btnConfirmar = new JButton("Confirmar");
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.anchor = GridBagConstraints.EAST;
		gbc_btnConfirmar.gridx = 3;
		gbc_btnConfirmar.gridy = 7;
		panel.add(btnConfirmar, gbc_btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtNome.getText().equals("") || txtIdade.getText().equals("") || txtSenha.getText().equals("")
						|| txtSenhaOperacoes.getText().equals("") || txtUsuario.getText().equals("")) {

					JOptionPane.showMessageDialog(CadProfissional.this, "Preencha corretamente todos os campos!",
							"Atenção", JOptionPane.WARNING_MESSAGE, null);
					txtNome.requestFocus();
				} else {
					
					Profissional profisisonal = new Profissional();
					profisisonal.setIdade(Integer.parseInt(txtIdade.getText()));
					profisisonal.setNome(txtNome.getText().trim());
					profisisonal.setSenhaAcesso(txtSenha.getText());
					profisisonal.setSenhaOperacoes(txtSenhaOperacoes.getText());
					profisisonal.setUserName(txtUsuario.getText());
					profisisonal.setTipoProfissional((TipoUsuario) cmbTipoProfissional.getSelectedItem());

					new ProfissionalController().add(profisisonal);
					// limparCampos();
				}

			}
		});

	}

	protected void limparCampos() {

		txtIdade.setText("");
		txtNome.setText("");
		txtSenha.setText("");
		txtSenhaOperacoes.setText("");
		txtUsuario.setText("");
		cmbTipoProfissional.setSelectedItem(0);
	}

}
