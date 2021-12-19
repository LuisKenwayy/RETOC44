/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RETOC44AVILA.interfaces;


import org.springframework.data.mongodb.repository.MongoRepository;

import RETOC44AVILA.modelo.Chocolate;

/**
 *
 * @author Luis Kenway
 */
public interface InterfaceChocolate extends MongoRepository<Chocolate, String> {
    
}
