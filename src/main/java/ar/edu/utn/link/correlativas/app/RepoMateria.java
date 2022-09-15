package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import java.util.List;

public interface RepoMateria {
    void save(Materia m);

    List<Materia> all();

    Materia porNombre(String nombre);
}
