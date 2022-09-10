package br.com.elo7.desafioprogramacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class InvalidCommandsAdvice {

  @ResponseBody
  @ExceptionHandler(InvalidCommandsException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  String InvalidCommandsHandler(InvalidCommandsException ex) {
    return ex.getMessage();
  }
}