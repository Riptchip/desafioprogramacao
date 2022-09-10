package br.com.elo7.desafioprogramacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "planetas")
@Entity
class Planeta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
