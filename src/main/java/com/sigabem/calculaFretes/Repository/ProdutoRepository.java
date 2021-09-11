/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigabem.calculaFretes.Repository;

import com.sigabem.calculaFretes.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author tasso
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
    Produto findById(long id);
    
}
