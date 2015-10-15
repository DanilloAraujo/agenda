package agenda.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import agenda.dao.ContatoDAO;
import agenda.dao.EnderecoDAO;
import agenda.dao.TelefoneDAO;
import agenda.model.Contato;
import agenda.model.Endereco;
import agenda.model.Telefone;
import agenda.util.FacesMessages;

@SessionScoped
@Named(value = "contatoBean")
public class ContatoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Contato contato = new Contato();

	private Endereco endereco = new Endereco();

	private Telefone telefone = new Telefone();

	private List<Contato> contatos = new ArrayList<Contato>();

	@Inject
	private FacesMessages facesMessages;

	@Inject
	private ContatoDAO contatoDAO;

	@Inject
	private EnderecoDAO enderecoDAO;

	@Inject
	private TelefoneDAO telefoneDAO;

	public ContatoBean() {

	}

	@PostConstruct
	private void iniciar() {
		listarContatos();
	}

	public void novo() {
		contato = new Contato();
		endereco = new Endereco();
		telefone = new Telefone();
	}

	private void listarContatos() {
		contatos = contatoDAO.listAll();
	}

	public void salvar() {
		if (contato.getIdContato() != null) {

			contatoDAO.update(contato);

			/*
			 * endereco.setContato(contato); enderecoDAO.update(endereco);
			 * 
			 * telefone.setContato(contato); telefoneDAO.update(telefone);
			 */
			facesMessages.info("Contato atualizado com sucesso!");

		} else {

			contatoDAO.insert(contato);

			/*
			 * endereco.setContato(contato); enderecoDAO.insert(endereco);
			 * 
			 * telefone.setContato(contato); telefoneDAO.insert(telefone);
			 */
			facesMessages.info("Contato adicionado com sucesso!");
		}
		listarContatos();
		novo();

	}

	public void remover() {
		contatoDAO.delete(contato);
		listarContatos();
		novo();
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

}
