package Clone_Flix_service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Clone_Flix_model.ModelLogin;
import Clone_Flix_repository.ModelRepository;
import Clone_Flix_repository.UsuarioRepository;

@Service
public class ModelUserService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ModelRepository modelRepository;
	
	
	
	public ModelLogin salvarPessoaModel(ModelLogin modelLoginSalvar) {
		
		modelLoginSalvar = modelRepository.save(modelLoginSalvar);
		
		ModelLogin modelLogin = usuarioRepository.findUserByPessoa(modelLoginSalvar.getId(), modelLoginSalvar.getEmail());
		
		if(modelLogin == null ) {
			
			
			modelLogin = new ModelLogin();
			modelLogin.setNomeSobrenome(modelLoginSalvar.getNomeSobrenome());
			modelLogin.setCelular(modelLoginSalvar.getCelular());
			modelLogin.setCpf(modelLoginSalvar.getCpf());
			modelLogin.setEmail(modelLoginSalvar.getEmail());
			
			String senha = "" + Calendar.getInstance().getTimeInMillis();
			String senhaCript = new BCryptPasswordEncoder().encode(senha);
			
			modelLogin.setSenha(senhaCript);
			
			modelLogin = usuarioRepository.save(modelLogin);
			
			
			
			
		}
		
		return modelLoginSalvar;
		
	}

}
