package br.univel.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import br.univel.controller.ContaController;
import br.univel.enums.Operacao;
import br.univel.general.GetHorarioLocal;
import br.univel.model.Conta;
import br.univel.model.FormatoData;
import br.univel.model.Movimentacao;

import java.awt.Component;

public class SenhaConfirm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StringBuilder senhaInformada;
	private JPasswordField txtSenha;
	private SenhaConfirm senhaConfirm;

	public SenhaConfirm(Conta conta, BigDecimal valor, Conta contaTransferir,
			Operacao operacao, String codBarras) {
		setSize(525, 150);
		setTitle("Senha");
		senhaConfirm = this;
		senhaInformada = new StringBuilder();
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("./Imagens/Icone.png"));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 24, 139, 39, 39, 39, 39, 39, 0 };
		gbl_panel.rowHeights = new int[] { 32, 34, 31, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel(
				"Digite sua senha utilizando o teclado virtual");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		JButton btnZero = new JButton("0");
		btnZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				senhaInformada.append("0");
				atualizaTextField(senhaInformada);

			}
		});

		txtSenha = new JPasswordField();
		GridBagConstraints gbc_txtSenha = new GridBagConstraints();
		gbc_txtSenha.insets = new Insets(0, 0, 5, 5);
		gbc_txtSenha.fill = GridBagConstraints.BOTH;
		gbc_txtSenha.gridx = 1;
		gbc_txtSenha.gridy = 1;
		panel.add(txtSenha, gbc_txtSenha);
		GridBagConstraints gbc_btnZero = new GridBagConstraints();
		gbc_btnZero.anchor = GridBagConstraints.WEST;
		gbc_btnZero.insets = new Insets(0, 0, 5, 5);
		gbc_btnZero.gridx = 2;
		gbc_btnZero.gridy = 1;
		panel.add(btnZero, gbc_btnZero);

		JButton btnUm = new JButton("1");
		btnUm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				senhaInformada.append("1");
				atualizaTextField(senhaInformada);
			}
		});
		GridBagConstraints gbc_btnUm = new GridBagConstraints();
		gbc_btnUm.anchor = GridBagConstraints.WEST;
		gbc_btnUm.insets = new Insets(0, 0, 5, 5);
		gbc_btnUm.gridx = 3;
		gbc_btnUm.gridy = 1;
		panel.add(btnUm, gbc_btnUm);

		JButton btnDois = new JButton("2");
		btnDois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senhaInformada.append("2");
				atualizaTextField(senhaInformada);

			}
		});
		GridBagConstraints gbc_btnDois = new GridBagConstraints();
		gbc_btnDois.anchor = GridBagConstraints.WEST;
		gbc_btnDois.insets = new Insets(0, 0, 5, 5);
		gbc_btnDois.gridx = 4;
		gbc_btnDois.gridy = 1;
		panel.add(btnDois, gbc_btnDois);

		JButton btnTres = new JButton("3");
		btnTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senhaInformada.append("3");
				atualizaTextField(senhaInformada);

			}
		});
		GridBagConstraints gbc_btnTres = new GridBagConstraints();
		gbc_btnTres.anchor = GridBagConstraints.WEST;
		gbc_btnTres.insets = new Insets(0, 0, 5, 5);
		gbc_btnTres.gridx = 5;
		gbc_btnTres.gridy = 1;
		panel.add(btnTres, gbc_btnTres);

		JButton btnQuatro = new JButton("4");
		btnQuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senhaInformada.append("4");
				atualizaTextField(senhaInformada);
			}
		});
		GridBagConstraints gbc_btnQuatro = new GridBagConstraints();
		gbc_btnQuatro.anchor = GridBagConstraints.WEST;
		gbc_btnQuatro.insets = new Insets(0, 0, 5, 0);
		gbc_btnQuatro.gridx = 6;
		gbc_btnQuatro.gridy = 1;
		panel.add(btnQuatro, gbc_btnQuatro);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				senhaInformada = new StringBuilder();
				senhaInformada.append(txtSenha.getText());

				if (conta.getSenhaOperacoes().equals(senhaInformada.toString())) {

					switch (operacao) {
					case SAQUE:
						validacaoSaque(conta, valor);
						break;
					case TRANSFERENCIA:
						vallidacaoTransferencia(conta, contaTransferir, valor);
						break;
					case PAGAMENTO:
						validacaoPagamento(conta, valor, operacao, codBarras);
						break;
					default:
						break;
					}

				}
			}
		});
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.anchor = GridBagConstraints.WEST;
		gbc_btnConfirmar.fill = GridBagConstraints.VERTICAL;
		gbc_btnConfirmar.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirmar.gridx = 1;
		gbc_btnConfirmar.gridy = 2;
		panel.add(btnConfirmar, gbc_btnConfirmar);

		JButton btnCinco = new JButton("5");
		btnCinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senhaInformada.append("5");
				atualizaTextField(senhaInformada);
			}
		});
		GridBagConstraints gbc_btnCinco = new GridBagConstraints();
		gbc_btnCinco.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCinco.insets = new Insets(0, 0, 0, 5);
		gbc_btnCinco.gridx = 2;
		gbc_btnCinco.gridy = 2;
		panel.add(btnCinco, gbc_btnCinco);

		JButton btnSeis = new JButton("6");
		btnSeis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senhaInformada.append("6");
				atualizaTextField(senhaInformada);
			}
		});
		GridBagConstraints gbc_btnSeis = new GridBagConstraints();
		gbc_btnSeis.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSeis.insets = new Insets(0, 0, 0, 5);
		gbc_btnSeis.gridx = 3;
		gbc_btnSeis.gridy = 2;
		panel.add(btnSeis, gbc_btnSeis);

		JButton btnSete = new JButton("7");
		btnSete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senhaInformada.append("7");
				atualizaTextField(senhaInformada);

			}
		});
		GridBagConstraints gbc_btnSete = new GridBagConstraints();
		gbc_btnSete.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSete.insets = new Insets(0, 0, 0, 5);
		gbc_btnSete.gridx = 4;
		gbc_btnSete.gridy = 2;
		panel.add(btnSete, gbc_btnSete);

		JButton btnOito = new JButton("8");
		btnOito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senhaInformada.append("8");
				atualizaTextField(senhaInformada);
			}
		});
		GridBagConstraints gbc_btnOito = new GridBagConstraints();
		gbc_btnOito.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnOito.insets = new Insets(0, 0, 0, 5);
		gbc_btnOito.gridx = 5;
		gbc_btnOito.gridy = 2;
		panel.add(btnOito, gbc_btnOito);

		JButton btnNove = new JButton("9");
		btnNove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senhaInformada.append("9");
				atualizaTextField(senhaInformada);
			}
		});
		GridBagConstraints gbc_btnNove = new GridBagConstraints();
		gbc_btnNove.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNove.gridx = 6;
		gbc_btnNove.gridy = 2;
		panel.add(btnNove, gbc_btnNove);

	}

	protected void validacaoPagamento(Conta conta, BigDecimal valor,
			Operacao operacao, String codBarras) {

		boolean pagou = new ContaController()
				.pagamento(conta, valor, codBarras);
		limparCampos();
		if (pagou) {
			OperacaoRealizada opRealizada = new OperacaoRealizada(conta,
					Operacao.PAGAMENTO, valor);
			opRealizada.setVisible(true);
			senhaConfirm.setVisible(false);
		}

	}

	protected void vallidacaoTransferencia(Conta conta, Conta contaTransferir,
			BigDecimal valor) {

		boolean transferiu = new ContaController().transferencia(conta,
				contaTransferir, valor);

		limparCampos();

		if (transferiu) {
			OperacaoRealizada opRealizada = new OperacaoRealizada(
					contaTransferir, Operacao.TRANSFERENCIA, valor);
			opRealizada.setVisible(true);
			senhaConfirm.setVisible(false);
		}

	}

	protected void validacaoSaque(Conta conta, BigDecimal valorSaque) {
		boolean sacou = new ContaController().saque(conta, valorSaque,
				senhaInformada.toString());

		limparCampos();

		if (sacou) {
			OperacaoRealizada opRealizada = new OperacaoRealizada(conta,
					Operacao.SAQUE, valorSaque);
			opRealizada.setVisible(true);
			senhaConfirm.setVisible(false);
		}
	}

	private void limparCampos() {
		senhaInformada = new StringBuilder();
		atualizaTextField(senhaInformada);
	}

	protected void atualizaTextField(StringBuilder senhaInformada) {

		txtSenha.setText(senhaInformada.toString());

	}

}
