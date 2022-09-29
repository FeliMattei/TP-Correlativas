package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/materias")
public class MateriasController {

    @Autowired
    RepoMateria repo;

    @GetMapping(path={"","/"})
    public Page<Materia> materias(Pageable page, @RequestParam(value = "anio", required = false) Integer anio){
        //return repo.all();
        if (anio != null) {
            return new PageImpl<Materia>(repo.porAnio(anio));
        } else {
            return repo.page(page);
        }
    }

    @GetMapping("/{nombre}")
    public Materia materia(@PathVariable("nombre") String nombre){
        return repo.porNombre(nombre);
    }

    @PostMapping("/")
    public String alta(@RequestBody @Valid Materia materia, BindingResult bindingResult) throws MateriaRepetidaException {
        if(bindingResult.hasErrors()){
            return "No está OK";
        } else {
            repo.save(materia);
            return "Materia cargado.";
        }
    }
}
