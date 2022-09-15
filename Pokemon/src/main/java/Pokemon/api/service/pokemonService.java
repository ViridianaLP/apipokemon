package Pokemon.api.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@Service
public class pokemonService {

	private String apiURL = "https://pokeapi.co/api/v2/pokemon/";
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<Object> obtenerHabilidad(String nombre) throws JsonMappingException,JsonProcessingException{
		ResponseEntity<String> response =
				restTemplate.getForEntity(apiURL+nombre, String.class);
				ObjectMapper mapper = new ObjectMapper();
				JsonNode root=mapper.readTree(response.getBody());
				JsonNode abilities = root.path("abilities");
				return Arrays.asList(abilities);

	}
	
	public List<Object> obtenerHeldItem(String nombre) throws JsonMappingException,JsonProcessingException{
		ResponseEntity<String> response =
				restTemplate.getForEntity(apiURL+nombre, String.class);
				ObjectMapper mapper = new ObjectMapper();
				JsonNode root=mapper.readTree(response.getBody());
				JsonNode held_items = root.path("held_items");
				return Arrays.asList(held_items);

	}
	
	public String obtenerNombres(String nombre)throws JsonMappingException,JsonProcessingException{
		ResponseEntity<String> response =
				restTemplate.getForEntity(apiURL+nombre, String.class);
				ObjectMapper mapper = new ObjectMapper();
				JsonNode root=mapper.readTree(response.getBody());
				JsonNode nombres = root.path("name");
				return nombres.toPrettyString();
	}
	
	public String obtenerIdentificador(String nombre)throws JsonMappingException,JsonProcessingException{
		ResponseEntity<String> response =
				restTemplate.getForEntity(apiURL+nombre, String.class);
				ObjectMapper mapper = new ObjectMapper();
				JsonNode root=mapper.readTree(response.getBody());
				JsonNode id = root.path("id");
				return id.toPrettyString();
	}
	
	public String obtenerBaseExp(String nombre)throws JsonMappingException,JsonProcessingException{
		ResponseEntity<String> response =
				restTemplate.getForEntity(apiURL+nombre, String.class);
				ObjectMapper mapper = new ObjectMapper();
				JsonNode root=mapper.readTree(response.getBody());
				JsonNode baseExp = root.path("base_experience");
				return baseExp.toPrettyString();
	}
	
	public String obtenerLocation(String nombre)throws JsonMappingException,JsonProcessingException{
		ResponseEntity<String> response =
				restTemplate.getForEntity(apiURL+nombre, String.class);
				ObjectMapper mapper = new ObjectMapper();
				JsonNode root=mapper.readTree(response.getBody());
				JsonNode location = root.path("location_area_encounters");
				return location.toPrettyString();
	}
	
}
