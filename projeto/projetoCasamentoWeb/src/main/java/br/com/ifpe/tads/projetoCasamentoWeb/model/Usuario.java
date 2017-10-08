package br.com.ifpe.tads.projetoCasamentoWeb.model;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "tb_usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "disc_usuario", discriminatorType = DiscriminatorType.STRING, length = 3) // 3 é o tamanho do campo discriminator (disc_usuario)
@Access(AccessType.FIELD)
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 234674128246958091L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_usuario")
	private Integer idUsuario;
	
	@NotNull
	@Column (name = "txt_nome")
	private String nome; 
	
	@NotNull
	@Column (name = "txt_login")
	private String login; 
	
	@NotNull
	@Column (name = "txt_email")
	private String email; 
	
	@NotNull
	@Column (name = "txt_senha")
	private String senha;
	
	@Size(max = 255)
    @Column(name = "str_sal")
    private String sal;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_usuario_grupo", joinColumns = {
        @JoinColumn(name = "id_usuario")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_grupo")})
	private List<Grupo> grupos;
	
	public Usuario () {
	}
	
	public Usuario(String nome, String login, String email, String senha) {
		this.nome = nome;
		this.login = login;
		this.email = email;
		this.senha = senha;
	}
	
	@PrePersist
    public void gerarHash() {
        try {
            gerarSal();
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            setSenha(sal + senha);
            digest.update(senha.getBytes(Charset.forName("UTF-8")));
            setSenha(Base64.getEncoder().encodeToString(digest.digest()));
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void gerarSal() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);
        setSal(Base64.getEncoder().encodeToString(randomBytes));
}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	} 
	
	public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public void setGrupo(Grupo grupo) {
        if (this.grupos == null) {
            this.grupos = new ArrayList<Grupo>();
        }

        this.grupos.add(grupo);
    }

    public List<Grupo> getGrupos() {
        return this.grupos;
}
}
