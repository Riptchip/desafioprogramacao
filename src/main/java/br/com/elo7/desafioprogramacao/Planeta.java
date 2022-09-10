package br.com.elo7.desafioprogramacao;

import java.util.List;

import javax.persistence.ElementCollection;
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
    @ElementCollection
    private List<String> coordenadasEmExploracao;
    
    Planeta() {}

    Planeta(int x, int y) {
        this.tamanho = new int[]{x, y};
    }

    public List<String> getCoords() {
        return coordenadasEmExploracao;
    }

    public Long getId() {
        return this.id;
    }
    
    public int[] getTamanho() {
        return this.tamanho;
    }

    public boolean novaExploracao(String coordenadas) {
        return coordenadasEmExploracao.add(coordenadas);
    }

    public boolean finalizarExploracao(String coordenadas) {
        return coordenadasEmExploracao.remove(coordenadas);
    }

    public boolean emExploracao(String coordenadas) {
        return coordenadasEmExploracao.contains(coordenadas);
    }
}
