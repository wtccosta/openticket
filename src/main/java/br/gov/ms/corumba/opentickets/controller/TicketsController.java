package br.gov.ms.corumba.opentickets.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gov.ms.corumba.opentickets.domain.dto.TicketDTO;
import br.gov.ms.corumba.opentickets.domain.service.TicketService;

@Controller
@RequestMapping("tickets")
public class TicketsController {
	
	@Autowired
	private TicketService service;

	@GetMapping("openform")
	public String openform(@ModelAttribute  TicketDTO ticket, Model model) {
		model.addAttribute("ticket", new TicketDTO());
		return "ticket/openform";
	}
	
	@PostMapping("create")
	public String create(@Valid @ModelAttribute("ticket") TicketDTO ticket, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "ticket/openform";
		}
		try {
			var ticketSaved = service.create(ticket);
			attr.addFlashAttribute("sucesso", "Chamado aberto com sucesso. Anote o protocolo: "+ticketSaved.getId()+".");
		} catch (Exception e) {
			attr.addFlashAttribute("falha", "Algo deu errado.");
		}
		
		return "redirect:/tickets/openform";
	}
	
}
