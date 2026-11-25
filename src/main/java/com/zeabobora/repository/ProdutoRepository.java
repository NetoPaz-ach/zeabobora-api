
package com.zeabobora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zeabobora.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
