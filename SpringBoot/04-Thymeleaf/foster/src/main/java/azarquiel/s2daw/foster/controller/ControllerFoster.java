package azarquiel.s2daw.foster.controller;

import azarquiel.s2daw.foster.dao.CategoriaRepository;
import azarquiel.s2daw.foster.dao.ProductoRepository;
import azarquiel.s2daw.foster.dao.PuntoRepository;
import azarquiel.s2daw.foster.model.Categoria;
import azarquiel.s2daw.foster.model.Punto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes({"categorias","productos","categoriaseleccionada"})
public class ControllerFoster {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private PuntoRepository puntoRepository;


    @GetMapping("/inicio")
    public String inicio(Model modelo) {
        List<Categoria> lista = categoriaRepository.findAll();
        modelo.addAttribute("categorias",lista);
        modelo.addAttribute("productos",null);
        modelo.addAttribute("categoriaseleccionada",null);
        return "home";
    }

    @GetMapping("/obtenerplatos/{id}")
    public String obtenerplatos(@PathVariable Short id, Model modelo) {
        //mandamos la categoría seleccionada
        modelo.addAttribute("categoriaseleccionada", categoriaRepository.findById(id).get());
        //obtener los platos de la categoria que piden
        modelo.addAttribute("productos", categoriaRepository.findById(id).get().getProductos());
        return "home";
    }

    @GetMapping("/rating/{id}/{puntos}")
    public String rating(@PathVariable Short id, @PathVariable Short puntos, Model modelo) {
        //anotar los puntos
        Punto p = new Punto();
        p.setId(0);
        p.setPuntos(puntos);
        p.setIdproducto(productoRepository.findById(id).get());
        puntoRepository.save(p);
        modelo.addAttribute("msg","Anotados "+puntos+" puntos a "+id);
        return "home";
    }
}
