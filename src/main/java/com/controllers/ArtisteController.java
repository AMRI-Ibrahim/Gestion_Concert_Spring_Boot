package com.controllers;

import com.dtos.ArtisteDto;
import com.entities.Concert;
import com.services.impl.ArtisteServiceImpl;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

// Un contrôleur Spring qui gère les requêtes HTTP relatives aux artistes
@RestController
@RequestMapping("/artiste")
public class ArtisteController {
    private EntityManager em;
    private final ArtisteServiceImpl artisteService;


    public ArtisteController(ArtisteServiceImpl artisteService,EntityManager em) {
        this.artisteService = artisteService;
        this.em = em;
    }

    // Une méthode qui renvoie la liste de tous les artistes existants dans le système
    @GetMapping
    public List<ArtisteDto> getArtistes() {
        return artisteService.getAllArtistes();
    }

    /**
     * Méthode pour obtenir l'artiste en fonction de l'ID
     */
    @GetMapping("/{id}")
    public ArtisteDto getArtiste(@PathVariable Long id){
        return artisteService.getArtisteById(id);
    }

    /**
     * Créer un nouvel artiste dans le système
     */
    @PostMapping
    public ArtisteDto saveArtiste(final @RequestBody ArtisteDto artisteDto) throws ChangeSetPersister.NotFoundException {
        return artisteService.saveArtiste(artisteDto);
    }

    /**
     * Renvoie la liste des concerts d'un artiste en fonction de son ID
     */
    @GetMapping("/artiste/{id}/concerts")
    public List<Concert> getConcertsByArtisteId(@PathVariable Long id) {
        // Crée une requête JPQL pour sélectionner les concerts dont le groupe est associé à l'artiste
        TypedQuery<Concert> query = em.createQuery("SELECT c FROM Concert c WHERE c.grp_id IN (SELECT a.grp_id FROM Artiste a WHERE a.art_id = :id)", Concert.class);
        query.setParameter("id", id);
        return query.getResultList();
    }


    /**
     * Supprimer un artiste par son identifiant
     */
    @DeleteMapping("/{id}")
    public Boolean deleteArtiste(@PathVariable Long id){
        return artisteService.deleteArtiste(id);
    }
}