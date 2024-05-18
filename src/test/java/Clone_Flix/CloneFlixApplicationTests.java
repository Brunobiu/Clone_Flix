package Clone_Flix;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Clone_Flix_controller.ModelController;
import Clone_Flix_model.ModelLogin;

@SpringBootTest(classes = CloneFlixApplication.class)
public class CloneFlixApplicationTests {
	
	
	
	@Autowired
	private ModelController modelController;


	@Test
	public void testCadastraModel() {
		
		ModelLogin model = new ModelLogin();
		
		model.setNomeSobrenome("Leonardo");
		model.setSenha("12345678419");
		model.setCpf("753022424438100");
		model.setEmail("brunoTeste2@gmail.com");
		model.setCelular("624224994757240");
		
		modelController.salvarModel(model);
		
	}

}
