package fr.iutinfo.skeleton.api;
import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.api.Associe;
import fr.iutinfo.skeleton.api.AssocieDao;
import fr.iutinfo.skeleton.common.dto.AssocieDto;
import fr.iutinfo.skeleton.common.dto.TissuDto;


@Path("/associe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AssocieResource {
	   private static AssocieDao dao = getDbi().open(AssocieDao.class);

	    public AssocieResource() throws SQLException {
	        if (!tableExist("associe")) {
	            dao.createUserTable();
	            dao.insert(new Associe("FoC","nom","adresse","ville","type","statut","diplome","mail","0320424242",5,15,0,"Dispo"));
	        }
	    }
	    
	    @GET
	    public List<AssocieDto> getAllAssocie() {
	        List<Associe> associe;
	        associe = dao.affiche();

	        return associe.stream().map(Associe::convertToDto).collect(Collectors.toList());
	    }
	    
	    @GET
	    @Path("/{nom}")
	    public AssocieDto getOneTissu(@PathParam("nom") String nom) {
	        Associe associe = dao.findByName(nom);
	        if (associe == null) {
	            throw new WebApplicationException(404);
	        }
	        return associe.convertToDto();
	    }
    
	    @POST
	    public AssocieDto AddAssocie(AssocieDto dto){
	        Associe associe = new Associe();
	        associe.initFromDto(dto);
	        dao.insert(associe);
	        return dto;
	    }
	    
	    @DELETE
	    @Path("/{nom}")
	    public void deleteAssocie(@PathParam("nom") String nom) {
	        dao.delete(nom);
	    }
	    
	   /*
	    @PUT
	    @Path("/{nom}")
	    public void UpdateAssocie(@PathParam("nom") String nom, @PathParam("adresse") String adresse,@PathParam("ville") String ville,@PathParam("type") String type,@PathParam("statut") String statut,@PathParam("diplome") String diplome,@PathParam("annexp") int annexp,@PathParam("heuresSemaine") int heuresSemaine,@PathParam("mail") String mail,@PathParam("telephone") String telephone, @PathParam("valide") int valide) {
	        dao.Update(nom, adresse, ville, type, statut, diplome, annexp, heuresSemaine, mail, telephone, valide);
	    }
	    */
	    @PUT
	    @Path("/{nom}")
	    public void UpdateAssocie(@PathParam("nom") String nom) {
	        dao.Update(nom);
	    }
	 
}
