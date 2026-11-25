
package com.zeabobora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zeabobora.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
