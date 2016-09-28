package br.univel.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import br.univel.enums.Operacao;
import br.univel.enums.TipoConta;
import br.univel.general.MovimentacaoFacade;
import br.univel.model.Conta;

public class TelaTransferencia extends PadraoCliente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAgencia;
	private JTextField txtConta;
	private JTextField txtTitular;
	private JTextField txtValor;
	private JComboBox cmbTipoConta;

	/**
	 * Create the frame.
	 */
	public TelaTransferencia(Conta conta) {
		super(conta);
		setSize(575, 430);
		setResizable(false);
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane()
				.getLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 444 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0 };
		setTitle("Transferência");

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 49, 154, 188, 0, 0 };
		gbl_panel.rowHeights = new int[] { 33, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblContaDeDestinocrdito = new JLabel(
				"Conta de destino/Cr\u00E9dito");
		GridBagConstraints gbc_lblContaDeDestinocrdito = new GridBagConstraints();
		gbc_lblContaDeDestinocrdito.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblContaDeDestinocrdito.insets = new Insets(0, 0, 5, 5);
		gbc_lblContaDeDestinocrdito.gridx = 1;
		gbc_lblContaDeDestinocrdito.gridy = 0;
		panel.add(lblContaDeDestinocrdito, gbc_lblContaDeDestinocrdito);

		JLabel lblAg = new JLabel("AG");
		GridBagConstraints gbc_lblAg = new GridBagConstraints();
		gbc_lblAg.insets = new Insets(0, 0, 5, 5);
		gbc_lblAg.anchor = GridBagConstraints.WEST;
		gbc_lblAg.gridx = 1;
		gbc_lblAg.gridy = 1;
		panel.add(lblAg, gbc_lblAg);

		JLabel lblConta = new JLabel("Conta");
		GridBagConstraints gbc_lblConta = new GridBagConstraints();
		gbc_lblConta.anchor = GridBagConstraints.WEST;
		gbc_lblConta.insets = new Insets(0, 0, 5, 5);
		gbc_lblConta.gridx = 2;
		gbc_lblConta.gridy = 1;
		panel.add(lblConta, gbc_lblConta);

		try {
			txtAgencia = new JFormattedTextField(new MaskFormatter("#####-##"));
			GridBagConstraints gbc_txtAgencia = new GridBagConstraints();
			gbc_txtAgencia.insets = new Insets(0, 0, 5, 5);
			gbc_txtAgencia.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAgencia.gridx = 1;
			gbc_txtAgencia.gridy = 2;
			panel.add(txtAgencia, gbc_txtAgencia);
			txtAgencia.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			txtConta = new JFormattedTextField(new MaskFormatter("#####-##"));
			GridBagConstraints gbc_txtConta = new GridBagConstraints();
			gbc_txtConta.insets = new Insets(0, 0, 5, 5);
			gbc_txtConta.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtConta.gridx = 2;
			gbc_txtConta.gridy = 2;
			panel.add(txtConta, gbc_txtConta);
			txtConta.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JLabel lblTipoConta = new JLabel("Tipo Conta");
		GridBagConstraints gbc_lblTipoConta = new GridBagConstraints();
		gbc_lblTipoConta.anchor = GridBagConstraints.WEST;
		gbc_lblTipoConta.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoConta.gridx = 1;
		gbc_lblTipoConta.gridy = 3;
		panel.add(lblTipoConta, gbc_lblTipoConta);

		cmbTipoConta = new JComboBox(TipoConta.values());
		GridBagConstraints gbc_cmbTipoConta = new GridBagConstraints();
		gbc_cmbTipoConta.insets = new Insets(0, 0, 5, 5);
		gbc_cmbTipoConta.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbTipoConta.gridx = 1;
		gbc_cmbTipoConta.gridy = 4;
		panel.add(cmbTipoConta, gbc_cmbTipoConta);

		JLabel lblTitular = new JLabel("Titular");
		GridBagConstraints gbc_lblTitular = new GridBagConstraints();
		gbc_lblTitular.anchor = GridBagConstraints.WEST;
		gbc_lblTitular.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitular.gridx = 1;
		gbc_lblTitular.gridy = 5;
		panel.add(lblTitular, gbc_lblTitular);

		JLabel lblValor = new JLabel("Valor");
		GridBagConstraints gbc_lblValor = new GridBagConstraints();
		gbc_lblValor.anchor = GridBagConstraints.WEST;
		gbc_lblValor.insets = new Insets(0, 0, 5, 0);
		gbc_lblValor.gridx = 3;
		gbc_lblValor.gridy = 5;
		panel.add(lblValor, gbc_lblValor);

		txtTitular = new JTextField();
		GridBagConstraints gbc_txtTitular = new GridBagConstraints();
		gbc_txtTitular.insets = new Insets(0, 0, 5, 5);
		gbc_txtTitular.gridwidth = 2;
		gbc_txtTitular.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitular.gridx = 1;
		gbc_txtTitular.gridy = 6;
		panel.add(txtTitular, gbc_txtTitular);
		txtTitular.setColumns(10);

		DecimalFormat dFormat = new DecimalFormat("#,###,###.00");
		NumberFormatter formatter = new NumberFormatter(dFormat);
		formatter.setFormat(dFormat);
		formatter.setAllowsInvalid(false);
		txtValor = new JFormattedTextField();
		((JFormattedTextField) txtValor)
				.setFormatterFactory(new DefaultFormatterFactory(formatter));
		txtValor.setText(new DecimalFormat("R$ #,##0.00").format(0.00));
		GridBagConstraints gbc_txtValor = new GridBagConstraints();
		gbc_txtValor.insets = new Insets(0, 0, 5, 0);
		gbc_txtValor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtValor.gridx = 3;
		gbc_txtValor.gridy = 6;
		panel.add(txtValor, gbc_txtValor);
		txtValor.setColumns(10);

		JButton btnConfirme = new JButton("Confirme");
		btnConfirme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Conta contaRecebeTransf = new Conta();
				contaRecebeTransf.setAgencia(txtAgencia.getText().replace("-",
						""));
				contaRecebeTransf.setNome(txtTitular.getText().trim());
				contaRecebeTransf.setNumeroConta(txtConta.getText().replace(
						"-", ""));
				contaRecebeTransf.setTipoConta(cmbTipoConta.getSelectedItem()
						.toString());

				contaRecebeTransf = new MovimentacaoFacade()
						.validaContaTransferencia(contaRecebeTransf);

				if (contaRecebeTransf == null) {

					JOptionPane.showMessageDialog(TelaTransferencia.this,
							"Conta não localizada!", "Atenção",
							JOptionPane.WARNING_MESSAGE);

				} else {

					String valor = txtValor.getText().replace(".", "")
							.replace(",", ".");
					new SenhaConfirm(conta, new BigDecimal(valor),
							contaRecebeTransf, Operacao.TRANSFERENCIA, null)
							.setVisible(true);

					limparCampos();

				}

			}
		});
		GridBagConstraints gbc_btnConfirme = new GridBagConstraints();
		gbc_btnConfirme.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConfirme.gridx = 3;
		gbc_btnConfirme.gridy = 7;
		panel.add(btnConfirme, gbc_btnConfirme);

	}

	protected void limparCampos() {

		txtAgencia.setText("");
		txtConta.setText("");
		txtTitular.setText("");
		txtValor.setText("0.00");
		cmbTipoConta.setSelectedIndex(0);

	}

	@Override
	public void contaAlterada(Conta conta) {

		PadraoCliente.populaTelaInfConta(conta);
	}

}
