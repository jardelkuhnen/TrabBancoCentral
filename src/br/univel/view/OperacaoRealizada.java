package br.univel.view;

import javax.swing.JPanel;

import br.univel.model.Conta;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OperacaoRealizada extends PadraoCliente {

	private JPanel contentPane;

	public OperacaoRealizada(Conta conta) {
		super(conta);
		setTitle("Operação realizada com sucesso");
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane().getLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0 };

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblOperacaoRealizada = new JLabel("");
		GridBagConstraints gbc_lblOperacaoRealizada = new GridBagConstraints();
		gbc_lblOperacaoRealizada.anchor = GridBagConstraints.WEST;
		gbc_lblOperacaoRealizada.gridwidth = 5;
		gbc_lblOperacaoRealizada.insets = new Insets(0, 0, 5, 5);
		gbc_lblOperacaoRealizada.gridx = 2;
		gbc_lblOperacaoRealizada.gridy = 1;
		panel.add(lblOperacaoRealizada, gbc_lblOperacaoRealizada);

		JLabel lblInformVlr = new JLabel("Valor:");
		GridBagConstraints gbc_lblInformVlr = new GridBagConstraints();
		gbc_lblInformVlr.insets = new Insets(0, 0, 0, 5);
		gbc_lblInformVlr.gridx = 2;
		gbc_lblInformVlr.gridy = 2;
		panel.add(lblInformVlr, gbc_lblInformVlr);

		JButton btnRetornar = new JButton("Retornar");
		btnRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		JLabel lblValor = new JLabel("");
		GridBagConstraints gbc_lblValor = new GridBagConstraints();
		gbc_lblValor.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblValor.insets = new Insets(0, 0, 0, 5);
		gbc_lblValor.gridx = 3;
		gbc_lblValor.gridy = 2;
		panel.add(lblValor, gbc_lblValor);
		GridBagConstraints gbc_btnRetornar = new GridBagConstraints();
		gbc_btnRetornar.insets = new Insets(0, 0, 0, 5);
		gbc_btnRetornar.gridx = 5;
		gbc_btnRetornar.gridy = 2;
		panel.add(btnRetornar, gbc_btnRetornar);

	}

}
