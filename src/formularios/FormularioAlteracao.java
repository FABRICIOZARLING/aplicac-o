package formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controladores.Acao;
import controladores.Produto;


public class FormularioAlteracao {

	// JFrame
	public FormularioAlteracao(int codigo) {
		Acao a = new Acao();
		Produto p =new Produto();
		// JFrame
		JFrame formulario = new JFrame("Mini Sistema");
		formulario.setSize(320,270);
		formulario.setDefaultCloseOperation(formulario.EXIT_ON_CLOSE);
		formulario.setLocationRelativeTo(null);
		formulario.setLayout(null);
	
		JLabel produto = new JLabel("Produto");
		produto.setBounds(30, 30, 100, 20);
		
		JLabel valor = new JLabel("Valor");
		valor.setBounds(30, 60, 100, 20);

		JLabel quantidade = new JLabel("Quantidade");
		quantidade.setBounds(30, 90, 100, 20); 
		
		
		JTextField c_produto = new JTextField(p.getDados().get(codigo).getProduto());
		c_produto .setBounds(130, 30, 140, 20);
		
		JTextField c_valor = new JTextField(""+p.getDados().get(codigo).getValor());
		c_valor .setBounds(130, 60, 140, 20);
		
		JTextField c_quantidade = new JTextField(""+p.getDados().get(codigo).getQuantidade());
		c_quantidade .setBounds(130, 90, 140, 20);
		
		JButton alterar = new JButton("Alterar");
		alterar.setBounds(30, 120, 120, 20);
		
		JButton excluir = new JButton("Excluir");
		excluir.setBounds(150, 120, 120, 20);
		
		alterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				formulario.dispose();
				a.alterar(c_produto.getText(), c_valor.getText(), c_quantidade.getText(), codigo);
				FormularioPrincipal fp = new FormularioPrincipal();
				
			}
		});
		
		excluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				formulario.dispose();
				a.excluir(codigo);
				FormularioPrincipal fp = new FormularioPrincipal();
				
			}
		});
		
		
		
		formulario.add(produto);
		formulario.add(valor);
		formulario.add(quantidade);
		formulario.add(c_produto);
		formulario.add(c_valor);
		formulario.add(c_quantidade);
		formulario.add(alterar);
		formulario.add(excluir);

		
		// Exibir formulário
		formulario.setVisible(true);
	}

}
