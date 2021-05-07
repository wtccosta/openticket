package br.gov.ms.corumba.opentickets.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "glpi_tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "entities_id")
	private Integer entity = 0;
	private String name;
	
	@Column(name = "date_creation")
	@CreationTimestamp
	private LocalDateTime date;
	private String content;
}
