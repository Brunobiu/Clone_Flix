package Clone_Flix_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Clone_Flix_model.ModelLogin;
import Clone_Flix_repository.ModelRepository;

@Service
public class ModelService {
	
	@Autowired
	private ModelRepository modelRepository;
	
	public ModelLogin save(ModelLogin login) {
		
		/*Qualquer tipo de validação*/
		return modelRepository.save(login);
	}

}
