package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface PanierDao {
    @SqlUpdate("create table panier(id integer primary key autoincrement,utilisateur varchar(100),dossier varchar(100),formedossier varchar(100),accoudoir varchar(100),assise varchar(100),tissu varchar(100),hauteur double,largeur double,circonference double,profondeurAssise double,largeurAssise double,diametre double,prix double,valide varchar(100));")
    void createUserTable();
    
    @SqlUpdate("insert into panier(utilisateur,dossier,formedossier,accoudoir,assise,tissu,hauteur,largeur,circonference,profondeurAssise,largeurAssise,diametre,prix,valide) values (:utilisateur,:dossier,:formeDossier,:accoudoir,:assise,:tissu,:hauteur,:largeur,:circonference,:profondeurAssise,:largeurAssise,:diametre,:prix, :valide)")
    @GetGeneratedKeys
    int insert(@BindBean() Panier panier);
    
    @SqlQuery("select * from panier where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Panier findByName(@Bind("id") int id);
    
    @SqlQuery("select * from panier")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Panier> affiche();
    
    @SqlUpdate("delete from panier where id = :id")
    void delete(@Bind("id") int id);
    
    @SqlUpdate("update panier set valide = \"Oui\" where id = :id")
    void update(@Bind("id") int id);
    
    void close();

}
