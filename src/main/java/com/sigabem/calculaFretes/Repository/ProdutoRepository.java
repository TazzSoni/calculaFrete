package com.sigabem.calculaFretes.Repository;

import com.sigabem.calculaFretes.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
    Produto findById(long id);
    
}
