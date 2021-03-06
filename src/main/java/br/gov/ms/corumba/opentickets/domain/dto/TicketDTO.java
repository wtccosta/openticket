package br.gov.ms.corumba.opentickets.domain.dto;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.validation.constraints.NotBlank;

import br.gov.ms.corumba.opentickets.domain.model.Ticket;
@ManagedBean
public class TicketDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank(message = "Campo comunicante não pode estar em branco!")
	private String communicating;
	@NotBlank (message = "Campo Telefone não pode estar em branco!")
	private String phone;
	@NotBlank (message = "Precisamos saber o local do atendimento!")
	private String place;
	@NotBlank (message = "Precisamos do endereço")
	private String address;
	private String ticketName;
	@NotBlank (message = "Precisamos que relate o ocorrido ou solicitação pretendida!")
	private String content;
	
	
	
	public TicketDTO() {
	}
	
	

	public TicketDTO(Long id, String communicating, String phone, String place,
			String address, String ticketName, String content) {
		this.id = id;
		this.communicating = communicating;
		this.phone = phone;
		this.place = place;
		this.address = address;
		this.ticketName = ticketName;
		this.content = content;
	}



	public TicketDTO(Ticket model) {
		id = model.getId();
		communicating = null;
		content = model.getContent();
		phone = null;
		place = null;
		address = null;
		ticketName = null;
	}
	
	public Ticket toModel() {
		Ticket model = new Ticket();
		model.setId(this.id);
		model.setName(this.ticketName);
		model.setContent(this.assemblyTicketContent());
		return model;
	}
	
	private String assemblyTicketContent() {
		String response = "<p>Chamado aberto por: "+this.communicating + "</p>"
		+"<p><strong>Conteúdo</strong>: </p>"
		+"<p>"+this.content+"</p>"
		+"<p><strong>Local</strong>: "+this.place+"</p>"
		+"<p><strong>Endereço</strong>: "+this.address+"</p>"
		+"<p><strong>Telefone para contato</strong>: "+this.phone+"</p>";
		return response;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketDTO other = (TicketDTO) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCommunicating() {
		return communicating;
	}



	public void setCommunicating(String communicating) {
		this.communicating = communicating;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getPlace() {
		return place;
	}



	public void setPlace(String place) {
		this.place = place;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getTicketName() {
		return ticketName;
	}



	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
