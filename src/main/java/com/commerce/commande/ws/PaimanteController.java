package com.commerce.commande.ws;

import com.commerce.commande.bean.Commande;
import com.commerce.commande.bean.Paimante;
import com.commerce.commande.service.PaimanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-commercial/paimante")
public class PaimanteController {
    @Autowired
    private PaimanteService paimanteService;

    @GetMapping("/ref/{reference}")
    public Paimante findByRef(@PathVariable("reference") String ref) {
        return paimanteService.findByRef(ref);
    }

    @Transactional
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable("ref") String ref) {
        paimanteService.DeleteByRef(ref);
        return 1;
    }

    @PostMapping("/")
    public int save(@RequestBody Paimante paimante) {
        return paimanteService.save(paimante);
    }


}
