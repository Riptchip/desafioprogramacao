package br.com.elo7.desafioprogramacao;

class OutOfPlanetException extends RuntimeException {

    OutOfPlanetException(int x, int y, String direcao) {
      super("Os comandos passados levam a sonda para fora do planeta, portando parou uma posição antes de sair em x=" + x + " e y=" + y + " apontando para " + direcao + ".");
    }
  }