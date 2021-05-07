package br.gov.ms.corumba.opentickets.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.ms.corumba.opentickets.domain.dto.TicketDTO;
import br.gov.ms.corumba.opentickets.domain.model.Ticket;
import br.gov.ms.corumba.opentickets.domain.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	public TicketDTO create(TicketDTO response) {
		Ticket ticket = response.toModel();
		System.out.println(ticket.toString());
		return new TicketDTO(ticketRepository.save(ticket));
	}
}
