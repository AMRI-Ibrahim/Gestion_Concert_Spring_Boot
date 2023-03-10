package com.services;

import com.dtos.ConcertDto;
import com.dtos.SalleDto;
import com.dtos.SoireeDto;
import com.dtos.TicketDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface TicketService {
    TicketDto saveTicket(TicketDto TicketDto) throws ChangeSetPersister.NotFoundException;


    TicketDto getTicketById(Long ticketId) throws ChangeSetPersister.NotFoundException;


    boolean deleteTicket(Long ticketId);


    List<TicketDto> getAllTickets();

    Long getNumberOfTicketsSold(ConcertDto concert, SalleDto salle);
}
