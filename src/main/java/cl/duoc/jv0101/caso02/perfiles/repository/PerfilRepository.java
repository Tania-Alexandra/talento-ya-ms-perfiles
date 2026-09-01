package cl.duoc.jv0101.caso02.perfiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.jv0101.caso02.perfiles.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
