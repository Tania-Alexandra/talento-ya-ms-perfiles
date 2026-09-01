package cl.duoc.jv0101.caso02.perfiles.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import cl.duoc.jv0101.caso02.perfiles.model.Perfil;
import cl.duoc.jv0101.caso02.perfiles.repository.PerfilRepository;

@Service
public class PerfilService {

    private final PerfilRepository repository;

    public PerfilService(PerfilRepository repository) {
        this.repository = repository;
    }

    public List<Perfil> findAll() {
        return repository.findAll();
    }

    public Optional<Perfil> findById(Long id) {
        return repository.findById(id);
    }

    public Perfil create(Perfil recurso) {
        return repository.save(recurso);
    }

    public Optional<Perfil> update(Long id, Perfil datos) {
        return repository.findById(id).map(existente -> {
            existente.setNombre(datos.getNombre());
            existente.setEmail(datos.getEmail());
            existente.setProfesion(datos.getProfesion());
            return repository.save(existente);
        });
    }

    public boolean delete(Long id) {
        return repository.findById(id).map(existente -> {
            repository.delete(existente);
            return true;
        }).orElse(false);
    }
}
