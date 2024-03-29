package py.edu.upa.test.ws;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import py.edu.upa.test.business.CategoriaBC;
import py.edu.upa.test.entity.Categoria;

@Path("categorias")
public class CategoriaService {

	@Inject
	private CategoriaBC bc;

//	http://localhost:8080/ws/rest/categoria/
	@GET
    @Produces("application/json")
	public Response getAll() {
		try {
			return Response.ok().entity(bc.find()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
	}
	
//	http://localhost:8080/ws/rest/categoria/1
    @GET
    @Path("/{id: \\d+}")
    @Produces({"application/json"})
    public Response get(@PathParam("id") Integer id) {
    	try {
			return Response.ok().entity(bc.findById(id)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
    }

	@POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
	public Response add(Categoria c) {
		try {
			bc.insert(c);
			return Response.ok().entity(c).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
	}
    
    @PUT
    @Path("/{id: \\d+}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response update(@PathParam("id") Integer id, Categoria cat) {
    	try {
    		bc.update(id,cat);
			return Response.ok().entity("OK").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
    }
	
    @DELETE
    @Path("/{id: \\d+}")
    @Produces({"application/json"})
    public Response delete(@PathParam("id") Integer id) {
    	try {
    		bc.delete(id);
			return Response.ok().entity("OK").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
    }
       
}
