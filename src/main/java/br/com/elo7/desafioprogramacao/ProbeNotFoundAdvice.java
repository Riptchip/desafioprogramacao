package br.com.elo7.desafioprogramacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ProbeNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(ProbeNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String ProbeNotFoundHandler(ProbeNotFoundException ex) {
    return ex.getMessage();
  }
}