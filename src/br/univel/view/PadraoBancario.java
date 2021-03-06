package br.univel.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.general.GetHorarioLocal;
import br.univel.model.FormatoData;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;

public class PadraoBancario extends JFrame {

	private JPanel contentPane;
	protected JLabel lblDataAcess;

	public JLabel getLblDataAcess() {
		return lblDataAcess;
	}

	protected void setLblDataAcess(String lblDataAcess) {
		this.lblDataAcess.setText(lblDataAcess);
	}

	public PadraoBancario() {
		setSize(553, 310);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("./Imagens/Icone.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 77, 103, 414, 0 };
		gbl_contentPane.rowHeights = new int[] { 89, 253, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
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
		gbl_cabecalho.rowHeights = new int[] { 62, 0, 26, 0 };
		gbl_cabecalho.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_cabecalho.rowWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		cabecalho.setLayout(gbl_cabecalho);

		JLabel lblBancoCentral = new JLabel("Banco Central");
		lblBancoCentral.setForeground(Color.DARK_GRAY);
		lblBancoCentral.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblBancoCentral = new GridBagConstraints();
		gbc_lblBancoCentral.fill = GridBagConstraints.BOTH;
		gbc_lblBancoCentral.insets = new Insets(0, 0, 5, 5);
		gbc_lblBancoCentral.gridx = 1;
		gbc_lblBancoCentral.gridy = 0;
		cabecalho.add(lblBancoCentral, gbc_lblBancoCentral);

		lblDataAcess = new JLabel("");
		lblDataAcess.setForeground(Color.DARK_GRAY);
		lblDataAcess.setText(new GetHorarioLocal().getHorarioLocal(FormatoData
				.getDtformattddmmyyyyhhmm()));
		GridBagConstraints gbc_lblDataAcess = new GridBagConstraints();
		gbc_lblDataAcess.anchor = GridBagConstraints.EAST;
		gbc_lblDataAcess.fill = GridBagConstraints.VERTICAL;
		gbc_lblDataAcess.insets = new Insets(0, 0, 5, 0);
		gbc_lblDataAcess.gridx = 2;
		gbc_lblDataAcess.gridy = 0;
		cabecalho.add(lblDataAcess, gbc_lblDataAcess);

		JLabel imagem = new JLabel("");
		imagem.setForeground(Color.LIGHT_GRAY);
		imagem.setIcon(new ImageIcon(PadraoCliente.class
				.getResource("/Imagem/Icone.png")));

		GridBagConstraints gbc_imagem = new GridBagConstraints();
		gbc_imagem.gridheight = 3;
		gbc_imagem.insets = new Insets(0, 0, 0, 5);
		gbc_imagem.gridx = 0;
		gbc_imagem.gridy = 0;
		cabecalho.add(imagem, gbc_imagem);

		JLabel lblFrase = new JLabel("Aqui seu dinheiro rende mais");
		lblFrase.setForeground(Color.DARK_GRAY);
		lblFrase.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblFrase = new GridBagConstraints();
		gbc_lblFrase.fill = GridBagConstraints.BOTH;
		gbc_lblFrase.insets = new Insets(0, 0, 0, 5);
		gbc_lblFrase.gridx = 1;
		gbc_lblFrase.gridy = 2;
		cabecalho.add(lblFrase, gbc_lblFrase);
	}

}
