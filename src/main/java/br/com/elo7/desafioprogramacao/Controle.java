package br.com.elo7.desafioprogramacao;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Controle {

    private final RepositorioSonda sondaRepo;
    private final RepositorioPlaneta planetaRepo;

    Controle(RepositorioSonda sondaRepo, RepositorioPlaneta planetaRepo) {
      this.sondaRepo = sondaRepo;
      this.planetaRepo = planetaRepo;
    }
    
    @PostMapping("/planeta")
    Planeta criarPlaneta(@RequestParam(value = "x") int x, @RequestParam(value ="y") int y){
        return planetaRepo.save(new Planeta(x, y));
    }
    
    @GetMapping("/sonda")
    List<Sonda> todas() {
        return sondaRepo.findAll();
    }
    
    @PostMapping("/sonda")
    Sonda pousarSonda(@RequestParam(value = "x") int x, @RequestParam(value = "y") int y, @RequestParam(value = "planetaId", defaultValue = "0") long planetaId, @RequestParam(value = "direcao") String direcao) {
        Planeta planeta;

        if (planetaId == 0) {
            planeta = planetaRepo.findAllByOrderByIdDesc().get(0);
        } else {
            planeta = planetaRepo.findById(planetaId)
            .orElseThrow(() -> new PlanetNotFoundException());
        }

        return sondaRepo.save(new Sonda(new int[]{x, y}, planeta, direcao));
    }
    
    @PutMapping("/sonda/{id}")
    Sonda movimentarSonda(@PathVariable Long id, @RequestParam(value = "comandos") String comandos) {
        Sonda sonda = sondaRepo.findById(id)
            .orElseThrow(() -> new ProbeNotFoundException());

        sonda.mover(comandos);

        return sonda;
    }
}
