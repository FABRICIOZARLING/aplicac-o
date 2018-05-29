package formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controladores.Acao;
import controladores.Produto;

public class FormularioPrincipal {
	
	public FormularioPrincipal() {
		Acao a = new Acao();
		Produto p =new Produto();
		// JFrame
		JFrame formulario = new JFrame("Mini Sistema");
		formulario.setSize(320, 480);
		formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		formulario.setLocationRelativeTo(null);
		formulario.setLayout(null);
		
		
		JLabel produto = new JLabel("Produto");
		produto.setBounds(30, 30, 100, 20);
		
		JLabel valor = new JLabel("Valor");
		valor.setBounds(30, 60, 100, 20);

		JLabel quantidade = new JLabel("Quantidade");
		quantidade.setBounds(30, 90, 100, 20); 
		
		
		JTextField c_produto = new JTextField();
		c_produto .setBounds(130, 30, 140, 20);
		
		JTextField c_valor = new JTextField();
		c_valor .setBounds(130, 60, 140, 20);
		
		JTextField c_quantidade = new JTextField();
		c_quantidade .setBounds(130, 90, 140, 20);
			
		
		// DefaultTableModel - Serve para agrupar os dados
		DefaultTableModel exibirDados = new DefaultTableModel();
		
		//Criar colunas
		exibirDados.addColumn("Produto");
		exibirDados.addColumn("Valor");
		exibirDados.addColumn("Quantidade");
		
	
		JTable tabela = new JTable(exibirDados);
		
		// JScrollPane - Barra de rolagem englobando o JTable
		JScrollPane barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(20, 170, 260, 100);
		
		ArrayList<Produto> produtos = p.getDados();
    	for(int i = exibirDados.getRowCount(); i<produtos.size(); i++) {
			//String [] dados = produtos.get(i);
			exibirDados.addRow(new Object[]{produtos.get(i).getProduto(),String.format("%.2f", produtos.get(i).getValor()), produtos.get(i).getQuantidade() });
			//agrupar += "Nome "+dados.get(i).nome+"\n";

		}		


		JButton acao = new JButton("Cadastrar");
		acao.setBounds(30, 120, 240, 20);
		acao.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = a.cadastrar(c_produto.getText(), c_valor.getText(), c_quantidade.getText());
				if(i==exibirDados.getRowCount()+1) {
					i--;
					exibirDados.insertRow(i, new Object[]{produtos.get(i).getProduto(),String.format("%.2f", produtos.get(i).getValor()), produtos.get(i).getQuantidade() });
				}

			}
		});
	
		tabela.addMouseListener(new MouseAdapter(){
            @Override  
            public void mouseClicked(MouseEvent e) {  
            	FormularioAlteracao fa = new FormularioAlteracao(tabela.getSelectedRow());
                formulario.dispose();
            }  
        });
		
		
		
		// Adicionar elementos ao formulário
		
		formulario.add(produto);
		formulario.add(valor);
		formulario.add(quantidade);
		formulario.add(c_produto);
		formulario.add(c_valor);
		formulario.add(c_quantidade);
		formulario.add(acao);
		formulario.add(barraRolagem);
		
		// Exibir formulário
		formulario.setVisible(true);
	
		
	}
	
}
