package br.com.elo7.desafioprogramacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class OutOfPlanetAdvice {

  @ResponseBody
  @ExceptionHandler(OutOfPlanetException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  String OutOfPlanetHandler(OutOfPlanetException ex) {
    return ex.getMessage();
  }
}