package agenda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
@Entity
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_endereco")
	private int idEndereco;

	@Column(name="ds_bairro")
	private String dsBairro;

	@Column(name="ds_cidade")
	private String dsCidade;

	@Column(name="ds_complemento")
	private String dsComplemento;

	@Column(name="ds_logradouro")
	private String dsLogradouro;

	@Column(name="ds_tipo_logradouro")
	private String dsTipoLogradouro;

	//bi-directional many-to-one association to Contato
	@ManyToOne
	@JoinColumn(name="id_contato")
	private Contato contato;

	public Endereco() {
	}

	public int getIdEndereco() {
		return this.idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getDsBairro() {
		return this.dsBairro;
	}

	public void setDsBairro(String dsBairro) {
		this.dsBairro = dsBairro;
	}

	public String getDsCidade() {
		return this.dsCidade;
	}

	public void setDsCidade(String dsCidade) {
		this.dsCidade = dsCidade;
	}

	public String getDsComplemento() {
		return this.dsComplemento;
	}

	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}

	public String getDsLogradouro() {
		return this.dsLogradouro;
	}

	public void setDsLogradouro(String dsLogradouro) {
		this.dsLogradouro = dsLogradouro;
	}

	public String getDsTipoLogradouro() {
		return this.dsTipoLogradouro;
	}

	public void setDsTipoLogradouro(String dsTipoLogradouro) {
		this.dsTipoLogradouro = dsTipoLogradouro;
	}

	public Contato getContato() {
		return this.contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}