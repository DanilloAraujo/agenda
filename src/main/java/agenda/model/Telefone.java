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
@NamedQuery(name="Telefone.findAll", query="SELECT t FROM Telefone t")
public class Telefone implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_telefone")
	private int idTelefone;

	@Column(name="ds_tipo")
	private String dsTipo;

	@Column(name="nr_telefone")
	private String nrTelefone;

	//bi-directional many-to-one association to Contato
	@ManyToOne
	@JoinColumn(name="id_contato")
	private Contato contato;

	public Telefone() {
	}

	public int getIdTelefone() {
		return this.idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public String getDsTipo() {
		return this.dsTipo;
	}

	public void setDsTipo(String dsTipo) {
		this.dsTipo = dsTipo;
	}

	public String getNrTelefone() {
		return this.nrTelefone;
	}

	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public Contato getContato() {
		return this.contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}