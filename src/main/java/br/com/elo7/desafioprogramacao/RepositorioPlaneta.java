package br.com.elo7.desafioprogramacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface RepositorioPlaneta extends JpaRepository<Planeta, Long> {
    List<Planeta> findAllByOrderByIdDesc();
}
