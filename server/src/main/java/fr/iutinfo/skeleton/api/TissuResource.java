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
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import fr.iutinfo.skeleton.common.dto.TissuDto;

@Path("/tissu")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TissuResource {
    private static TissuDAO dao = getDbi().open(TissuDAO.class);

    public TissuResource() throws SQLException {
        if (!tableExist("tissu")) {
            dao.createUserTable();
            dao.insert(new Tissu("Tissu1",10,10));
        }
    }
    
    @GET
    public List<TissuDto> getAllUsers() {
        List<Tissu> tissu;
        tissu = dao.affiche();

        return tissu.stream().map(Tissu::convertToDto).collect(Collectors.toList());
    }
    
    @POST
    public TissuDto AddTissu(TissuDto dto){
        Tissu tissu = new Tissu();
        tissu.initFromDto(dto);
        dao.insert(tissu);
        return dto;
    }

}