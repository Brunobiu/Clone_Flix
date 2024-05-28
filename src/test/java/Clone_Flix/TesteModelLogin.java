package Clone_Flix;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import Clone_Flix_controller.ModelControler;
import Clone_Flix_model.ModelLogin;
import junit.framework.TestCase;

@Profile("test")
@SpringBootTest(classes = CloneFlixApplication.class)
public class TesteModelLogin extends TestCase{
	
	@Autowired
	private ModelControler modelControler;

	@Test
	public void testCadModel() throws ExceptionMentoriaJava {
		
		ModelLogin modelLogin = new ModelLogin();
		
		modelLogin.setNomeSobrenome("Leandro12324114");
		modelLogin.setSenha("99999999814");
		modelLogin.setCpf("9889447223551198412");
		modelLogin.setEmail("bruno.uol.conatasz14ca224242sc@gmail.com");
		modelLogin.setCelular("62994757244041");
		
		modelControler.salvarPessoa(modelLogin);
		
	}	
}
