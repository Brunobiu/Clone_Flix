package Clone_Flix_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Clone_Flix.ExceptionMentoriaJava;
import Clone_Flix_model.ModelLogin;
import Clone_Flix_repository.CadastroRepository;
import Clone_Flix_service.ModelUserService;

@RestController
public class ModelControler {
	
	@Autowired
	private CadastroRepository cadastroRepository;
	
	@Autowired
	private ModelUserService modelUserService;
	
	@ResponseBody
	@PostMapping(value = "**/salvarPessoa")
	public ResponseEntity<ModelLogin> salvarPessoa(@RequestBody ModelLogin modelLogin) throws ExceptionMentoriaJava{
		
		if(modelLogin == null) {
			throw new ExceptionMentoriaJava("Pessoa não existe.");
		}
		
		if (modelLogin.getId() == null && cadastroRepository.existeCpfCadastrado(modelLogin.getCpf()) != null) {
			throw new ExceptionMentoriaJava("Já existe esse CPF cadastrado: " + modelLogin.getCpf());
		}
		
		modelLogin = modelUserService.salvarPessoaModel(modelLogin);
		
		
		return new ResponseEntity<ModelLogin>(modelLogin, HttpStatus.OK);
		
	}

}
