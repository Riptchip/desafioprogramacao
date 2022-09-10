package br.com.elo7.desafioprogramacao;

class InvalidCommandsException extends RuntimeException {

    InvalidCommandsException() {
      super("Os comandos precisam estar em sequência todos em maiúsculo. Os comandos são:\n'M': Andar para a frente na direção que está 1 posição.\n'L': Virar a sonda para a esquerda (90 graus).\n'R': Virar a sonda para a direita (90 graus).");
    }
  }