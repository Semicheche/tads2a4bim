package br.unive.cadastro.model;

public enum Uf {
	
	PR("Paran�"), //
	SP("S�o paulo"),//
	SC("Santa Catarina");//
	
	private Uf(String nome) {
		this.nome = nome;
	}

	private String nome;
	
	public String getNome(){
		return nome;
	}

}
