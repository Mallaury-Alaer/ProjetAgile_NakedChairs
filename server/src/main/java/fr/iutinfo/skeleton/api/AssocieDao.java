package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface AssocieDao {
    @SqlUpdate("create table associe (nom varchar(100) primary key,foc varchar(100),adresse varchar(100),ville varchar(100), type varchar(100),statut varchar(100),diplome varchar(100), annexp integer,heuresSemaine integer,mail varchar(100),telephone varchar(100),valide integer);")
    void createUserTable();
    
    @SqlUpdate("insert into associe values (:nom, :foc , :adresse, :ville, :type, :statut, :diplome, :annexp, :heuresSemaine, :mail, :telephone, :valide)")
    @GetGeneratedKeys
    int insert(@BindBean() Associe associe);
    
    @SqlQuery("select * from associe where nom = :nom")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Associe findByName(@Bind("nom") String nom);
    
    @SqlQuery("select * from associe")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Associe> affiche();
    /*
    @SqlUpdate("update associe set adresse = :adresse, ville = :ville , type = :type, statut = :statut, diplome = :diplome, annexp = :annexp, heuresSemaine = :heuresSemaine, mail = :mail, telephone = :telephone, valide = :valide where nom = :nom")
    void Update(@Bind("nom") String nom,@Bind("adresse") String adresse,@Bind("ville") String ville,@Bind("type") String type,@Bind("statut") String statut,@Bind("diplome") String diplome,@Bind("annexp") int annexp,@Bind("heuresSemaine") int heuresSemaine,@Bind("mail") String mail,@Bind("telephone") String telephone,@Bind("valide") int valide);
    */
    @SqlUpdate("delete from associe where nom = :nom")
    void delete(@Bind("nom") String nom);
    
    @SqlUpdate("update associe set valide = 1 where nom = :nom")
    void Update(@Bind("nom") String nom);
    
    void close();
}