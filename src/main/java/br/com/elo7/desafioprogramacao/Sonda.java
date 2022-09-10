package br.com.elo7.desafioprogramacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "sondas")
@Entity
class Sonda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int[] posicao;
    @ManyToOne
    private Planeta planeta;
    
    private static final List<String> direcoes = new ArrayList<String>(Arrays.asList("Norte", "Leste", "Sul", "Oeste"));
    private int direcao;

    Sonda() {}
    
    Sonda(int[] posicaoPouso, Planeta planeta, String direcao) {
        this.posicao = posicaoPouso;
        this.planeta = planeta;
        this.direcao = direcoes.indexOf(direcao);
    }

    public Long getId() {
        return this.id;
    }
    
    public int[] getPosicao() {
        return this.posicao;
    }

    public Planeta getPlaneta() {
        return this.planeta;
    }
    
    public String getDirecao() {
        return direcoes.get(direcao);
    }
    
    public int mover(String comandos) {
        int[] posicaoTemp = posicao;
        for (char c : comandos.toCharArray()) {
            switch (c) {
                case 'M':
                    switch (direcao) {
                        case 0:
                            posicao[1]--;
                            break;
                        
                        case 1:
                            posicao[0]++;
                            break;
                        
                        case 2:
                            posicao[1]++;
                            break;

                        case 3:
                            posicao[0]--;
                            break;
                    }
                    break;
                
                case 'L':
                    direcao--;
                    if (direcao < 0) {direcao = 3;}
                    break;

                case 'R':
                    direcao++;
                    if (direcao > 3) {direcao = 0;}
                    break;

                default:
                    posicao = posicaoTemp;
                    return 1;
                }
        }
        
        return 0;
    }
}
