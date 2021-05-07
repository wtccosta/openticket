package br.gov.ms.corumba.opentickets.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	
	@Column(name = "date")
	@CreationTimestamp
	private LocalDateTime dateSimple;
	
	private Integer users_id_recipient = 1987;
	
	@Column(name = "date_mod")
	@UpdateTimestamp
	private LocalDateTime dateMod;
	
	private String content;
	
	private Integer status = 2;
	
	@Column(name = "requesttypes_id")
	private Integer openMode = 8;
	
	private Integer urgency = 1;
	
	private Integer impact = 1;
	
	private Integer priority = 1;
	
	private Integer type = 1;
	
	private Integer globalValidation = 1;
	
	
}
