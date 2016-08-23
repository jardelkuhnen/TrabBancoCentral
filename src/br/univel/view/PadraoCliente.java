package br.univel.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PadraoCliente extends JFrame {

	private JPanel contentPane;
	protected JLabel lblDataAcess;

	public JLabel getLblDataAcess() {
		return lblDataAcess;
	}

	protected void setLblDataAcess(String lblDataAcess) {
		this.lblDataAcess.setText(lblDataAcess);
	}

	public PadraoCliente() {
		setResizable(false);
		setSize(800, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 77, 414, 0 };
		gbl_contentPane.rowHeights = new int[] { 89, 253, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel cabecalho = new JPanel();
		cabecalho.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		GridBagConstraints gbc_cabecalho = new GridBagConstraints();
		gbc_cabecalho.gridwidth = 2;
		gbc_cabecalho.fill = GridBagConstraints.BOTH;
		gbc_cabecalho.insets = new Insets(0, 0, 5, 0);
		gbc_cabecalho.gridx = 0;
		gbc_cabecalho.gridy = 0;
		contentPane.add(cabecalho, gbc_cabecalho);
		GridBagLayout gbl_cabecalho = new GridBagLayout();
		gbl_cabecalho.columnWidths = new int[] { 94, 208, 90, 0 };
		gbl_cabecalho.rowHeights = new int[] { 26, 26, 0 };
		gbl_cabecalho.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_cabecalho.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		cabecalho.setLayout(gbl_cabecalho);

		JLabel lblBancoCentral = new JLabel("Banco Central");
		lblBancoCentral.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblBancoCentral = new GridBagConstraints();
		gbc_lblBancoCentral.fill = GridBagConstraints.BOTH;
		gbc_lblBancoCentral.insets = new Insets(0, 0, 5, 5);
		gbc_lblBancoCentral.gridx = 1;
		gbc_lblBancoCentral.gridy = 0;
		cabecalho.add(lblBancoCentral, gbc_lblBancoCentral);

		lblDataAcess = new JLabel("");
		lblDataAcess.setText(getHorarioLocal());
		GridBagConstraints gbc_lblDataAcess = new GridBagConstraints();
		gbc_lblDataAcess.anchor = GridBagConstraints.EAST;
		gbc_lblDataAcess.fill = GridBagConstraints.VERTICAL;
		gbc_lblDataAcess.insets = new Insets(0, 0, 5, 0);
		gbc_lblDataAcess.gridx = 2;
		gbc_lblDataAcess.gridy = 0;
		cabecalho.add(lblDataAcess, gbc_lblDataAcess);

		JLabel imagem = new JLabel("");
		imagem.setIcon(new ImageIcon("D:\\workspace\\TrabBancoCentral\\Imagens\\Icone.png"));
		GridBagConstraints gbc_imagem = new GridBagConstraints();
		gbc_imagem.gridheight = 2;
		gbc_imagem.insets = new Insets(0, 0, 0, 5);
		gbc_imagem.gridx = 0;
		gbc_imagem.gridy = 0;
		cabecalho.add(imagem, gbc_imagem);

		JLabel lblFrase = new JLabel("Aqui seu dinheiro rende mais");
		lblFrase.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblFrase = new GridBagConstraints();
		gbc_lblFrase.fill = GridBagConstraints.BOTH;
		gbc_lblFrase.insets = new Insets(0, 0, 0, 5);
		gbc_lblFrase.gridx = 1;
		gbc_lblFrase.gridy = 1;
		cabecalho.add(lblFrase, gbc_lblFrase);
	}

	protected String getHorarioLocal() {
		return new SimpleDateFormat("dd/MM/yyyy  hh:mm").format(new Date());
	}
}
