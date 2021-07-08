package br.com.generation.blogpessoal.repository;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.com.generation.blogpessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {


		@Autowired
		private UsuarioRepository usuarioRepository;

		@BeforeAll
		public void start() {
			Usuario usuario = new Usuario(null, "Chefe", "0y", "9xxxxxxx9");
			if (usuarioRepository.findByNome(usuario.getNome()) == null)
				usuarioRepository.save(usuario);

			usuario = new Usuario(null, "Novo Chefe", "0y", "8xxxxxxx8");
			if (usuarioRepository.findByNome(usuario.getNome()) == null)
				usuarioRepository.save(usuario);

			usuario = new Usuario(null, "chefe Mais Antigo", "0y", "7xxxxxxx7");
			if (usuarioRepository.findByNome(usuario.getNome()) == null)
				usuarioRepository.save(usuario);

			usuario = new Usuario(null, "Amigo", "0z", "5xxxxxxx5");
			if (usuarioRepository.findByNome(usuario.getNome()) == null)
				usuarioRepository.save(usuario);
		}

		@Test
		public void findByNomeRetornaContato() throws Exception {

			Usuario usuario = usuarioRepository.findByNome("Chefe");

			assertTrue(usuario.getNome().equals("Chefe"));
		}

		@Test
		public void findAllByNomeIgnoreCaseRetornaTresContato() {

			List<Usuario> usuario = usuarioRepository.findAllByNomeIgnoreCaseContaining("chefe");

			assertEquals(3, usuario.size());
		}

		@AfterAll
		public void end() {
			usuarioRepository.deleteAll();
		}
}
