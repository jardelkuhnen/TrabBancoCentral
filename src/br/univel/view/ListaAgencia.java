package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaAgencia extends PadraoBancario {

	private JPanel contentPane;

	public ListaAgencia() {
		super();
		GridBagLayout gridBagLayout = (GridBagLayout) getContentPane()
				.getLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0 };
		setTitle("Agências");

		JPanel corpo = new JPanel();
		corpo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(corpo, gbc_panel);
		GridBagLayout gbl_corpo = new GridBagLayout();
		gbl_corpo.columnWidths = new int[] { 0, 0 };
		gbl_corpo.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };
		gbl_corpo.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_corpo.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		corpo.setLayout(gbl_corpo);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panell = new GridBagConstraints();
		gbc_panell.fill = GridBagConstraints.BOTH;
		gbc_panell.gridx = 0;
		gbc_panell.gridy = 11;
		corpo.add(panel, gbc_panell);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.setBounds(436, 0, 72, 30);
		panel.add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(359, 0, 72, 30);
		panel.add(btnEdit);

	}
}
