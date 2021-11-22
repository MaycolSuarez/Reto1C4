package co.usa.edu.ciclo4.reto1.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.edu.ciclo4.reto1.model.User;
import co.usa.edu.ciclo4.reto1.repository.crud.CrudRepositoryUser;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryUser {
    @Autowired
    private CrudRepositoryUser crudRepositoryUser;

    public List<User> getAll() {
        return (List<User>) crudRepositoryUser.findAll();
    }

    public Optional<User> getUser(int id) {
        return crudRepositoryUser.findById(id);
    }

    public User save(User user) {
        return crudRepositoryUser.save(user);
    }

    public boolean existeEmail(String email) {
        Optional<User> usuario = crudRepositoryUser.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> autenticarUsuario(String email, String password) {
        return crudRepositoryUser.findByEmailAndPassword(email, password);
    }
}
