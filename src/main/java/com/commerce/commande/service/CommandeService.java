package com.commerce.commande.service;

import com.commerce.commande.bean.Commande;
import com.commerce.commande.dao.CommandeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommandeService {
    @Autowired
    private CommandeDao commandeDao;

    public Commande findByRef(String ref) {
        return commandeDao.findByRef(ref);
    }

    @Transactional
    public int DeleteByRef(String ref) {
        commandeDao.deleteByRef(ref);
        return 1;
    }

    public int save(Commande commande) {
        if (findByRef(commande.getRef()) != null) {
            return -1;
        } else if (commande.getTotal() < commande.getTotalPaye()) {
            return -2;
        } else {
            commandeDao.save(commande);
            return 1;
        }
    }


    public int paye(String ref, double at) {
        Commande commande = findByRef(ref);
        if (commande == null) {
            return -1;
        } else if (commande.getTotalPaye()+at > commande.getTotal()) {
            return -2;
        } else {
            commande.setTotalPaye(commande.getTotalPaye()+at);
            commandeDao.save(commande);
            return 1;

        }

    }

    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

    public List<Commande> findByRefLikeAndTotalGreaterThan(String ref, double total) {
        return commandeDao.findByRefLikeAndTotalGreaterThan(ref, total);
    }
}
