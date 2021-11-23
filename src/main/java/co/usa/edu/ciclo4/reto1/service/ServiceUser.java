package co.usa.edu.ciclo4.reto1.service;

import java.util.List;
import java.util.Optional;

import co.usa.edu.ciclo4.reto1.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.edu.ciclo4.reto1.model.User;

@Service
public class ServiceUser {
    @Autowired
    private RepositoryUser repositoryUser;

    public List<User> getAll() {
        return repositoryUser.getAll();
    }

    public Optional<User> getUser(int id) {
        return repositoryUser.getUser(id);
    }

    public User registrar(User user) {
        // // Verificar si el Id viene Null
        // if (user.getId() == null) {
        //     return repositoryUser.save(user);
        // } else {// Verifico si el Id existe e nl base de DAtos
        //     Optional<User> consulta = repositoryUser.getUser(user.getId());
        //     if (consulta.isEmpty()) {
        //         return repositoryUser.save(user);
        //     } else {
        //         return user;
        //     }
        // }


        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return repositoryUser.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existeEmail(String email) {
        return repositoryUser.existeEmail(email);
    }

    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = repositoryUser.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            //throw new Error();
            return new User(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
}
