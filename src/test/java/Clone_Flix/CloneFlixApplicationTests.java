package Clone_Flix;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
		
		modelLogin.setNomeSobrenome("Lucas Henrique1 zz");
		modelLogin.setSenha("123445678419");
		modelLogin.setCpf("00000000421200001");
		modelLogin.setEmail("lucashsdkhj00001@gmail.com");
		modelLogin.setCelular("62994757240");
		
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
		
		modelLogin.setNomeSobrenome("Bruno Henrique");
		modelLogin.setSenha("1234456718419");
		modelLogin.setCpf("7530124138100011");
		modelLogin.setEmail("bruninho6@gmail.com");
		modelLogin.setCelular("62994757240");
		
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
		
		modelLogin.setNomeSobrenome("BrunoHenrique_ID");
		modelLogin.setSenha("1234456718419");
		modelLogin.setCpf("7530124138100011");
		modelLogin.setEmail("bruninho6@gmail.com");
		modelLogin.setCelular("62994757240");
		
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
		
		modelLogin.setNomeSobrenome("Brunocscscscs");
		modelLogin.setSenha("123445671218419");
		modelLogin.setCpf("7530141112124138100011");
		modelLogin.setEmail("bruninshnnhxzzho6@gmail.com");
		modelLogin.setCelular("62994757240");
		
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
		
		modelLogin.setNomeSobrenome("testeObterList");
		modelLogin.setSenha("123445671218419");
		modelLogin.setCpf("111111111111111411");
		modelLogin.setEmail("testeObterList14@gmail.com");
		modelLogin.setCelular("62994757240");
		
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
