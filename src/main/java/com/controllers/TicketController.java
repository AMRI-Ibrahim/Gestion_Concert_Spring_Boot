package com.controllers;

import com.dtos.ConcertDto;
import com.dtos.SalleDto;
import com.dtos.TicketDto;
import com.entities.Salle;
import com.entities.Ticket;
import com.services.ConcertService;
import com.services.SalleService;
import com.services.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final ConcertService concertService;
    private final SalleService salleService;

    public TicketController(TicketService ticketService, ConcertService concertService, SalleService salleService) {
        this.ticketService = ticketService;
        this.concertService = concertService;
        this.salleService = salleService;
    }
    // Creation d'un nouveau ticket
    @PostMapping
    public ResponseEntity<TicketDto> saveTicket(@RequestBody TicketDto ticketDto) {
        try {
            TicketDto savedTicket = ticketService.saveTicket(ticketDto);
            return ResponseEntity.ok(savedTicket);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Recupere un ticket par sont id
    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable("id") Long id) {
        try {
            TicketDto ticketDto = ticketService.getTicketById(id);
            if (ticketDto == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(ticketDto);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    // supprimer un ticket par sont id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable("id") Long id) {
        boolean success = ticketService.deleteTicket(id);
        if (success) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Lister tous les tickets present dans la base
    @GetMapping
    public ResponseEntity<List<TicketDto>> getAllTickets() {
        List<TicketDto> ticketDtos = ticketService.getAllTickets();
        return ResponseEntity.ok(ticketDtos);
    }

}