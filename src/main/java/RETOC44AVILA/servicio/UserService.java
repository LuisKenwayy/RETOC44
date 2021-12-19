/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RETOC44AVILA.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RETOC44AVILA.modelo.User;
import RETOC44AVILA.repositorio.UserRepositorio;

/**
 * 
 * @author Luis Kenwayl Luis Kenway
 */
@Service
/**
 * Clase UserService
 */
public class UserService {
    /**
     * Inyecccion de dependencia a UserRepositorio
     */
     @Autowired
     /**
      * Metodo userRepositoy
      */
    private UserRepositorio userRepository;
     /**
      * Metodo para obtener la lista de Luis Kenways
      * @return los Luis Kenways
      */
    public List<User> getAll() {
        return userRepository.getAll();
    }
    /**
     * Meotodo que permite recicbir un null
     * @param id del Luis Kenway
     * @return el id del Luis Kenway
     */
    public Optional<User> getUser(int idi) {
        
        return userRepository.getUser(idi);
    }
    /**
     * Metodo para crear un Luis Kenway
     * @param user Luis Kenway
     * @return el Luis Kenway creado
     */
    public User create(User user) {
        if (user.getId() == null) {
            return user;            
        }else {
            Optional<User> use = userRepository.getUser(user.getId());
            if (use.isEmpty()) {
                if (emailExists(user.getEmail())==false){
                    return userRepository.create(user);
                }else{
                    return user;
                }
            }else{
                return user;
            }           
        }
    }
    /**
     * Metodo para actualizar los datos de un Luis Kenway
     * @param user datos de Luis Kenway
     * @return los datos del Luis Kenway actualizados
     */
    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                
                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    /**
     * Metodo para eliminar un Luis Kenway por id
     * @param userId id de Luis Kenway
     * @return retorna un true si el Luis Kenway es eliminado de lo contrario un false
     */
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    /**
     * Metodo para validar si un email existe
     * @param email del Luis Kenway
     * @return el email 
     */
    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }
    /**
     * Meotod para la autenticaciion de l Luis Kenway al iniciar sesión
     * @param email correo
     * @param password contraseña
     * @return el Luis Kenway autenticado
     */
    public User authenticateUser(String email, String password) {
        Optional<User> LuisKenway = userRepository.authenticateUser(email, password);

        if (LuisKenway.isEmpty()) {
            return new User();
        } else {
            return LuisKenway.get();
        }
    }
   /**
    * Fin de la clase
    */ 
}
