package co.usa.edu.ciclo4.reto1.repository.crud;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;

import co.usa.edu.ciclo4.reto1.model.User;

public interface CrudRepositoryUser extends CrudRepository<User, Integer> {

        //query methods
        Optional<User> findByEmail(String email);
        Optional<User> findByEmailAndPassword(String email,String password);
}
