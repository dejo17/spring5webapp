/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.scorpiusmobile.spring5webapp.model.repositories;

import hr.scorpiusmobile.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Dejo
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long>{
    
}
