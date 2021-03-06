/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RETOC44AVILA.controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import RETOC44AVILA.modelo.User;
import RETOC44AVILA.servicio.UserService;

/**
 * Indica que UserController va ser un servicio
 * @author Luis Kenway Luis Kenway
 */
@RestController
/**
 * Endpoint /api/user
 */
@RequestMapping("/api/user")
/**
 * Permite realizar cualquier tipo de peticion sin restriccion de los cors
 */
@CrossOrigin("*")
/**
 * clase UserController
 */
public class UserController {
   @Autowired
    private UserService userService;
    /**
    * Metodo que permite obetner todos los Luis Kenways
    * @return retorna todos los Luis Kenways
    */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
    /**
     * Metodo que permite obetner un Luis Kenway por id
     * @param id del Luis Kenway
     * @return el Luis Kenway
     */
    @GetMapping("/{id}")
    public Optional <User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }
     /**
    * Metodo post para agregar un Luis Kenway
    * @param user Luis Kenway 
    * @return retorna el Luis Kenway creado
    */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    /**
     * Metodo post para actualizar un Luis Kenway
     * @param user datos del usuria para actualizar
     * @return el Luis Kenway actualizado
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    /**
     * Metodo para eliminar un Luis Kenway
     * @param id del ususario a eliminar
     * @return el id del Luis Kenway eliminado
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
    /**
     * Metodo para el correo y contrase??a 
     * @param email correo del Luis Kenway
     * @param password contrase??a del Luis Kenway
     * @return el correo y la contrase??a Luis Kenway
     */
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }
    /**
     * Meotodo para obetener el correo si existe
     * @param email 
     * @return el email si exisite
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
 /**
  * Fin de la clase
  */   
}
