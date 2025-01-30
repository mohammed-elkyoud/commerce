package com.commerce.commande.ws;

import com.commerce.commande.bean.Commande;
import com.commerce.commande.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-commercial/commande")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @GetMapping("/ref/{reference}")
    public Commande findByRef(@PathVariable("reference") String ref) {
        return commandeService.findByRef(ref);
    }

    @Transactional
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable("ref") String ref) {
        commandeService.DeleteByRef(ref);
        return 1;
    }

    @PostMapping("/")
    public int save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }

    @PutMapping("/paye/ref/{ref}/montant/{at}")
    public int paye(@PathVariable String ref, @PathVariable double at) {
        return commandeService.paye(ref, at);
    }

    @GetMapping("/")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }

    @GetMapping("/ref/{ref}/total/{total}")
    public List<Commande> findByRefLikeAndTotalGreaterThan(String ref, double total) {
        return commandeService.findByRefLikeAndTotalGreaterThan(ref, total);
    }
}
