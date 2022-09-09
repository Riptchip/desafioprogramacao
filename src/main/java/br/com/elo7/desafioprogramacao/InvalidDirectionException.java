package br.com.elo7.desafioprogramacao;

class InvalidDirectionException extends RuntimeException {

    InvalidDirectionException() {
      super("A direção precisa ser 'Norte', 'Sul', 'Leste' ou 'Oeste'");
    }
  }