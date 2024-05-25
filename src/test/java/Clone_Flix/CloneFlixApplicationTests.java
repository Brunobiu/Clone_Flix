package Clone_Flix;

import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Clone_Flix_controller.ModelController;
import Clone_Flix_model.ModelLogin;
import Clone_Flix_repository.ModelRepository;
import junit.framework.TestCase;

@Profile("test")
@SpringBootTest(classes = CloneFlixApplication.class)
public class CloneFlixApplicationTests extends TestCase{
	
	
	
	@Autowired
	private ModelController modelController;
	
	@Autowired
	private ModelRepository modelRepository;
	
	@Autowired
	private WebApplicationContext wac;
	
	/*Teste do end-point de salvar*/
	@Test
	public void testRestApiCadastroModel() throws JsonProcessingException, Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();
		
		ModelLogin modelLogin = new ModelLogin();
		
		modelLogin.setNomeSobrenome("anderson" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setSenha("123456789" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setCpf("987654321" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setEmail("anderson@gmail.com" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setCelular("62994757240" + Calendar.getInstance().getTimeInMillis());
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResultActions retornoApi = mockMvc
									.perform(MockMvcRequestBuilders.post("/salvarModel")
									.content(objectMapper.writeValueAsString(modelLogin))
									.accept(MediaType.APPLICATION_JSON)
									.contentType(MediaType.APPLICATION_JSON));
		
		
		/*Converter o retono da api para um objeto de acesso*/
		
		ModelLogin objetoRetorno = objectMapper.readValue(retornoApi.andReturn().getResponse().getContentAsString(), ModelLogin.class);
		
		assertEquals(modelLogin.getNomeSobrenome(), objetoRetorno.getNomeSobrenome());
		assertEquals(modelLogin.getSenha(), objetoRetorno.getSenha());
		assertEquals(modelLogin.getCpf(), objetoRetorno.getCpf());
		assertEquals(modelLogin.getEmail(), objetoRetorno.getEmail());
		assertEquals(modelLogin.getCelular(), objetoRetorno.getCelular());
		
	}
	
	/*Teste do end-point de Deletar*/
	@Test
	public void testRestApiDeletrarModel() throws JsonProcessingException, Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();
		
		ModelLogin modelLogin = new ModelLogin();
		
		modelLogin.setNomeSobrenome("anderson" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setSenha("123456789" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setCpf("987654321" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setEmail("anderson@gmail.com" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setCelular("62994757240" + Calendar.getInstance().getTimeInMillis());
		
		modelLogin = modelRepository.save(modelLogin);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResultActions retornoApi = mockMvc
									.perform(MockMvcRequestBuilders.post("/deleteModel")
									.content(objectMapper.writeValueAsString(modelLogin))
									.accept(MediaType.APPLICATION_JSON)
									.contentType(MediaType.APPLICATION_JSON));
		
		
		/*Converter o retono da api para um objeto de acesso*/
		
		System.out.println("Retorno da API: " + retornoApi.andReturn().getResponse().getContentAsString());
		System.out.println("Status de retorno: " + retornoApi.andReturn().getResponse().getStatus());
		
		assertEquals("Usuário Removido", retornoApi.andReturn().getResponse().getContentAsString());
		assertEquals(200, retornoApi.andReturn().getResponse().getStatus());
		
		
	}
	
	
	
	/*Teste do end-point de Deletar*/
	@Test
	public void testRestApiDeletrarPorIDModel() throws JsonProcessingException, Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();
		
		ModelLogin modelLogin = new ModelLogin();
		
		modelLogin.setNomeSobrenome("anderson" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setSenha("123456789" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setCpf("987654321" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setEmail("anderson@gmail.com" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setCelular("62994757240" + Calendar.getInstance().getTimeInMillis());
		
		modelLogin = modelRepository.save(modelLogin);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResultActions retornoApi = mockMvc
									.perform(MockMvcRequestBuilders.delete("/deleteModelPorId/" + modelLogin.getId())
									.content(objectMapper.writeValueAsString(modelLogin))
									.accept(MediaType.APPLICATION_JSON)
									.contentType(MediaType.APPLICATION_JSON));
		
		
		/*Converter o retono da api para um objeto de acesso*/
		
		System.out.println("Retorno da API: " + retornoApi.andReturn().getResponse().getContentAsString());
		System.out.println("Status de retorno: " + retornoApi.andReturn().getResponse().getStatus());
		
		assertEquals("Usuário Removido", retornoApi.andReturn().getResponse().getContentAsString());
		assertEquals(200, retornoApi.andReturn().getResponse().getStatus());
		
		
	}
	
	
	
	/*Obter Model*/
	@Test
	public void testRestApiobterModelID() throws JsonProcessingException, Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();
		
		ModelLogin modelLogin = new ModelLogin();
		
		modelLogin.setNomeSobrenome("anderson" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setSenha("123456789" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setCpf("987654321" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setEmail("anderson@gmail.com" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setCelular("62994757240" + Calendar.getInstance().getTimeInMillis());
		
		modelLogin = modelRepository.save(modelLogin);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResultActions retornoApi = mockMvc
									.perform(MockMvcRequestBuilders.get("/obterModel/" + modelLogin.getId())
									.content(objectMapper.writeValueAsString(modelLogin))
									.accept(MediaType.APPLICATION_JSON)
									.contentType(MediaType.APPLICATION_JSON));
		
		
		assertEquals(200, retornoApi.andReturn().getResponse().getStatus());
		
		ModelLogin modelRetorno = objectMapper.readValue(retornoApi.andReturn().getResponse().getContentAsString(), ModelLogin.class);
		
		assertEquals(modelLogin.getNomeSobrenome(), modelRetorno.getNomeSobrenome());
		assertEquals(modelLogin.getSenha(), modelRetorno.getSenha());
		assertEquals(modelLogin.getCpf(), modelRetorno.getCpf());
		assertEquals(modelLogin.getEmail(), modelRetorno.getEmail());
		assertEquals(modelLogin.getCelular(), modelRetorno.getCelular());
		
		
	}
	
	
	
	/*Obter Model*/
	@Test
	public void testRestApiObterModelNome() throws JsonProcessingException, Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();
		
		ModelLogin modelLogin = new ModelLogin();
		
		modelLogin.setNomeSobrenome("anderson" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setSenha("123456789" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setCpf("987654321" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setEmail("anderson@gmail.com" + Calendar.getInstance().getTimeInMillis());
		modelLogin.setCelular("62994757240" + Calendar.getInstance().getTimeInMillis());
		
		modelLogin = modelRepository.save(modelLogin);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResultActions retornoApi = mockMvc
									.perform(MockMvcRequestBuilders.get("/buscarPorModel/testeObterList")
									.content(objectMapper.writeValueAsString(modelLogin))
									.accept(MediaType.APPLICATION_JSON)
									.contentType(MediaType.APPLICATION_JSON));
		
		
		assertEquals(200, retornoApi.andReturn().getResponse().getStatus());
		
		
		List<ModelLogin> retornoApiList = objectMapper.readValue(retornoApi.andReturn().getResponse().getContentAsString(), new TypeReference<List<ModelLogin>> () {});
		
		assertEquals(1, retornoApiList.size());
		
		assertEquals(modelLogin.getNomeSobrenome(), retornoApiList.get(0).getNomeSobrenome());
		assertEquals(modelLogin.getSenha(), retornoApiList.get(0).getSenha());
		assertEquals(modelLogin.getCpf(), retornoApiList.get(0).getCpf());
		assertEquals(modelLogin.getEmail(), retornoApiList.get(0).getEmail());
		assertEquals(modelLogin.getCelular(), retornoApiList.get(0).getCelular());
		
		
		modelRepository.deleteById(modelLogin.getId());
	}


	@Test
	public void testCadastraModel() throws ExceptionMentoriaJava {
		
	ModelLogin model = new ModelLogin();
		
	model.setNomeSobrenome("anderson" + Calendar.getInstance().getTimeInMillis());
	model.setSenha("123456789" + Calendar.getInstance().getTimeInMillis());
	model.setCpf("987654321" + Calendar.getInstance().getTimeInMillis());
	model.setEmail("anderson@gmail.com" + Calendar.getInstance().getTimeInMillis());
	model.setCelular("62994757240" + Calendar.getInstance().getTimeInMillis());
		
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
