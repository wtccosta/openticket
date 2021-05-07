package br.gov.ms.corumba.opentickets.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.ms.corumba.opentickets.domain.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
