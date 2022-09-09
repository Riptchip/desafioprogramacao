package br.com.elo7.desafioprogramacao;

class ProbeNotFoundException extends RuntimeException {

    ProbeNotFoundException() {
      super("Não há uma sonda com o id fornecido");
    }
  }