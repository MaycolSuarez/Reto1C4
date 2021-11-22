package co.usa.edu.ciclo4.reto1.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import co.usa.edu.ciclo4.reto1.model.User;
import co.usa.edu.ciclo4.reto1.service.ServiceUser;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
    RequestMethod.PUT })

public class ControllerUser {

    @Autowired
    private ServiceUser serviceUser;

    @GetMapping("/all")
    public List<User> getAll() {
        return serviceUser.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user) {
        return serviceUser.registrar(user);
    }

    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return serviceUser.autenticarUsuario(email, password);
    }

    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return serviceUser.existeEmail(email);
    }
}
