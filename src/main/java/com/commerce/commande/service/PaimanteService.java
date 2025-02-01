package com.commerce.commande.service;


import com.commerce.commande.bean.Paimante;
import com.commerce.commande.dao.PaimanteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaimanteService {
    @Autowired
    private PaimanteDao paimanteDao;

    public Paimante findByRef(String ref) {
        return paimanteDao.findByRef(ref);
    }

    @Transactional
    public int DeleteByRef(String ref) {
        paimanteDao.deleteByRef(ref);
        return 1;
    }

    public int save(Paimante Paimante) {
        if (findByRef(Paimante.getRef()) != null) {
            return -1;
        } else {
            paimanteDao.save(Paimante);
            return 1;
        }
    }


   
}
