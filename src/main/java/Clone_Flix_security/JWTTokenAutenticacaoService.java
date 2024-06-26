package Clone_Flix_security;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import Clone_Flix.ApplicationContextLoad;
import Clone_Flix_model.ModelLogin;
import Clone_Flix_repository.UsuarioRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

/*Criar autenticação e retornar autenticação JWT*/
@Service
@Component
public class JWTTokenAutenticacaoService {
	
		
		/*Token de validade de 11 dias*/
		private static final long EXPIRATION_TIME = 999990000;
		
		/*Chave de senha para juntar com JWT*/
		private static final String SECRET = "vsd65v45df4b6g4b665jhg4b45t554654v23zscczscs";
		
		private static final String TOKEN_PREFIX = "Bearer";
		
		private static final String HEADER_STRING = "Authorization";
		
		/*Ger o token e da resposta para o cliente com JWT*/
		public void addAuthentication(HttpServletResponse response, String username) throws Exception {
			
			/*mostagem do token*/
			
			String JWT = Jwts.builder(). /*Chama o gerador de token */
					setSubject(username) /*Adiciona o user*/
					.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) /*Tempo de expiração*/
					.signWith(SignatureAlgorithm.HS512, SECRET).compact();
			
			/*Exemplo: Bearer s65cwe6c56ev6berg5hthry4ty4jyu6j44665ret256hy654vd*/
			String token = TOKEN_PREFIX + " " + JWT;
			
			/*Dá a resposta para a tela e para o client, outra API, Navegador, aplicatico, javascript, outra chamadajava*/
			response.addHeader(HEADER_STRING, token);
			
			liberacaoCors(response);
			
			
			/*Usado para ver no postman para teste*/
			response.getWriter().write("{\"Authorization\": \"" + token + "\"}");
		}
		
		
		/*Retorna o usuario validade com token ou caso nao seja validado retorna null*/
		public org.springframework.security.core.Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			String token = request.getHeader(HEADER_STRING);
			
			try {
			
				if (token != null) {
					
					String tokenLimpo = token.replace(TOKEN_PREFIX, "").trim();
					
					/*Faz a validação do token do usuario na requisição*/
					String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(tokenLimpo).getBody().getSubject(); /*ADMIN ou Bruno*/
					
					if(user != null) {
						
						ModelLogin login = ApplicationContextLoad.getApplicationContext().getBean(UsuarioRepository.class).findUserByLogin(user);
						
						if(login != null) {
							return new UsernamePasswordAuthenticationToken(login.getNomeSobrenome(), login.getSenha(), login.getAuthorities());
						}
						
					}
				
				}
			}catch (SignatureException e) {
				response.getWriter().write("Token esta invalido");
				
			}catch (ExpiredJwtException e) {
				response.getWriter().write("Token esta expirado");
			}
			finally {
				liberacaoCors(response);
			}
			return null;
		}
		
		
		
		/*Fazendo liberação contra erro de Cors no navegador*/
		private  void liberacaoCors(HttpServletResponse response) {
			if(response.getHeader("Access-Control-Allow-Origin")== null) {
				response.addHeader("Access-Control-Allow-Origin", "*");
			}
			
			if(response.getHeader("Access-Control-Allow-Headers")== null) {
				response.addHeader("Access-Control-Allow-Headers", "*");
			}
			
			if(response.getHeader("Access-Control-Request-Headers")== null) {
				response.addHeader("Access-Control-Request-Headers", "*");
			}
			
			if(response.getHeader("Access-Control-Allow-Origin")== null) {
				response.addHeader("Access-Control-Allow-Origin", "*");
			}
			
			if(response.getHeader("Access-Control-Allow-Methods")== null) {
				response.addHeader("Access-Control-Allow-Methods", "*");
			}
			
		}
		
		
		

}
