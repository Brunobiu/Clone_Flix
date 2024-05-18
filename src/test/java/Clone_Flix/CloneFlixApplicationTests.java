package Clone_Flix;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Clone_Flix_controller.ModelController;
import Clone_Flix_model.ModelLogin;
import Clone_Flix_repository.ModelRepository;
import junit.framework.TestCase;

@SpringBootTest(classes = CloneFlixApplication.class)
public class CloneFlixApplicationTests extends TestCase{
	
	
	
	@Autowired
	private ModelController modelController;
	
	@Autowired
	private ModelRepository modelRepository;


	@Test
	public void testCadastraModel() {
		
	ModelLogin model = new ModelLogin();
		
		model.setNomeSobrenome("junior");
		model.setSenha("123445678419");
		model.setCpf("654651414424515651");
		model.setEmail("cdscssdchegfggsddscsd@gmail.com");
		model.setCelular("62994757240");
		
		/*Validando pra nao ser nulo*/
		assertEquals(true, model.getId() == null);
		
		/*Gravou no banco*/
		model = modelController.salvarModel(model).getBody();
		
		assertEquals(true, model.getId() > 0);
		
		/*teste de carregamento*/
		ModelLogin model2 = modelRepository.findById(model.getId()).get();
		
		assertEquals(model.getId(), model2.getId());
		
		/*TEste de delete*/
		modelRepository.deleteById(model2.getId());
		
		modelRepository.flush(); /*Rodar as alteraçoes no banco*/
		
		ModelLogin model3 = modelRepository.findById(model2.getId()).orElse(null);
		
		assertEquals(true, model3 == null);
		
		/*Teste de qiery*/
		//model = new ModelLogin();
		
		//model.setNomeSobrenome("bruno");
		
		//model = modelController.salvarModel(model).getBody();
		
		//List<ModelLogin> modelLista = modelRepository.buscarCadastro("bruno".trim().toUpperCase());
		
		//assertEquals(1, modelLista.size());
		
		//modelRepository.deleteById(model.getId());
		
		
		
	}

}
