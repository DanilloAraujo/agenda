package agenda.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQuery(name = "Contato.findAll", query = "SELECT c FROM Contato c")
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contato")
	private Integer idContato;

	@Column(name = "email_contato")
	private String emailContato;

	@Column(name = "nm_contato")
	private String nmContato;

	/*// bi-directional many-to-one association to Endereco
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "id_contato")
	private List<Endereco> enderecos;*/
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "id_contato")
	private Endereco endereco;

	// bi-directional many-to-one association to Telefone
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "id_contato")
	private List<Telefone> telefones;

	public Contato() {
	}

	public Integer getIdContato() {
		return this.idContato;
	}

	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}

	public String getEmailContato() {
		return this.emailContato;
	}

	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}

	public String getNmContato() {
		return this.nmContato;
	}

	public void setNmContato(String nmContato) {
		this.nmContato = nmContato;
	}

	/*public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco addEndereco(Endereco endereco) {
		getEnderecos().add(endereco);
		endereco.setContato(this);

		return endereco;
	}

	public Endereco removeEndereco(Endereco endereco) {
		getEnderecos().remove(endereco);
		endereco.setContato(null);

		return endereco;
	}*/
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Telefone> getTelefones() {
		return this.telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Telefone addTelefone(Telefone telefone) {
		getTelefones().add(telefone);
		telefone.setContato(this);

		return telefone;
	}

	public Telefone removeTelefone(Telefone telefone) {
		getTelefones().remove(telefone);
		telefone.setContato(null);

		return telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idContato;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (idContato != other.idContato)
			return false;
		return true;
	}

}