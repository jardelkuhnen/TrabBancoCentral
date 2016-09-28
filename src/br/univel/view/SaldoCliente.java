package br.univel.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.univel.controller.ContaController;
import br.univel.model.Conta;
import br.univel.model.ListaSaldoModel;
import br.univel.model.Movimentacao;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

public class SaldoCliente extends PadraoCliente implements WindowListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtDataDe;
	private JTextField txtDataAte;
	private JTextField txtSaldo;
	private JTable tblMovimentacoes;
	private List<Movimentacao> movimentacoes;
	private ListaSaldoModel model;

	public SaldoCliente(Conta conta) {
		super(conta);
		addWindowListener(this);
		setTitle("Saldo Cliente");
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane().getLayout();
		gridBagLayout.columnWidths = new int[] { 251 };
		gridBagLayout.rowHeights = new int[] { 0, 207, 44 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0 };

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.gridheight = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 69, 70, 45, 0, 62, 51, 18, 36, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 41, 32, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.gridwidth = 11;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);

		tblMovimentacoes = new JTable();
		scrollPane.setViewportView(tblMovimentacoes);

		JButton voltaAno = new JButton("|<");
		GridBagConstraints gbc_voltaAno = new GridBagConstraints();
		gbc_voltaAno.insets = new Insets(0, 0, 0, 5);
		gbc_voltaAno.fill = GridBagConstraints.BOTH;
		gbc_voltaAno.gridx = 0;
		gbc_voltaAno.gridy = 7;
		panel.add(voltaAno, gbc_voltaAno);

		JButton voltaMes = new JButton("<<");
		GridBagConstraints gbc_voltaMes = new GridBagConstraints();
		gbc_voltaMes.insets = new Insets(0, 0, 0, 5);
		gbc_voltaMes.fill = GridBagConstraints.BOTH;
		gbc_voltaMes.gridx = 1;
		gbc_voltaMes.gridy = 7;
		panel.add(voltaMes, gbc_voltaMes);

		JButton voltaDia = new JButton("<");
		GridBagConstraints gbc_voltaDia = new GridBagConstraints();
		gbc_voltaDia.insets = new Insets(0, 0, 0, 5);
		gbc_voltaDia.fill = GridBagConstraints.BOTH;
		gbc_voltaDia.gridx = 2;
		gbc_voltaDia.gridy = 7;
		panel.add(voltaDia, gbc_voltaDia);

		try {
			txtDataDe = new JFormattedTextField(new MaskFormatter("##/##/####"));
			GridBagConstraints gbc_txtDataDe = new GridBagConstraints();
			gbc_txtDataDe.insets = new Insets(0, 0, 0, 5);
			gbc_txtDataDe.fill = GridBagConstraints.BOTH;
			gbc_txtDataDe.gridx = 3;
			gbc_txtDataDe.gridy = 7;
			panel.add(txtDataDe, gbc_txtDataDe);
			txtDataDe.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			txtDataAte = new JFormattedTextField(new MaskFormatter("##/##/####"));
			GridBagConstraints gbc_txtDataAte = new GridBagConstraints();
			gbc_txtDataAte.insets = new Insets(0, 0, 0, 5);
			gbc_txtDataAte.fill = GridBagConstraints.BOTH;
			gbc_txtDataAte.gridx = 4;
			gbc_txtDataAte.gridy = 7;
			panel.add(txtDataAte, gbc_txtDataAte);
			txtDataAte.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JButton avancaDia = new JButton(">");
		GridBagConstraints gbc_avancaDia = new GridBagConstraints();
		gbc_avancaDia.insets = new Insets(0, 0, 0, 5);
		gbc_avancaDia.fill = GridBagConstraints.BOTH;
		gbc_avancaDia.gridx = 5;
		gbc_avancaDia.gridy = 7;
		panel.add(avancaDia, gbc_avancaDia);

		JButton avancaMes = new JButton(">>");
		GridBagConstraints gbc_avancaMes = new GridBagConstraints();
		gbc_avancaMes.insets = new Insets(0, 0, 0, 5);
		gbc_avancaMes.fill = GridBagConstraints.BOTH;
		gbc_avancaMes.gridx = 6;
		gbc_avancaMes.gridy = 7;
		panel.add(avancaMes, gbc_avancaMes);

		JButton avancaAno = new JButton(">|");
		GridBagConstraints gbc_avancaAno = new GridBagConstraints();
		gbc_avancaAno.insets = new Insets(0, 0, 0, 5);
		gbc_avancaAno.fill = GridBagConstraints.BOTH;
		gbc_avancaAno.gridx = 7;
		gbc_avancaAno.gridy = 7;
		panel.add(avancaAno, gbc_avancaAno);

		JButton btnImprimir = new JButton("Print");
		GridBagConstraints gbc_btnImprimir = new GridBagConstraints();
		gbc_btnImprimir.insets = new Insets(0, 0, 0, 5);
		gbc_btnImprimir.fill = GridBagConstraints.BOTH;
		gbc_btnImprimir.gridx = 8;
		gbc_btnImprimir.gridy = 7;
		panel.add(btnImprimir, gbc_btnImprimir);
		
		JLabel lblSaldoper = new JLabel("");
		GridBagConstraints gbc_lblSaldoper = new GridBagConstraints();
		gbc_lblSaldoper.insets = new Insets(0, 0, 0, 5);
		gbc_lblSaldoper.anchor = GridBagConstraints.EAST;
		gbc_lblSaldoper.gridx = 9;
		gbc_lblSaldoper.gridy = 7;
		panel.add(lblSaldoper, gbc_lblSaldoper);

		txtSaldo = new JTextField("");
		GridBagConstraints gbc_txtSaldo = new GridBagConstraints();
		gbc_txtSaldo.fill = GridBagConstraints.BOTH;
		gbc_txtSaldo.gridx = 10;
		gbc_txtSaldo.gridy = 7;
		panel.add(txtSaldo, gbc_txtSaldo);
		txtSaldo.setColumns(10);

	}

	private String buscaValor() {

		return null;
	}

	public void preencherTela() {

		movimentacoes = new ContaController().buscarMovimentacao();
		model = new ListaSaldoModel(movimentacoes);
		tblMovimentacoes.setModel(model);
	}

	@Override
	public void contaAlterada(Conta conta) {
		PadraoCliente.populaTelaInfConta(conta);
	}

	@Override
	public void windowActivated(WindowEvent e) {

		preencherTela();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		preencherTela();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		preencherTela();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		preencherTela();
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		preencherTela();
	}

	@Override
	public void windowIconified(WindowEvent e) {
		preencherTela();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		preencherTela();
	}

}
