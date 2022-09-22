package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RepoAlumno {
    public void save(Alumno a) throws AlumnoRepetidoException;

    public List<Alumno> all();

    public boolean existeAlumnoDeNombre(String nombre);

    public Page<Alumno> page(Pageable page);

    public Alumno porNombre(String nombre);
}
