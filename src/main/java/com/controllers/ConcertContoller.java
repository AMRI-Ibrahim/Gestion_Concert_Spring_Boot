package com.controllers;

import com.dtos.ConcertDto;
import com.entities.Concert;
import com.entities.Groupe;
import com.services.impl.ConcertServiceImpl;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
@RestController
@RequestMapping("/concert")
public class ConcertContoller {

    private EntityManager em;
    private final ConcertServiceImpl concertService;

    public ConcertContoller(ConcertServiceImpl concertService,EntityManager em) {
        this.concertService = concertService;
        this.em = em;
    }

    /**
     * <p>Recuperer toutes les concert dans le system</p>
     *
     */
    @GetMapping
    public List<ConcertDto> getConcerts() {
        return concertService.getAllConcerts();
    }

    /**
     * Recuperer un concer d'aprer sont id
     */
    @GetMapping("/{id}")
    public ConcertDto getConcert(@PathVariable Long id){
        return concertService.getConcertById(id);
    }

    /**
     * Cree un noveau concert dans le system
     */
    @PostMapping
    public ConcertDto saveConcert(final @RequestBody ConcertDto concertDto) throws ChangeSetPersister.NotFoundException {
        return concertService.saveConcert(concertDto);
    }

    /**
     * Cette requête utilise la méthode getGroupesByConcertId(Long id) pour récupérer une liste de groupes qui participent à un concert spécifique en utilisant l'ID du concert.
     */
    @GetMapping("/concert/{id}/groupes")
    public List<Groupe> getGroupesByConcertId(@PathVariable Long id) {
        TypedQuery<Groupe> query = em.createQuery("SELECT c.grp_id FROM Concert c WHERE c.con_id = :id", Groupe.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
    //Cette requête utilise la méthode getConcertByGroupeId(Long id) pour récupérer une liste de concerts auxquels un groupe participe en utilisant l'ID du groupe. L'ID du groupe est passé dans l'URL.
    @GetMapping("/groupe/{id}/concert")
    public List<Concert> getConcertByGroupeId(@PathVariable Long id) {
        TypedQuery<Concert> query = em.createQuery("SELECT c FROM Concert c WHERE c.grp_id.grp_id = :id", Concert.class);
        query.setParameter("id", id);
        return query.getResultList();
    }


    /**
     * Supprimer un concert d'aprer sont id
     */

    @DeleteMapping("/{id}")
    public Boolean deleteConcert(@PathVariable Long id){
        return concertService.deleteConcert(id);
    }
}
