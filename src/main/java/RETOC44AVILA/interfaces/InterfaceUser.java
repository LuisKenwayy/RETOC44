/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RETOC44AVILA.interfaces;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

import RETOC44AVILA.modelo.User;

/**
 *
 * @author Luis Kenway
 */
public interface InterfaceUser extends MongoRepository<User, Integer> {
    
    Optional<User> findByEmail(String email);
    
    Optional<User> findByEmailAndPassword(String email,String password);
    
     //Para seleccionar el Luis Kenway con el id maximo
    Optional<User> findTopByOrderByIdDesc();
}
