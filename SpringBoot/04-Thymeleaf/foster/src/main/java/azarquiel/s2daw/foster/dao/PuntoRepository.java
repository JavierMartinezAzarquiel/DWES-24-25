package azarquiel.s2daw.foster.dao;

import azarquiel.s2daw.foster.model.Punto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuntoRepository extends JpaRepository<Punto, Integer> {
}
