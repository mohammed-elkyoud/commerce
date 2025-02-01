package com.commerce.commande.dao;

import com.commerce.commande.bean.Commande;
import com.commerce.commande.bean.Paimante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaimanteDao extends JpaRepository<Paimante, Long> {
    Paimante findByRef(String ref);

    int deleteByRef(String ref);

}
