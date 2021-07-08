package br.com.generation.blogpessoal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.blogpessoal.model.UsuarioLogin;
import br.com.generation.blogpessoal.model.Usuario;
import br.com.generation.blogpessoal.repository.UsuarioRepository;
import br.com.generation.blogpessoal.service.UsuarioService;

@RestController // diz que a classe é controller
@RequestMapping("/usuarios") //caminho para acessar as informaçoes da classe
@CrossOrigin(origins = "*", allowedHeaders = "*") // aceitar informaçao de qualquer lugar - frontend
public class UsuarioController {

		@Autowired
		private UsuarioRepository usuarioRepository;

		@Autowired
		private UsuarioService usuarioService;

		@GetMapping("/all")
		public ResponseEntity<List<Usuario>> getAll() {
			return ResponseEntity.ok(usuarioRepository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Usuario> getById(@PathVariable long id){
			return usuarioRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());				
		}

		@PostMapping("/logar")
		public ResponseEntity<UsuarioLogin> autenticationUsuario(@RequestBody Optional<UsuarioLogin> usuario) {
			return usuarioService.logarUsuario(usuario).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
		}

		@PostMapping("/cadastrar")
		public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario) {
			Optional<Usuario> novoUsuario = usuarioService.cadastrarUsuario(usuario);
			try {
					return ResponseEntity.ok(novoUsuario.get());
			} catch (Exception e) {
				return ResponseEntity.badRequest().build();
			}
			
		}
		
		@PutMapping("/alterar")
		public ResponseEntity<Usuario> putUsuario(@RequestBody Usuario usuario){
			Optional<Usuario> updateUsuario = usuarioService.atualizarUsuario(usuario);
			try {
				return ResponseEntity.ok(updateUsuario.get());
			} catch (Exception e) {
				return ResponseEntity.badRequest().build();
			}
		}

	}

