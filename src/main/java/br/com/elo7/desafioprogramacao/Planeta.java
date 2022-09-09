package br.com.elo7.desafioprogramacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Planeta {
    
    private @Id @GeneratedValue Long id;
    private int[] tamanho;

    Planeta() {}

    Planeta(int x, int y) {
        this.tamanho = new int[]{x, y};
    }

    public Long getId() {
        return this.id;
    }
    
    public int[] getTamanho() {
        return this.tamanho;
    }
}
