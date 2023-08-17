package com.fiap.postech.fastfoodsysteminfra.persistence.repository;

import com.fiap.postech.fastfoodsysteminfra.persistence.repository.entity.ClienteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface ClienteRepositoryMongo extends MongoRepository<ClienteEntity, String> {
  Optional<ClienteEntity> findByCpf(String cpf);
}
