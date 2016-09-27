package br.univel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.univel.controller.ContaController;
import br.univel.controller.UsuarioController;
import br.univel.enun.TipoUsuario;
import br.univel.general.MovimentacaoFacade;
import br.univel.model.Conta;
import br.univel.view.TelaBancario;
import br.univel.view.TelaCliente;

import javax.swing.JPasswordField;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JComboBox cbmAcesso;
	private JLabel lblBancoCentral;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login login = new Login();
					login.setVisible(true);
					login.setLocationRelativeTo(null);
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
		setResizable(false);
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("./Imagens/Icone.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 254, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 203, 0 };
		gbl_contentPane.rowHeights = new int[] { 53, 20, 20, 23, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		lblBancoCentral = new JLabel("Banco Central");
		lblBancoCentral.setForeground(new Color(0, 0, 128));
		lblBancoCentral.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblBancoCentral = new GridBagConstraints();
		gbc_lblBancoCentral.insets = new Insets(0, 0, 5, 0);
		gbc_lblBancoCentral.gridx = 0;
		gbc_lblBancoCentral.gridy = 0;
		contentPane.add(lblBancoCentral, gbc_lblBancoCentral);

		txtUsuario = new JTextField("jardel");
		txtUsuario.setToolTipText("Usu\u00E1rio");
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.anchor = GridBagConstraints.NORTH;
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsuario.gridx = 0;
		gbc_txtUsuario.gridy = 1;
		contentPane.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					acessarSistema();
				}
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				acessarSistema();
			}

		});

		txtSenha = new JPasswordField("jardel");
		GridBagConstraints gbc_txtSenha = new GridBagConstraints();
		gbc_txtSenha.insets = new Insets(0, 0, 5, 0);
		gbc_txtSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSenha.gridx = 0;
		gbc_txtSenha.gridy = 2;
		contentPane.add(txtSenha, gbc_txtSenha);

		cbmAcesso = new JComboBox(TipoUsuario.values());
		GridBagConstraints gbc_cbmAcesso = new GridBagConstraints();
		gbc_cbmAcesso.insets = new Insets(0, 0, 5, 0);
		gbc_cbmAcesso.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbmAcesso.gridx = 0;
		gbc_cbmAcesso.gridy = 3;
		contentPane.add(cbmAcesso, gbc_cbmAcesso);
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnLogin.gridx = 0;
		gbc_btnLogin.gridy = 4;
		contentPane.add(btnLogin, gbc_btnLogin);
	}

	protected void limparCampos() {

		txtUsuario.setText("");
		txtSenha.setText("");
		cbmAcesso.setSelectedIndex(0);

	}

	protected void acessarSistema() {

		UsuarioController userControll = new UsuarioController();
		String usuario = txtUsuario.getText().trim();
		String senha = txtSenha.getText().trim();
		TipoUsuario tipoUsuario = (TipoUsuario) cbmAcesso.getSelectedItem();

		boolean acessa = userControll.acessoLogin(usuario, senha, tipoUsuario);

		if (acessa && tipoUsuario == TipoUsuario.CLIENTE) {

			Conta conta = new ContaController().get(usuario, senha);

			TelaCliente telaCli = new TelaCliente(conta);
			telaCli.setVisible(true);

			setVisible(false);

		} else if (acessa && tipoUsuario == TipoUsuario.BANCARIO) {

			TelaBancario telaBanc = new TelaBancario();
			telaBanc.setVisible(true);
			setVisible(false);

		} else {
			JOptionPane.showMessageDialog(Login.this,
					"Usuário ou senha incorretos!!!");
			limparCampos();
		}
	}
}
