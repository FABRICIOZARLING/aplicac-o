package controladores;

import java.util.ArrayList;

public class Produto {
	private String Produto;
	private double valor;
	private int quantidade;
	static ArrayList<Produto> dados = new ArrayList<>();
	public String getProduto() {
		return Produto;
	}
	public void setProduto(String produto) {
		Produto = produto;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public ArrayList<Produto> getDados() {
		return dados;
	}
	public void setDadosatualizados(ArrayList<Produto> dados) {
		this.dados = dados;
	}
	public void setDados(Produto p) {
		dados.add(p);
	}
	

}
