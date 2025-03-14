package azarquiel.s2daw.foster.dao;

import azarquiel.s2daw.foster.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Short> {
}
