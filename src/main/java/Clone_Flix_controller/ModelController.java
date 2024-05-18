package Clone_Flix_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import Clone_Flix_model.ModelLogin;
import Clone_Flix_service.ModelService;

@Controller
public class ModelController {
	
	@Autowired
	private ModelService modelService;
	
	@PostMapping("salvarModel")
	public ModelLogin salvarModel(ModelLogin login) {
		
		return modelService.save(login);
	}

}
