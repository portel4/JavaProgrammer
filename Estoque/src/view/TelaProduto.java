package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import model.Produto;

public class TelaProduto extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfQtde;
	private JTextField tfValor;

	/**
	 * Create the frame.
	 */
	public TelaProduto() {
		
		setTitle("Sistema de Controle de Estoque");
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnTitulo = new JPanel();
		pnTitulo.setBackground(Color.LIGHT_GRAY);
		pnTitulo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.add(pnTitulo, BorderLayout.NORTH);
		
		JLabel lbTitulo = new JLabel("Cadastro de Produtos");
		lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		pnTitulo.add(lbTitulo);
		
		JPanel pnCentral = new JPanel();
		pnCentral.setBackground(SystemColor.menu);
		contentPane.add(pnCentral, BorderLayout.CENTER);
		pnCentral.setLayout(null);
		
		JLabel lbCodigo = new JLabel("C\u00F3digo:");
		lbCodigo.setBounds(70, 57, 46, 14);
		pnCentral.add(lbCodigo);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(126, 54, 57, 20);
		pnCentral.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setBounds(74, 95, 38, 14);
		pnCentral.add(lbNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(126, 92, 392, 20);
		pnCentral.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lbQtde = new JLabel("Quantidade:");
		lbQtde.setBounds(48, 139, 78, 14);
		pnCentral.add(lbQtde);
		
		tfQtde = new JTextField();
		tfQtde.setBounds(126, 136, 86, 20);
		pnCentral.add(tfQtde);
		tfQtde.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Valor:");
		lblNewLabel.setBounds(74, 176, 38, 14);
		pnCentral.add(lblNewLabel);
		
		tfValor = new JTextField();
		tfValor.setBounds(126, 173, 124, 20);
		pnCentral.add(tfValor);
		tfValor.setColumns(10);
		
		JPanel pnRodape = new JPanel();
		pnRodape.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(pnRodape, BorderLayout.SOUTH);
		pnRodape.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaTela();
			}
		});
		
		JButton btListar = new JButton("Listar");
		btListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaProdutos();
			}
		});
		pnRodape.add(btListar);
		pnRodape.add(btLimpar);
		
		JButton btGravar = new JButton("Gravar");
		
		btGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gravaProduto();
			}
		});
		
		pnRodape.add(btGravar);
	}
	
	private void gravaProduto() {
		int codigo = Integer.parseInt(tfCodigo.getText());
		String nome = tfNome.getText();
		int qtde = Integer.parseInt(tfQtde.getText());
		double valor = Double.parseDouble(tfValor.getText());
		new Produto(codigo,nome,qtde,valor).gravar();
		limpaTela();
	}
	
	private void limpaTela() {
		tfCodigo.setText("");
		tfNome.setText("");
		tfQtde.setText("");
		tfValor.setText("");
		tfCodigo.requestFocus();
	}
	
	private void listaProdutos() {
		Produto.getLista().forEach(e -> System.out.println(e));		
	}
}
