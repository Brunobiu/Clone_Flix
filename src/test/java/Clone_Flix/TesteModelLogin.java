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
		
		modelLogin.setNomeSobrenome("Leandro12");
		modelLogin.setSenha("1234567891");
		modelLogin.setCpf("988944722");
		modelLogin.setEmail("Leandxso1234aa22@gmail.com");
		modelLogin.setCelular("62994757240");
		
		modelControler.salvarPessoa(modelLogin);
		
	}
}
