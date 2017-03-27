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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import fr.iutinfo.skeleton.common.dto.ImageDto;
import fr.iutinfo.skeleton.common.dto.TissuDto;

@Path("/images")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ImageResource {
    private static ImageDAO dao = getDbi().open(ImageDAO.class);

    public ImageResource() throws SQLException {
        if (!tableExist("images")) {
            dao.createUserTable();
            dao.insert(new Image("dieu","admin@admin.admin", "admin", "01-01-2000"));
        }
    }
    @GET
    public List<ImageDto> getAllImages() {
        List<Image> image;
        image= dao.affiche();

        return image.stream().map(Image::convertToDto).collect(Collectors.toList());
    }

    @POST
    public ImageDto createImage(ImageDto dto) {
        Image image = new Image();
        image.initFromDto(dto);
        int id = dao.insert(image);
        dto.setId(id);
        return dto;
    }

    @GET
    @Path("/{id}")
    public ImageDto getId(@PathParam("id") int id) {
        Image image = dao.findById(id);
        if (image == null) {
            throw new WebApplicationException(404);
        }
        return image.convertToDto();
    }
    
    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") int id) {
        dao.delete(id);
    }

}
