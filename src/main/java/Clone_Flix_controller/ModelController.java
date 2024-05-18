package Clone_Flix_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<ModelLogin> salvarModel(@RequestBody ModelLogin login) {
		
		ModelLogin modelSalvo = modelService.save(login);
		
		return new ResponseEntity<ModelLogin>(modelSalvo, HttpStatus.OK);
	}
	
	
	@ResponseBody /*Retorno da api*/
	@PostMapping(value = "**/deleteModel")
	public ResponseEntity<ModelLogin> deleteModel(@RequestBody ModelLogin login) {
		
		modelRepository.deleteById(login.getId());
		
		return new ResponseEntity("Usuário Removido", HttpStatus.OK);
	}

}
