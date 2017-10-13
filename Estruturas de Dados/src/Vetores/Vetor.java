package Vetores;

import java.util.Arrays;

public class Vetor {
	
	private String[] elementos;
	private int tamanho;
	
	public Vetor(int capacidade) {
		this.elementos = new String[capacidade];
		this.tamanho = 0;
	}
	
	/*
	 * M�todo ineficiente para adicionar elementos no Vetor
	 * 
	public void adiciona(String elemento) {
		for (int i=0; i<this.elementos.length; i++) {
			if (this.elementos[i] == null) {
				this.elementos[i] = elemento;
				break;
			}
		}
	}
	*
	*/
	
	/*
	 * (Op��o 1) Adicionar elemento eficientemente
	public void adiciona(String elemento) throws Exception {
		
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
		} else {
			throw new Exception("Vetor j� est� cheio! N�o � poss�vel adicionar elementos!");
		}
		
	}
	
	*/
	
	/* (Op��o 2) Adicionar elemento eficientemente */
	
	public boolean adiciona(String elemento) {
	 
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
	  		return true;
	  	} else {
	  		return false;
	  	}	
	 }
	
	public int tamanho() {
		return this.tamanho;
	}

	@Override
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		s.append("[");
		
		for (int i=0; i<this.tamanho-1; i++) {
			s.append(this.elementos[i]);
			s.append(", ");
		}
		
		if (this.tamanho > 0) {
			s.append(this.elementos[this.tamanho-1]);
		}
		
		s.append("]");
		
		return s.toString();
	}
	
	
}
