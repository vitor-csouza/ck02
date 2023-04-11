package br.com.fiap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.model.CategoriaModel;
import br.com.fiap.model.MarcaModel;
import br.com.fiap.repository.MarcaRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/marca")
public class MarcaController {
	
	private static final String MARCA_FOLDER = "marca/";
	
	@Autowired
	public MarcaRepository repository;
	
	@GetMapping()
	public String findAll(Model model) {
		model.addAttribute("marcas", repository.findAll());
		return MARCA_FOLDER + "marcas";
	}
	
	@GetMapping("/{id}")
	public String findById(@PathVariable("id") long id, Model model) {
		model.addAttribute("marca", repository.findById(id));
		return MARCA_FOLDER + "marca-detalhe";
	}
	
	
	@GetMapping("/form")
	public String open(@RequestParam String page, @RequestParam(required=false) Long id, @ModelAttribute("marcaModel") MarcaModel marcaModel, Model model) {
		if("marca-editar".equals(page)) {
			model.addAttribute("marcaModel", repository.findById(id));
		}
		return  MARCA_FOLDER + page;
	}
	
	@PostMapping()
	public String save(@Valid MarcaModel marcaModel, BindingResult bindingResult, 
			RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			return MARCA_FOLDER + "marca-novo";
		}
		
		repository.save(marcaModel);
		redirectAttributes.addFlashAttribute("messages","Marca cadastrada com sucesso!");
		return "redirect:/marca";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable("id") long id, Model model, @Valid MarcaModel marcaModel, BindingResult bindingResult, 
			RedirectAttributes redirectAttributes) {
		marcaModel.setIdMarca(id);
		repository.update(marcaModel);
		redirectAttributes.addFlashAttribute("messages","Marca atualizada com sucesso!");
		model.addAttribute("marcas",repository.findAll());
		return "redirect:/marca";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") long id, Model model, 
			RedirectAttributes redirectAttributes) {
		repository.deleteById(id);
		redirectAttributes.addFlashAttribute("messages","Marca excluída com sucesso!");
		model.addAttribute("marcas",repository.findAll());
		return "redirect:/marca";
	}

}
