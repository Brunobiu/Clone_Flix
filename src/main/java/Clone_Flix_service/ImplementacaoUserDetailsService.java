package Clone_Flix_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Clone_Flix_model.ModelLogin;
import Clone_Flix_repository.UsuarioRepository;

@Service
public class ImplementacaoUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		ModelLogin modelLogin = usuarioRepository.findUserByLogin(username); /*Recebe login pra consulta*/
		
		if (modelLogin == null) {
			throw new UsernameNotFoundException("Usuario nao foi encontrado");
		
		}
		
		return new User(modelLogin.getNomeSobrenome(), modelLogin.getSenha(), modelLogin.getAuthorities());
	}

	
	
	
}
