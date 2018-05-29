package controladores;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import formularios.FormularioPrincipal;

public class Acao {
	Produto p = new Produto();
	//FormularioPrincipal fp = new FormularioPrincipal();
	
	public int cadastrar(String nome, String v, String q) {
		
		if(!nome.equals("")&&!v.equals("")&&!q.equals("")) {
			try {
				double valor = Double.parseDouble(v);
				try {
					int quantidade= Integer.parseInt(q);
					p.setProduto(nome);
					p.setQuantidade(quantidade);
					p.setValor(valor);
					p.setDados(p);
					
				
					
				} catch (Exception e) {
					alerta("inválidos. Quantidade: "+q);
					
				}
			} catch (Exception e) {
				alerta("inválidos. Valor: "+v);
				
			}
			
		}else {
			alerta("incompletos");
		}	
		int linha = p.getDados().size();
		return linha;
	}
	
	public void alterar(String nome, String v, String q, int codigo) {
		if(!nome.equals("")&&!v.equals("")&&!q.equals("")) {
			try {
				double valor = Double.parseDouble(v);
				try {
					int quantidade= Integer.parseInt(q);
					ArrayList<Produto> produtos = p.getDados();
					p.setProduto(nome);
					p.setQuantidade(quantidade);
					p.setValor(valor);
					produtos.set(codigo, p);
					p.setDadosatualizados(produtos);
				
					
				} catch (Exception e) {
					alerta("inválidos. Quantidade: "+q);
					
				}
			} catch (Exception e) {
				alerta("inválidos. Valor: "+v);
				
			}
			
		}else {
			alerta("incompletos");
		}		
	}
	
	public void excluir(int codigo) {
		ArrayList<Produto> produtos = p.getDados();
		System.out.println(codigo+" e "+produtos.size());
		for(int x = codigo; x<produtos.size()-1; x++) {
			p.setProduto(produtos.get(x+1).getProduto());
			p.setQuantidade(produtos.get(x+1).getQuantidade());
			p.setValor(produtos.get(x+1).getValor());
			produtos.set(x, p);

		}
		produtos.remove(produtos.size()-1);
		p.setDadosatualizados(produtos);
		
	}
	
	
	
	private void alerta(String texto) {
		JOptionPane.showMessageDialog(null, "Dados "+texto);
	}

}
