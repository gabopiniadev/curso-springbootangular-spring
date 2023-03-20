package com.curso.springboot.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.springboot.Models.Usuario;


@Controller
@RequestMapping(value = "/app")
public class IndexController {

    @GetMapping(value = {"/", "/index", "/home"})
    public String index(Model model) {

        model.addAttribute("titulo", "Bienvenidos al Curso de Spring Framework con moodel");

        return "index";
        
    }

    @RequestMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Gabriel");
        usuario.setApellido("Pina");
        usuario.setEmail("");
        
        model.addAttribute("usuario", usuario);
        model.addAttribute("email", usuario.getEmail());
        model.addAttribute("titulo", "Perfil del Usuario:".concat(usuario.getNombre()));
        
        return "perfil";
    }

    @RequestMapping("listar")
    public String listar(Model model) {

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Gabriel", "Pina", "gabrielpinia@hotmail.com"));
        usuarios.add(new Usuario("Alejandro", "Gonzales", "alejandrog@gmail.com"));
        usuarios.add(new Usuario("Jose", "Perez", "pjose@gmail.com"));
        usuarios.add(new Usuario("Luis", "Garcia", "lgarcia@gmail.com"));
        
        model.addAttribute("titulo", "Listado de Usuarios");
        model.addAttribute("usuarios", usuarios);
        
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuario(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Gabriel", "Pina", "gabrielpinia@hotmail.com"));
        usuarios.add(new Usuario("Alejandro", "Gonzales", "alejandrog@gmail.com"));
        usuarios.add(new Usuario("Jose", "Perez", "pjose@gmail.com"));
        usuarios.add(new Usuario("Luis", "Garcia", "lgarcia@gmail.com"));

        return usuarios;
    }
    
}
