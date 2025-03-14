package azarquiel.s2daw.foster.dao;

import azarquiel.s2daw.foster.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Short> {
}
