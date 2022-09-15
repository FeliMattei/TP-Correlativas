package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriasController {

    @Autowired
    RepoMateria repo;

    @GetMapping(path={"","/"})
    public List<Materia> materias(){
        return repo.all();
    }

    @GetMapping("/{nombre}")
    public Materia materia(@PathVariable("nombre") String nombre){
        return repo.porNombre(nombre);
    }
}
