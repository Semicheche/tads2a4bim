package br.unive.cadastro.model;

public enum Uf {
	
	PR("Paraná"), //
	SP("São paulo"),//
	SC("Santa Catarina");//
	
	private Uf(String nome) {
		this.nome = nome;
	}

	private String nome;
	
	public String getNome(){
		return nome;
	}

}
