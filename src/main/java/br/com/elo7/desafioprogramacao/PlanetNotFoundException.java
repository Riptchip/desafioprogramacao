package br.com.elo7.desafioprogramacao;

class PlanetNotFoundException extends RuntimeException {

    PlanetNotFoundException() {
      super("Não há nenhum planeta ou não há um planeta com o id fornecido");
    }
  }