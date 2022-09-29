package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Materia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RepoMateria {
    public void save(Materia m) throws MateriaRepetidaException;

    public List<Materia> all();

    public boolean existeMateriaDeNombre(String nombre);

    public Page<Materia> page(Pageable page);

    public Materia porNombre(String nombre);

    public List<Materia> porAnio(int anio);

}
