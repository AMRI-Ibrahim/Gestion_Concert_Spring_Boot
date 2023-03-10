package com.services.impl;

import com.dtos.ConcertDto;
import com.dtos.SalleDto;
import com.dtos.TicketDto;
import com.entities.Soiree;
import com.entities.Ticket;
import com.repositories.SoireeRepository;
import com.repositories.TicketRepository;
import com.services.TicketService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final SoireeRepository soireeRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, SoireeRepository soireeRepository) {
        this.ticketRepository = ticketRepository;
        this.soireeRepository = soireeRepository;
    }

    @Override
    public TicketDto saveTicket(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setTic_nom(ticketDto.getTic_nom());
        ticket.setTic_prenom(ticketDto.getTic_prenom());
        Long  i = 43l*ticketDto.getTic_nb_personne();
        ticket.setTic_prix(i);
        ticket.setTic_nb_personne(ticketDto.getTic_nb_personne());

        // Set the Soiree object
        //
        Long soireeId = ticketDto.getSoi_id();
        Soiree soiree = soireeRepository.findById(soireeId).orElse(null);
        if (soiree != null) {
            ticket.setSoi_id(soiree);
        }

        Ticket savedTicket = ticketRepository.save(ticket);
        return convertToDto(savedTicket);
    }

    @Override
    public TicketDto getTicketById(Long ticketId) throws ChangeSetPersister.NotFoundException {
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        if (ticketOptional.isPresent()) {
            Ticket ticket = ticketOptional.get();
            return convertToDto(ticket);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    @Override
    public boolean deleteTicket(Long ticketId) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        if (ticketOptional.isPresent()) {
            ticketRepository.delete(ticketOptional.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<TicketDto> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        List<TicketDto> ticketDtos = new ArrayList<>();
        for (Ticket ticket : tickets) {
            ticketDtos.add(convertToDto(ticket));
        }
        return ticketDtos;
    }

    @Override
    public Long getNumberOfTicketsSold(ConcertDto concert, SalleDto salle) {
        return 20l;
    }

    // Helper method to convert a Ticket object to a TicketDto object
    private TicketDto convertToDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setTic_id(ticket.getTic_id());
        ticketDto.setTic_nom(ticket.getTic_nom());
        ticketDto.setTic_prenom(ticket.getTic_prenom());
        ticketDto.setTic_prix(ticket.getTic_prix());
        ticketDto.setTic_nb_personne(ticket.getTic_nb_personne());
        if (ticket.getSoi_id() != null) {
            ticketDto.setSoi_id(ticket.getSoi_id().getSoi_id());
        }
        return ticketDto;
    }
}
