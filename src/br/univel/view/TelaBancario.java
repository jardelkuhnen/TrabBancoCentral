package br.univel.view;

import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;

public class TelaBancario extends PadraoBancario {

	private JPanel contentPane;

	public TelaBancario() {
		super();
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane().getLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0 };

		setTitle("Área do Bancario");

		JPanel corpo = new JPanel();
		GridBagConstraints gbc_corpo = new GridBagConstraints();
		gbc_corpo.gridheight = 2;
		gbc_corpo.gridwidth = 2;
		gbc_corpo.fill = GridBagConstraints.BOTH;
		gbc_corpo.gridx = 0;
		gbc_corpo.gridy = 1;
		getContentPane().add(corpo, gbc_corpo);
		GridBagLayout gbl_corpo = new GridBagLayout();
		gbl_corpo.columnWidths = new int[] { 1, 0, 0 };
		gbl_corpo.rowHeights = new int[] { 1, 0, 0, 0 };
		gbl_corpo.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_corpo.rowWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		corpo.setLayout(gbl_corpo);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.gridheight = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		corpo.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{302, 243, 0};
		gbl_panel.rowHeights = new int[]{55, 64, 68, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnInfo = new JButton("1 - Informa\u00E7\u00F5es de Contas");
		GridBagConstraints gbc_btnInfo = new GridBagConstraints();
		gbc_btnInfo.fill = GridBagConstraints.BOTH;
		gbc_btnInfo.insets = new Insets(0, 0, 5, 5);
		gbc_btnInfo.gridx = 0;
		gbc_btnInfo.gridy = 0;
		panel.add(btnInfo, gbc_btnInfo);
		
		JButton btnProfi = new JButton("4 - Profissionais");
		GridBagConstraints gbc_btnProfi = new GridBagConstraints();
		gbc_btnProfi.fill = GridBagConstraints.BOTH;
		gbc_btnProfi.insets = new Insets(0, 0, 5, 0);
		gbc_btnProfi.gridx = 1;
		gbc_btnProfi.gridy = 0;
		panel.add(btnProfi, gbc_btnProfi);
		
		JButton btnNovaConta = new JButton("2 - Nova Conta");
		GridBagConstraints gbc_btnNovaConta = new GridBagConstraints();
		gbc_btnNovaConta.fill = GridBagConstraints.BOTH;
		gbc_btnNovaConta.insets = new Insets(0, 0, 5, 5);
		gbc_btnNovaConta.gridx = 0;
		gbc_btnNovaConta.gridy = 1;
		panel.add(btnNovaConta, gbc_btnNovaConta);
		
		JButton btnBalanco = new JButton("5 - Balan\u00E7o");
		GridBagConstraints gbc_btnBalanco = new GridBagConstraints();
		gbc_btnBalanco.fill = GridBagConstraints.BOTH;
		gbc_btnBalanco.insets = new Insets(0, 0, 5, 0);
		gbc_btnBalanco.gridx = 1;
		gbc_btnBalanco.gridy = 1;
		panel.add(btnBalanco, gbc_btnBalanco);
		
		JButton btnClientes = new JButton("3 - Clientes");
		GridBagConstraints gbc_btnClientes = new GridBagConstraints();
		gbc_btnClientes.fill = GridBagConstraints.BOTH;
		gbc_btnClientes.insets = new Insets(0, 0, 0, 5);
		gbc_btnClientes.gridx = 0;
		gbc_btnClientes.gridy = 2;
		panel.add(btnClientes, gbc_btnClientes);
		
		JButton btnAgencias = new JButton("6 - Ag\u00EAncias");
		GridBagConstraints gbc_btnAgencias = new GridBagConstraints();
		gbc_btnAgencias.fill = GridBagConstraints.BOTH;
		gbc_btnAgencias.gridx = 1;
		gbc_btnAgencias.gridy = 2;
		panel.add(btnAgencias, gbc_btnAgencias);

		// setIconImage(Toolkit.getDefaultToolkit().getImage(
		// "./Imagens/Icone.png"));
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		// contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setLayout(new BorderLayout(0, 0));
		// setContentPane(contentPane);
	}

}
