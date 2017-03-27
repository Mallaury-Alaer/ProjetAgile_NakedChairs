package fr.iutinfo.skeleton.api;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import fr.iutinfo.skeleton.common.dto.PanierDto;

@Path("/panier")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PanierResource {
	   private static PanierDao dao = getDbi().open(PanierDao.class);

	    public PanierResource() throws SQLException {
	        if (!tableExist("panier")) {
	            dao.createUserTable();
	            dao.insert(new Panier("dossier","formeDossier", "accoudoir", "assise","tissu",
	        			"utilisateur", 10, 9, 8, 7,
	        			6,5, 4));
	        }
	    }
	    
	    @GET
	    public List<PanierDto> getAllAssocie() {
	        List<Panier> panier;
	        panier = dao.affiche();

	        return panier.stream().map(Panier::convertToDto).collect(Collectors.toList());
	    }
	    
	    @GET
	    @Path("/{id}")
	    public PanierDto getOneTissu(@PathParam("id") int id) {
	        Panier panier = dao.findByName(id);
	        if (panier == null) {
	            throw new WebApplicationException(404);
	        }
	        return panier.convertToDto();
	    }
   
	    @POST
	    public PanierDto AddAssocie(PanierDto dto){
	        Panier panier = new Panier();
	        panier.initFromDto(dto);
	        dao.insert(panier);
	        return dto;
	    }

}
