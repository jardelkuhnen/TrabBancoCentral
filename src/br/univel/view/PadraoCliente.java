package br.univel.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.general.GetHorarioLocal;
import br.univel.general.MovimentacaoFacade;
import br.univel.interfaces.AtualizacaoDeConta;
import br.univel.model.Conta;
import br.univel.model.FormatoData;

public abstract class PadraoCliente extends JFrame implements AtualizacaoDeConta, Observer {

	@Override
	public void update(Observable arg0, Object arg1) {

		PadraoCliente.populaTelaInfConta((Conta) arg1);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	protected static JLabel lblDataAcess;
	private static JLabel lblAgencia;
	private static JLabel lblTipoConta;
	private static JLabel lblNumConta;
	private static JLabel lblSaldo;

	public JLabel getLblDataAcess() {
		return lblDataAcess;
	}

	protected void setLblDataAcess(String lblDataAcess) {
		this.lblDataAcess.setText(lblDataAcess);
	}

	public JLabel getLblAgencia() {
		return lblAgencia;
	}

	public void setLblAgencia(JLabel lblAgencia) {
		this.lblAgencia = lblAgencia;
	}

	public JLabel getLblTipoConta() {
		return lblTipoConta;
	}

	public void setLblTipoConta(JLabel lblTipoConta) {
		this.lblTipoConta = lblTipoConta;
	}

	public JLabel getLblNumConta() {
		return lblNumConta;
	}

	public void setLblNumConta(JLabel lblNumConta) {
		this.lblNumConta = lblNumConta;
	}

	public JLabel getLblSaldo() {
		return lblSaldo;
	}

	public void setLblSaldo(JLabel lblSaldo) {
		this.lblSaldo = lblSaldo;
	}

	public PadraoCliente(Conta conta) {
		setSize(800, 375);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 370);
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Imagens/Icone.png"));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 77, 0, 414, 0 };
		gbl_contentPane.rowHeights = new int[] { 89, 253, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel cabecalho = new JPanel();
		cabecalho.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		GridBagConstraints gbc_cabecalho = new GridBagConstraints();
		gbc_cabecalho.gridwidth = 3;
		gbc_cabecalho.fill = GridBagConstraints.BOTH;
		gbc_cabecalho.insets = new Insets(0, 0, 5, 0);
		gbc_cabecalho.gridx = 0;
		gbc_cabecalho.gridy = 0;
		contentPane.add(cabecalho, gbc_cabecalho);
		GridBagLayout gbl_cabecalho = new GridBagLayout();
		gbl_cabecalho.columnWidths = new int[] { 94, 208, 90, 0 };
		gbl_cabecalho.rowHeights = new int[] { 67, 0, 0 };
		gbl_cabecalho.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_cabecalho.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		cabecalho.setLayout(gbl_cabecalho);

		JLabel lblBancoCentral = new JLabel("Banco Central");
		lblBancoCentral.setForeground(new Color(0, 0, 205));
		lblBancoCentral.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblBancoCentral = new GridBagConstraints();
		gbc_lblBancoCentral.anchor = GridBagConstraints.WEST;
		gbc_lblBancoCentral.fill = GridBagConstraints.VERTICAL;
		gbc_lblBancoCentral.insets = new Insets(0, 0, 5, 5);
		gbc_lblBancoCentral.gridx = 1;
		gbc_lblBancoCentral.gridy = 0;
		cabecalho.add(lblBancoCentral, gbc_lblBancoCentral);

		lblDataAcess = new JLabel("");
		lblDataAcess.setForeground(new Color(0, 0, 205));
		lblDataAcess.setText(new GetHorarioLocal().getHorarioLocal(FormatoData.getDtformattddmmyyyyhhmm()));
		GridBagConstraints gbc_lblDataAcess = new GridBagConstraints();
		gbc_lblDataAcess.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDataAcess.insets = new Insets(0, 0, 5, 0);
		gbc_lblDataAcess.gridx = 2;
		gbc_lblDataAcess.gridy = 0;
		cabecalho.add(lblDataAcess, gbc_lblDataAcess);

		JLabel imagem = new JLabel("");
		imagem.setIcon(new ImageIcon(PadraoCliente.class.getResource("/Imagem/Icone.png")));
		GridBagConstraints gbc_imagem = new GridBagConstraints();
		gbc_imagem.anchor = GridBagConstraints.WEST;
		gbc_imagem.gridheight = 2;
		gbc_imagem.insets = new Insets(0, 0, 0, 5);
		gbc_imagem.gridx = 0;
		gbc_imagem.gridy = 0;
		cabecalho.add(imagem, gbc_imagem);

		JLabel lblAquiSeuDinheiro = new JLabel("Aqui seu dinheiro rende mais");
		lblAquiSeuDinheiro.setForeground(new Color(0, 0, 205));
		lblAquiSeuDinheiro.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblAquiSeuDinheiro = new GridBagConstraints();
		gbc_lblAquiSeuDinheiro.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblAquiSeuDinheiro.insets = new Insets(0, 0, 0, 5);
		gbc_lblAquiSeuDinheiro.gridx = 1;
		gbc_lblAquiSeuDinheiro.gridy = 1;
		cabecalho.add(lblAquiSeuDinheiro, gbc_lblAquiSeuDinheiro);

		JPanel panel = new JPanel();
		panel.setForeground(Color.GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 1;
		cabecalho.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 124, 25, 46, 0 };
		gbl_panel.rowHeights = new int[] { 26, 15, 10, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblAg = new JLabel("AG:");
		lblAg.setForeground(new Color(0, 0, 205));
		GridBagConstraints gbc_lblAg = new GridBagConstraints();
		gbc_lblAg.anchor = GridBagConstraints.EAST;
		gbc_lblAg.insets = new Insets(0, 0, 5, 5);
		gbc_lblAg.gridx = 1;
		gbc_lblAg.gridy = 0;
		panel.add(lblAg, gbc_lblAg);

		lblAgencia = new JLabel("");
		lblAgencia.setForeground(new Color(0, 0, 205));
		GridBagConstraints gbc_lblAgencia = new GridBagConstraints();
		gbc_lblAgencia.anchor = GridBagConstraints.WEST;
		gbc_lblAgencia.insets = new Insets(0, 0, 5, 0);
		gbc_lblAgencia.fill = GridBagConstraints.VERTICAL;
		gbc_lblAgencia.gridx = 2;
		gbc_lblAgencia.gridy = 0;
		panel.add(lblAgencia, gbc_lblAgencia);

		lblTipoConta = new JLabel("");
		lblTipoConta.setForeground(new Color(0, 0, 205));
		GridBagConstraints gbc_lblTipoConta = new GridBagConstraints();
		gbc_lblTipoConta.anchor = GridBagConstraints.EAST;
		gbc_lblTipoConta.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoConta.gridx = 0;
		gbc_lblTipoConta.gridy = 1;
		panel.add(lblTipoConta, gbc_lblTipoConta);

		lblNumConta = new JLabel("");
		lblNumConta.setForeground(new Color(0, 0, 205));
		GridBagConstraints gbc_lblNumConta = new GridBagConstraints();
		gbc_lblNumConta.anchor = GridBagConstraints.WEST;
		gbc_lblNumConta.insets = new Insets(0, 0, 5, 0);
		gbc_lblNumConta.gridx = 2;
		gbc_lblNumConta.gridy = 1;
		panel.add(lblNumConta, gbc_lblNumConta);

		JLabel Saldo = new JLabel("Saldo:");
		Saldo.setForeground(new Color(0, 0, 205));
		GridBagConstraints gbc_Saldo = new GridBagConstraints();
		gbc_Saldo.anchor = GridBagConstraints.EAST;
		gbc_Saldo.insets = new Insets(0, 0, 0, 5);
		gbc_Saldo.gridx = 0;
		gbc_Saldo.gridy = 2;
		panel.add(Saldo, gbc_Saldo);

		JLabel lblR = new JLabel("R$");
		lblR.setForeground(new Color(0, 0, 205));
		GridBagConstraints gbc_lblR = new GridBagConstraints();
		gbc_lblR.anchor = GridBagConstraints.EAST;
		gbc_lblR.insets = new Insets(0, 0, 0, 5);
		gbc_lblR.gridx = 1;
		gbc_lblR.gridy = 2;
		panel.add(lblR, gbc_lblR);

		lblSaldo = new JLabel("");
		lblSaldo.setForeground(new Color(0, 0, 205));
		GridBagConstraints gbc_lblSaldo = new GridBagConstraints();
		gbc_lblSaldo.anchor = GridBagConstraints.WEST;
		gbc_lblSaldo.gridx = 2;
		gbc_lblSaldo.gridy = 2;
		panel.add(lblSaldo, gbc_lblSaldo);

		populaTelaInfConta(conta);

	}

	@Override
	public void contaAlterada(Conta conta) {
		PadraoCliente.populaTelaInfConta(conta);

	}

	public static void populaTelaInfConta(Conta conta) {
		lblSaldo.setText(String.valueOf(conta.getSaldo()));
		lblNumConta.setText(conta.getNumeroConta());
		lblAgencia.setText(conta.getAgencia());
		lblTipoConta.setText(conta.getTipoConta());
	}

}
