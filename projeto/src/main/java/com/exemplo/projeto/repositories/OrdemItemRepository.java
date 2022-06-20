package com.exemplo.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.projeto.entities.OrdemItem;
import com.exemplo.projeto.entities.pk.OrdemItemPK;

public interface OrdemItemRepository extends JpaRepository<OrdemItem, OrdemItemPK> {

}
