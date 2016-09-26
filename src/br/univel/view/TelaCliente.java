package br.univel.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.univel.controller.ContaController;
import br.univel.model.Conta;

public class TelaCliente extends PadraoCliente {

	static final String CONTA_ELETRONICA = "Conta Eletrônica";
	static final String CONTA_POUPANCA = "Conta Poupança";
	static final String CONTA_CORRENTE = "Conta Corrente";
	private JButton btnSaque;
	private JButton btnTransferncia;
	private JButton btnSaldo;
	private JButton btnPagamentos;
	private JButton btnDepsito;
	private JButton btnFinaliza;
	private PadraoCliente padraoCliente;

	public TelaCliente(Conta conta) {
		super(conta);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Área do Cliente");
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane()
				.getLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 1.0 };

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 290, 31, 292, 0 };
		gbl_panel.rowHeights = new int[] { 67, 77, 64, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		btnSaque = new JButton("1- Saque");
		btnSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				TelaSaque telaSaque = new TelaSaque(conta);
				telaSaque.setVisible(true);
				telaSaque.setLocationRelativeTo(null);
			}
		});
		GridBagConstraints gbc_btnSaque = new GridBagConstraints();
		gbc_btnSaque.fill = GridBagConstraints.BOTH;
		gbc_btnSaque.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaque.gridx = 0;
		gbc_btnSaque.gridy = 0;
		panel.add(btnSaque, gbc_btnSaque);

		btnTransferncia = new JButton("4- Transfer\u00EAncia");
		btnTransferncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new TelaTransferencia(conta).setVisible(true);

			}
		});
		GridBagConstraints gbc_btnTransferncia = new GridBagConstraints();
		gbc_btnTransferncia.fill = GridBagConstraints.BOTH;
		gbc_btnTransferncia.insets = new Insets(0, 0, 5, 0);
		gbc_btnTransferncia.gridx = 2;
		gbc_btnTransferncia.gridy = 0;
		panel.add(btnTransferncia, gbc_btnTransferncia);

		btnSaldo = new JButton("2- Saldo");
		GridBagConstraints gbc_btnSaldo = new GridBagConstraints();
		gbc_btnSaldo.fill = GridBagConstraints.BOTH;
		gbc_btnSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaldo.gridx = 0;
		gbc_btnSaldo.gridy = 1;
		panel.add(btnSaldo, gbc_btnSaldo);

		btnPagamentos = new JButton("5- Pagamentos");
		btnPagamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaPagamento telaPag = new TelaPagamento(conta);
				telaPag.setVisible(true);
				telaPag.setLocationRelativeTo(null);

			}
		});
		GridBagConstraints gbc_btnPagamentos = new GridBagConstraints();
		gbc_btnPagamentos.fill = GridBagConstraints.BOTH;
		gbc_btnPagamentos.insets = new Insets(0, 0, 5, 0);
		gbc_btnPagamentos.gridx = 2;
		gbc_btnPagamentos.gridy = 1;
		panel.add(btnPagamentos, gbc_btnPagamentos);

		btnDepsito = new JButton("3- Dep\u00F3sito");
		btnDepsito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new TelaDeposito(conta).setVisible(true);
				TelaCliente telaCliente = new TelaCliente(conta);
			}
		});

		GridBagConstraints gbc_btnDepsito = new GridBagConstraints();
		gbc_btnDepsito.fill = GridBagConstraints.BOTH;
		gbc_btnDepsito.insets = new Insets(0, 0, 0, 5);
		gbc_btnDepsito.gridx = 0;
		gbc_btnDepsito.gridy = 2;
		panel.add(btnDepsito, gbc_btnDepsito);

		btnFinaliza = new JButton("6- Finalizar");
		btnFinaliza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Integer decisao = JOptionPane.showConfirmDialog(
						TelaCliente.this,
						"Deseja relmente inativar esta conta?", "Atenção",
						JOptionPane.YES_NO_OPTION);

				if (decisao.equals(0)) {
					new ContaController().finalizarConta(conta);
				}

			}
		});
		GridBagConstraints gbc_btnFinaliza = new GridBagConstraints();
		gbc_btnFinaliza.fill = GridBagConstraints.BOTH;
		gbc_btnFinaliza.gridx = 2;
		gbc_btnFinaliza.gridy = 2;
		panel.add(btnFinaliza, gbc_btnFinaliza);

		validaOperacoesDisponiveis(conta);

	}

	private void validaOperacoesDisponiveis(final Conta conta) {

		if (conta.getId() == null) {
			JOptionPane.showMessageDialog(TelaCliente.this,
					"Usuário sem conta cadastrada. Verifique!", "Atenção",
					JOptionPane.ERROR_MESSAGE);

		} else {

			switch (conta.getTipoConta()) {
			case CONTA_POUPANCA:
				btnPagamentos.setEnabled(false);
				break;
			case CONTA_ELETRONICA:
				btnSaque.setEnabled(false);
				btnDepsito.setEnabled(false);
				break;
			default:
				break;
			}
		}
	}

}
