package Pokemon.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Pokemon.api.service.pokemonService;

@CrossOrigin("*")
@RestController
@RequestMapping("/apiRest")
public class pokemonController {

	@Autowired
	pokemonService pokemonServ;
	@Autowired
	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("abilities/{nombre}")
	public List<Object> obtenerHabilidad(@PathVariable String nombre) throws JsonMappingException, JsonProcessingException{
		List<Object> abilities = pokemonServ.obtenerHabilidad(nombre);
		return abilities;
	}
	
	@GetMapping("helditems/{nombre}")
	public List<Object> obtenerHeld(@PathVariable String nombre) throws JsonMappingException, JsonProcessingException{
		List<Object> held_items = pokemonServ.obtenerHabilidad(nombre);
		return held_items;
	}
	
	@GetMapping("name/{nombre}")
	public String obtenerNombre(@PathVariable String nombre) throws JsonMappingException,JsonProcessingException{
		String nombres = pokemonServ.obtenerNombres(nombre);
		return nombres;
	}
	
	@GetMapping("id/{nombre}")
	public String obtenerID(@PathVariable String nombre) throws JsonMappingException,JsonProcessingException{
		String ID = pokemonServ.obtenerIdentificador(nombre);
		return ID;
	}
	
	@GetMapping("baseExperience/{nombre}")
	public String obtenerBaseExperience(@PathVariable String nombre) throws JsonMappingException,JsonProcessingException{
		String baseExp = pokemonServ.obtenerIdentificador(nombre);
		return baseExp;
	}
	
	@GetMapping("locationEncounters/{nombre}")
	public String obtenerLocationEncounters(@PathVariable String nombre) throws JsonMappingException,JsonProcessingException{
		String location = pokemonServ.obtenerIdentificador(nombre);
		return location;
	}
}
