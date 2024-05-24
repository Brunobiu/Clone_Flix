package Clone_Flix_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Clone_Flix.ExceptionMentoriaJava;
import Clone_Flix_model.ModelLogin;
import Clone_Flix_repository.ModelRepository;
import Clone_Flix_service.ModelService;

@Controller
@RestController
public class ModelController {
	
	@Autowired
	private ModelService modelService;
	
	@Autowired
	private ModelRepository modelRepository;
	
	@ResponseBody /*Retorno da api*/
	@PostMapping(value = "**/salvarModel")
	public ResponseEntity<ModelLogin> salvarModel(@RequestBody ModelLogin login) throws ExceptionMentoriaJava {
		
		if (login.getId() == null) {
			
			List<ModelLogin> logins =  modelRepository.buscarPorModel(login.getNomeSobrenome().toUpperCase());
			
			if (!logins.isEmpty()) {
				
				throw new ExceptionMentoriaJava("Já existe Acesso com a descrição: " + login.getNomeSobrenome());
			}
		}
		
		ModelLogin modelSalvo = modelService.save(login);
		
		return new ResponseEntity<ModelLogin>(modelSalvo, HttpStatus.OK);
	}
	
	
	@ResponseBody /*Retorno da api*/
	@PostMapping(value = "**/deleteModel")
	public ResponseEntity<?> deleteModel(@RequestBody ModelLogin login) {
		
		modelRepository.deleteById(login.getId());
		
		return new ResponseEntity("Usuário Removido", HttpStatus.OK);
	}
	
	
	/*Deletar por ID*/
	@ResponseBody
	@DeleteMapping(value = "**/deleteModelPorId/{id}")
	public ResponseEntity<?> deleteModelPorId(@PathVariable("id") Long id) {
		
		modelRepository.deleteById(id);
		
		return new ResponseEntity("Usuário Removido", HttpStatus.OK);
	}
	
	
	/*Consultar por ID*/
	@ResponseBody
	@GetMapping(value = "**/obterModel/{id}")
	public ResponseEntity<ModelLogin> obterModel(@PathVariable("id") Long id) throws ExceptionMentoriaJava {
		
		ModelLogin login =  modelRepository.findById(id).orElse(null);
		
		if (login == null) {
			throw new ExceptionMentoriaJava("Acesso nao encontrado com o codigo" + id);
		}
		
		return new ResponseEntity<ModelLogin>(login, HttpStatus.OK);
	}
	
	
	/* Consultar por ID */
	@ResponseBody
	@GetMapping(value = "**/buscarPorModel/{nome}")
	public ResponseEntity<List<ModelLogin>> buscarPorModel(@PathVariable("nome") String nome) {
	    List<ModelLogin> login = modelRepository.buscarPorModel(nome.toUpperCase());
	    return new ResponseEntity<>(login, HttpStatus.OK);
	}


}
