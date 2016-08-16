package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;

import br.univel.controller.UsuarioController;
import br.univel.enun.TipoUsuario;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login login = new Login();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"D:\\workspace\\BancoCentral\\Imagens\\Icone.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 254, 196);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 203, 0 };
		gbl_contentPane.rowHeights = new int[] { 53, 20, 20, 23, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Usu\u00E1rio");
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.anchor = GridBagConstraints.NORTH;
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsuario.gridx = 0;
		gbc_txtUsuario.gridy = 1;
		contentPane.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setToolTipText("Senha");
		txtSenha.setColumns(10);
		GridBagConstraints gbc_txtSenha = new GridBagConstraints();
		gbc_txtSenha.anchor = GridBagConstraints.NORTH;
		gbc_txtSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSenha.insets = new Insets(0, 0, 5, 0);
		gbc_txtSenha.gridx = 0;
		gbc_txtSenha.gridy = 2;
		contentPane.add(txtSenha, gbc_txtSenha);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				UsuarioController userControll = new UsuarioController();

				TipoUsuario tipoUser = userControll.acessoLogin(txtUsuario
						.getText().trim(), txtSenha.getText().trim());

				if (tipoUser == TipoUsuario.CLIENTE) {
					// abra tela cliente
					TelaCliente telaCli = new TelaCliente();
					telaCli.setVisible(true);
					telaCli.setExtendedState(JFrame.MAXIMIZED_BOTH);
					setVisible(false);

				} else if (tipoUser == TipoUsuario.BANCARIO) {

					TelaBancario telaBanc = new TelaBancario();
					telaBanc.setVisible(true);
					telaBanc.setExtendedState(JFrame.MAXIMIZED_BOTH);
					setVisible(false);

				} else {
					JOptionPane.showMessageDialog(null,
							"Usuário não localizado");
				}

			}
		});
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnLogin.gridx = 0;
		gbc_btnLogin.gridy = 3;
		contentPane.add(btnLogin, gbc_btnLogin);
	}
}
