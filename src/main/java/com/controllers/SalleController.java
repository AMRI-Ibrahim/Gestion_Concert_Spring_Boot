package com.controllers;

import com.dtos.ConcertDto;
import com.dtos.SalleDto;
import com.entities.Concert;
import com.entities.Salle;
import com.repositories.SalleRepository;
import com.services.impl.ConcertServiceImpl;
import com.services.impl.SalleServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;
import java.util.List;

@RestController
@RequestMapping("/salle")
public class SalleController {

    private final SalleServiceImpl salleService;
    private SalleRepository salleRepository;
    private EntityManager em;
    //Constructeur
    public SalleController(SalleServiceImpl salleService, SalleRepository salleRepository,EntityManager em)
    {
        this.salleService = salleService;
        this.salleRepository = salleRepository;
        this.em = em;
    }

    /**
     * <p>Retourne toutes les salles dans la base</p>
     *
     */
    @GetMapping
    public List<SalleDto> getSalles() {
        return salleService.getAllSalles();
    }

    /**
     * Retourner une salle baser sur sont id
     */
    @GetMapping("/{id}")
    public SalleDto getSalle(@PathVariable Long id){
        return salleService.getSalleById(id);
    }

    /**
     * Create a new salle in the system
     */
    /*@PostMapping
    public SalleDto saveSalle(final @RequestBody SalleDto salleDto){
        return salleService.saveSalle(salleDto);
    }*/
    /**
     * Recupere un concert d'apres id d'une salle
     */
    @GetMapping("/salles/{id}/concerts")
    public List<Concert> getConcertsBySalleId(@PathVariable Long id) {
        TypedQuery<Concert> query = em.createQuery("SELECT c FROM Concert c WHERE c.soi_id.sal_id.sal_id = :id", Concert.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    /**
     * Creation d'un nouvelle salle dans base
     */
    @PostMapping("/add")
    public ResponseEntity<Salle> addSalle(@RequestParam("sal_nom") String sal_nom,
                                          @RequestParam("sal_adresse") String sal_adresse,
                                          @RequestParam("sal_capacite") Long sal_capacite,
                                          @RequestParam("sal_nom_gestionnaire") String sal_nom_gestionnaire,
                                          @RequestParam("sal_prenom_gestionnaire") String sal_prenom_gestionnaire,
                                          @RequestParam("sal_association_gestionnaire") String sal_association_gestionnaire) {
        Salle salle = new Salle();
        //salle.setSal_id(2l);
        salle.setSal_nom(sal_nom);
        salle.setSal_adresse(sal_adresse);
        salle.setSal_capacite(sal_capacite);
        salle.setSal_nom_gestionnaire(sal_nom_gestionnaire);
        salle.setSal_prenom_gestionnaire(sal_prenom_gestionnaire);
        salle.setSal_association_gestionnaire(sal_association_gestionnaire);
        salleRepository.save(salle);
        return ResponseEntity.ok(salle);
    }
    /**
     * Update a salle par sont id
     */
    @PostMapping("/update")
    public ResponseEntity<Salle> updateSalle(@RequestParam("sal_id") Long sal_id,
                                          @RequestParam("sal_nom") String sal_nom,
                                          @RequestParam("sal_adresse") String sal_adresse,
                                          @RequestParam("sal_capacite") Long sal_capacite,
                                          @RequestParam("sal_nom_gestionnaire") String sal_nom_gestionnaire,
                                          @RequestParam("sal_prenom_gestionnaire") String sal_prenom_gestionnaire,
                                          @RequestParam("sal_association_gestionnaire") String sal_association_gestionnaire) {
        Salle salle = new Salle();
        salle.setSal_id(sal_id);
        salle.setSal_nom(sal_nom);
        salle.setSal_adresse(sal_adresse);
        salle.setSal_capacite(sal_capacite);
        salle.setSal_nom_gestionnaire(sal_nom_gestionnaire);
        salle.setSal_prenom_gestionnaire(sal_prenom_gestionnaire);
        salle.setSal_association_gestionnaire(sal_association_gestionnaire);
        salleRepository.save(salle);
        return ResponseEntity.ok(salle);
    }
    /**
     * Delete a salle oar sont id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteSalle(@PathVariable Long id){
        return salleService.deleteSalle(id);
    }
}
