package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface ImageDAO {
    @SqlUpdate("create table images (id integer primary key autoincrement, title char(75), url char(512), date char(10), desc char(1024))")
    void createUserTable();

    @SqlUpdate("insert into images (title,url,date,desc) values (:title,:url,:date,:desc)")
    @GetGeneratedKeys
    int insert(@BindBean() Image image);

    @SqlQuery("select * from images order by id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Image> affiche();
    
    @SqlQuery("select * from images where id= :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Image findById(@Bind("id") int id);

    @SqlUpdate("delete from images where id = :id")
    void delete(@Bind("id") int id);
    
    void close();
}
