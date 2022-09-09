package br.com.elo7.desafioprogramacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class PlanetNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(PlanetNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String PlanetNotFoundHandler(PlanetNotFoundException ex) {
    return ex.getMessage();
  }
}