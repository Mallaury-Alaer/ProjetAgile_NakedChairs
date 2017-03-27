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
    @SqlUpdate("create table associe (nom varchar(100) primary key,foc varchar(100),adresse varchar(100),ville varchar(100), type varchar(100),statut varchar(100),diplome varchar(100), annexp integer,heuresSemaine integer,mail varchar(100),telephone integer,valide integer);")
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
    
    void close();
}