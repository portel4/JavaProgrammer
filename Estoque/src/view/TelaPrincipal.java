package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		initComponents();
		setTitle("Sistema de Controle de Estoque");
		setLocationRelativeTo(null);
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnTitulo = new JPanel();
		pnTitulo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnTitulo.setBackground(Color.LIGHT_GRAY);
		contentPane.add(pnTitulo, BorderLayout.NORTH);
		
		JLabel lbSistemaDeControle = new JLabel("Sistema de Controle de Estoque");
		lbSistemaDeControle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		pnTitulo.add(lbSistemaDeControle);
		
		JPanel pnCentral = new JPanel();
		contentPane.add(pnCentral, BorderLayout.CENTER);
		SpringLayout sl_pnCentral = new SpringLayout();
		pnCentral.setLayout(sl_pnCentral);
		
		JButton btProduto = new JButton("");
		btProduto.setBorder(null);
		btProduto.setContentAreaFilled(false);
		btProduto.setBorderPainted(false);
		btProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaProduto();
			}
		});
		sl_pnCentral.putConstraint(SpringLayout.NORTH, btProduto, 25, SpringLayout.NORTH, pnCentral);
		sl_pnCentral.putConstraint(SpringLayout.WEST, btProduto, 28, SpringLayout.WEST, pnCentral);
		sl_pnCentral.putConstraint(SpringLayout.SOUTH, btProduto, 146, SpringLayout.NORTH, pnCentral);
		sl_pnCentral.putConstraint(SpringLayout.EAST, btProduto, 176, SpringLayout.WEST, pnCentral);
		btProduto.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/btProduto.png")));
		pnCentral.add(btProduto);
		
		JLabel lbCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		sl_pnCentral.putConstraint(SpringLayout.NORTH, lbCadastroDeProdutos, 6, SpringLayout.SOUTH, btProduto);
		sl_pnCentral.putConstraint(SpringLayout.WEST, lbCadastroDeProdutos, 52, SpringLayout.WEST, pnCentral);
		pnCentral.add(lbCadastroDeProdutos);
		
		JButton btnFornecedor = new JButton("");
		btnFornecedor.setContentAreaFilled(false);
		btnFornecedor.setBorderPainted(false);
		sl_pnCentral.putConstraint(SpringLayout.NORTH, btnFornecedor, 25, SpringLayout.NORTH, pnCentral);
		sl_pnCentral.putConstraint(SpringLayout.WEST, btnFornecedor, 72, SpringLayout.EAST, btProduto);
		sl_pnCentral.putConstraint(SpringLayout.SOUTH, btnFornecedor, 146, SpringLayout.NORTH, pnCentral);
		btnFornecedor.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/btFornecedor.png")));
		btnFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaFornecedor();
			}
		});
		pnCentral.add(btnFornecedor);
		
		JLabel lbCadastroDeFornecedores = new JLabel("Cadastro de Fornecedores");
		sl_pnCentral.putConstraint(SpringLayout.NORTH, lbCadastroDeFornecedores, 0, SpringLayout.NORTH, lbCadastroDeProdutos);
		sl_pnCentral.putConstraint(SpringLayout.WEST, lbCadastroDeFornecedores, 113, SpringLayout.EAST, lbCadastroDeProdutos);
		pnCentral.add(lbCadastroDeFornecedores);
	}
	
	private void telaProduto() {
		new TelaProduto().setVisible(true);
	}
	
	private void telaFornecedor() {
		new TelaFornecedor().setVisible(true);
	}

}
