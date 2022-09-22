package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RepoMateria {
    void save(Materia m);

    public List<Materia> all();

    public Page<Materia> page(Pageable page);

    public Materia porNombre(String nombre);

    public List<Materia> porAnio(int anio);

}
