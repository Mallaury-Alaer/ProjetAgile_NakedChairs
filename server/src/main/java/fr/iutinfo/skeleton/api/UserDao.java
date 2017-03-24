package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface UserDao {
    @SqlUpdate("create table users (id integer primary key autoincrement, name varchar(100), role varchar(100), email varchar(100) UNIQUE, passwdHash varchar(64), salt varchar(64), search varchar(1024))")
    void createUserTable();

    @SqlUpdate("insert into users (name,role,email, passwdHash, salt, search) values (:name, :role, :email, :passwdHash, :salt, :search)")
    @GetGeneratedKeys
    int insert(@BindBean() User user);

    @SqlQuery("select * from users where email = :email")
    @RegisterMapperFactory(BeanMapperFactory.class)
    User findByEmail(@Bind("email") String email);

    @SqlQuery("select * from users where search like :email")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<User> search(@Bind("email") String email);

    @SqlUpdate("drop table if exists users")
    void dropUserTable();

    @SqlUpdate("delete from users where email = :email")
    void delete(@Bind("email") int email);

    @SqlQuery("select * from users order by id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<User> all();

    @SqlQuery("select * from users where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    User findById(@Bind("id") int id);

    void close();
}
