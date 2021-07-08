package br.com.generation.blogpessoal.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotNull
		@Size (min = 2, max = 100)
		private String nome;
		
		@NotNull
		@Email
		@Size (min = 2, max = 100)
		private String usuario;
		
		@NotNull
		@Size(min = 5)
		private String senha;
		
		@Column(name = "dt_nascimento")
		@JsonFormat(pattern="yyyy-MM-dd")
	    private LocalDate dataNascimento; // Atributo adicional
			
		@OneToMany (mappedBy = "usuario", cascade = CascadeType.REMOVE)// remove --> se apagar o usuario ai sim apaga o usuario 
		@JsonIgnoreProperties("usuario")
		private List <Postagem> postagem;
		
		public Usuario() {
			super();
		}

		public Usuario(Long id, @NotNull @Size(min = 2, max = 100) String nome,
				@NotNull @Email @Size(min = 2, max = 100) String usuario, @NotNull @Size(min = 5) String senha,
				LocalDate dataNascimento) {
			super();
			this.id = id;
			this.nome = nome;
			this.usuario = usuario;
			this.senha = senha;
			this.dataNascimento = dataNascimento;
		}


		public long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getUsuario() {
			return usuario;
		}


		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}


		public String getSenha() {
			return senha;
		}


		public void setSenha(String senha) {
			this.senha = senha;
		}


		public List<Postagem> getPostagem() {
			return postagem;
		}


		public void setPostagem(List<Postagem> postagem) {
			this.postagem = postagem;
		}


		public LocalDate getDataNascimento() {
			return dataNascimento;
		}


		public void setDataNascimento(LocalDate dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
    }
