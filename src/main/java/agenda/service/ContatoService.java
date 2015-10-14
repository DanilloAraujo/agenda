package agenda.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import agenda.dao.ContatoDAO;
import agenda.model.Contato;

@Path("/contatos")
@Stateless
public class ContatoService {
	@Inject
	private ContatoDAO contatoDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Contato> listAll() {
		return contatoDAO.listAll();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") Integer id) {
		Contato contato = contatoDAO.getById(id);
		if (contato == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		System.out.println("findById " + id + ": found contato = " + contato);
		return Response.ok(contato).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createContato(Contato contato) {
		System.out.println("createMember started. Member = " + contato);
		Response.ResponseBuilder builder = null;
		try {

			contatoDAO.insert(contato);
			builder = Response.ok().entity(contato);

			System.out.println("createMember completed. Member = " + contato);

		} catch (Exception e) {
			System.out.println("Exception - " + e.toString());

			Map<String, String> responseObj = new HashMap<String, String>();
			responseObj.put("error", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(
					responseObj);
		}
		return builder.build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateContato(Contato contato) {
		System.out.println("updateMember started. Member = " + contato);
		Response.ResponseBuilder builder = null;
		try {

			contatoDAO.update(contato);

			builder = Response.ok().entity(contato);
			System.out.println("updateMember completed. Member = " + contato);
		} catch (Exception e) {
			System.out.println("Exception - " + e.toString());
			Map<String, String> responseObj = new HashMap<String, String>();
			responseObj.put("error", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(
					responseObj);

		}
		return builder.build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteContato(Contato contato) {
		System.out.println("deleteMember started. Member = " + contato);
		Response.ResponseBuilder builder = null;

		try {
			if (contato.getIdContato() != null) {
				contatoDAO.delete(contato);
			} else {
				System.out
						.println("MemberService - deleteMember - No ID was found so can't Delete.");
			}

			builder = Response.ok().entity(contato);
			System.out.println("deleteMember completed. Member = " + contato);
		} catch (Exception e) {
			System.out.println("Exception - " + e.toString());

			Map<String, String> responseObj = new HashMap<String, String>();
			responseObj.put("error", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(
					responseObj);
		}
		return builder.build();
	}

}