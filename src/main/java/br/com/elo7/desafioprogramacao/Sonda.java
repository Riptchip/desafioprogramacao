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
        return id;
    }
    
    public int[] getPosicao() {
        return posicao;
    }

    public Planeta getPlaneta() {
        return planeta;
    }
    
    public String getDirecao() {
        return direcoes.get(direcao);
    }
    
    public int mover(String comandos) {
        int[] posicaoTemp = posicao.clone();
        for (char c : comandos.toCharArray()) {
            switch (c) {
                case 'M':
                    int [] posicaoTemp2 = posicao.clone();
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

                    if (planeta.emExploracao(Arrays.toString(posicao))) {
                        posicao = posicaoTemp2;
                        atualizarPosicao(posicao, posicaoTemp);
                        return 2;
                    } else if (posicao[0] < 0 || posicao[0] >= planeta.getTamanho()[0] || posicao[1] < 0 || posicao[1] >= planeta.getTamanho()[1]) {
                        posicao = posicaoTemp2;
                        atualizarPosicao(posicao, posicaoTemp);
                        return 3;
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

        atualizarPosicao(posicao, posicaoTemp);

        return 0;
    }

    private void atualizarPosicao(int[] atual, int[] anterior) {
        planeta.novaExploracao(Arrays.toString(atual));
        planeta.finalizarExploracao(Arrays.toString(anterior));
    }
}
