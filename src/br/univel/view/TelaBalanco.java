package br.univel.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.univel.controller.AgenciaController;
import br.univel.model.Balanco;
import br.univel.model.ListaBalancoModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaBalanco extends PadraoBancario implements WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAgencia;
	private JTable tblMovimentacao;
	private List<Balanco> balancos;
	private ListaBalancoModel model;
	private JLabel lblTotalSaque;
	private JLabel lblSaldoCaixa;
	private JLabel lblTotalDeposito;

	public TelaBalanco() {
		super();
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane()
				.getLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0 };
		setBounds(100, 100, 586, 564);
		setTitle("Balanço");

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);

		try {
			GridBagLayout gbl_panel_2 = new GridBagLayout();
			gbl_panel_2.columnWidths = new int[] { 363, 86, 106, 0 };
			gbl_panel_2.rowHeights = new int[] { 28, 0 };
			gbl_panel_2.columnWeights = new double[] { 1.0, 0.0, 0.0,
					Double.MIN_VALUE };
			gbl_panel_2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			panel_2.setLayout(gbl_panel_2);

			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					preencherTela(txtAgencia.getText().replace("-", ""));
				}
			});

			JLabel lblInformeONmero = new JLabel(
					"Informe o n\u00FAmero da ag\u00EAnica:");
			lblInformeONmero.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblInformeONmero = new GridBagConstraints();
			gbc_lblInformeONmero.insets = new Insets(0, 0, 0, 5);
			gbc_lblInformeONmero.anchor = GridBagConstraints.EAST;
			gbc_lblInformeONmero.gridx = 0;
			gbc_lblInformeONmero.gridy = 0;
			panel_2.add(lblInformeONmero, gbc_lblInformeONmero);
			txtAgencia = new JFormattedTextField(new MaskFormatter("#####-##"));
			GridBagConstraints gbc_txtAgencia = new GridBagConstraints();
			gbc_txtAgencia.anchor = GridBagConstraints.EAST;
			gbc_txtAgencia.fill = GridBagConstraints.VERTICAL;
			gbc_txtAgencia.insets = new Insets(0, 0, 0, 5);
			gbc_txtAgencia.gridx = 1;
			gbc_txtAgencia.gridy = 0;
			panel_2.add(txtAgencia, gbc_txtAgencia);
			txtAgencia.setColumns(10);
			GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
			gbc_btnBuscar.fill = GridBagConstraints.BOTH;
			gbc_btnBuscar.gridx = 2;
			gbc_btnBuscar.gridy = 0;
			panel_2.add(btnBuscar, gbc_btnBuscar);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridheight = 8;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);

		tblMovimentacao = new JTable();
		scrollPane.setViewportView(tblMovimentacao);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.gridheight = 3;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 9;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 65, 120, 46, 51, 100, 46, 0 };
		gbl_panel_1.rowHeights = new int[] { 14, 14, 14, 31, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblTotalDeDepsito = new JLabel("Total de Dep\u00F3sitos: R$");
		lblTotalDeDepsito.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTotalDeDepsito = new GridBagConstraints();
		gbc_lblTotalDeDepsito.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblTotalDeDepsito.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalDeDepsito.gridx = 1;
		gbc_lblTotalDeDepsito.gridy = 1;
		panel_1.add(lblTotalDeDepsito, gbc_lblTotalDeDepsito);

		lblTotalDeposito = new JLabel("");
		lblTotalDeposito.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTotalDeposito = new GridBagConstraints();
		gbc_lblTotalDeposito.anchor = GridBagConstraints.NORTH;
		gbc_lblTotalDeposito.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTotalDeposito.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalDeposito.gridx = 2;
		gbc_lblTotalDeposito.gridy = 1;
		panel_1.add(lblTotalDeposito, gbc_lblTotalDeposito);

		JLabel lblSaldoEmCaixa = new JLabel("Saldo em Caixa: R$ ");
		lblSaldoEmCaixa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblSaldoEmCaixa = new GridBagConstraints();
		gbc_lblSaldoEmCaixa.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblSaldoEmCaixa.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaldoEmCaixa.gridx = 4;
		gbc_lblSaldoEmCaixa.gridy = 2;
		panel_1.add(lblSaldoEmCaixa, gbc_lblSaldoEmCaixa);

		lblSaldoCaixa = new JLabel("");
		lblSaldoCaixa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblSaldoCaixa = new GridBagConstraints();
		gbc_lblSaldoCaixa.anchor = GridBagConstraints.NORTH;
		gbc_lblSaldoCaixa.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSaldoCaixa.insets = new Insets(0, 0, 5, 0);
		gbc_lblSaldoCaixa.gridx = 5;
		gbc_lblSaldoCaixa.gridy = 2;
		panel_1.add(lblSaldoCaixa, gbc_lblSaldoCaixa);

		JLabel lblTotalDeSaques = new JLabel("Total de Saques: R$ ");
		lblTotalDeSaques.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTotalDeSaques = new GridBagConstraints();
		gbc_lblTotalDeSaques.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblTotalDeSaques.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotalDeSaques.gridx = 1;
		gbc_lblTotalDeSaques.gridy = 3;
		panel_1.add(lblTotalDeSaques, gbc_lblTotalDeSaques);

		lblTotalSaque = new JLabel("");
		lblTotalSaque.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTotalSaque = new GridBagConstraints();
		gbc_lblTotalSaque.anchor = GridBagConstraints.NORTH;
		gbc_lblTotalSaque.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTotalSaque.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotalSaque.gridx = 2;
		gbc_lblTotalSaque.gridy = 3;
		panel_1.add(lblTotalSaque, gbc_lblTotalSaque);

		preencherTela(txtAgencia.getText());

	}

	@Override
	public void windowActivated(WindowEvent e) {

		preencherTela(txtAgencia.getText().replace("-", ""));
	}

	private void preencherTela(String agencia) {

		balancos = new AgenciaController().getBalanco(agencia);
		model = new ListaBalancoModel(balancos);
		tblMovimentacao.setModel(model);

		calculaValorMovimentacao(balancos);
	}

	private void calculaValorMovimentacao(List<Balanco> balancos) {

		BigDecimal saque = new BigDecimal(0.00);
		BigDecimal transf = new BigDecimal(0.00);
		BigDecimal pagam = new BigDecimal(0.00);
		BigDecimal depos = new BigDecimal(0.00);
		BigDecimal total = new BigDecimal(0.00);

		for (int i = 0; i < balancos.size(); i++) {

			switch (balancos.get(i).getOperacao()) {
			
			case "saque":
				saque.add(balancos.get(i).getValor());
				break;
			case "transferência":
				transf.add(balancos.get(i).getValor());
				break;
			case "pagamento":
				pagam.add(balancos.get(i).getValor());
				break;
			case "depósito":
				depos.add(balancos.get(i).getValor());
				break;
			default:
				break;
			}

		}

		total.add(depos.add(pagam).subtract(saque).subtract(transf));

		lblTotalDeposito.setText(depos.toString());
		lblTotalSaque.setText(saque.toString());
		lblSaldoCaixa.setText(total.toString());
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
		preencherTela(txtAgencia.getText().replace("-", ""));
	}
}
