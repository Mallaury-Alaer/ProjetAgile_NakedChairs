package fr.iutinfo.skeleton.api;

import static org.junit.Assert.*;

import javax.swing.text.AbstractDocument.LeafElement;
import javax.validation.constraints.AssertFalse;

import org.eclipse.persistence.internal.jpa.parsing.AbsNode;
import org.junit.Test;

import fr.iutinfo.skeleton.common.dto.UserDto;

public class UserTest {
	User user = new User(96, "Pierre", "Pierre@pierre.caillou", "user", "rocher");
	User ano = user.getAnonymousUser();
    @Test
    public void should_set_salt_at_build () {
        User user = new User();
        assertNotNull(user.getSalt());
        assertFalse(user.getSalt().isEmpty());
    }
    
    @Test
	public void equals() throws Exception {
    	
    	assertFalse(user.equals(new User(98, "Pierre", "Pierre@pierre.caillou", "user", "rocher")));
    	user.setSalt("salt");
    	user.setPasswdHash("psh");
    	assertFalse(user.equals(new String("ok")));
    	User userr = new User(98, "Pierre", "Pierre@pierre.caillou", "user", "rocher");
    	userr.setSalt("salt");
    	userr.setPasswdHash("psh");
    	assertTrue(user.equals(userr));
    	
	}
    
    @Test
   	public void isGoodPassword() throws Exception {
       	User users = new User();
       	assertFalse(users.getAnonymousUser().isGoodPassword("ok"));
       	assertTrue(user.isGoodPassword("rocher"));
       	
   	}
    
    
    @Test
   	public void getsetTest() throws Exception {
       	User users = new User(1,"mails@mail.mail");
       	users.setEmail("mails@mail.mail");
       	assertEquals(users.getEmail(),"mails@mail.mail");
       	users.setId(2);
       	assertEquals(users.getId(), 2);
       	users.setName("coucou");
       	assertEquals(users.getName(), "coucou");
       	users.setPassword("mdp");
       	assertEquals(users.getPassword(), "mdp");
     	users.setPasswdHash("mdp");
       	assertEquals(users.getPasswdHash(), "mdp");
       	users.setrole("role");
       	assertEquals(users.getrole(), "role");       	
   	}
    
    @Test
   	public void toStringTest() throws Exception {
    	assertEquals(user.toString(), "96: user, Pierre <Pierre@pierre.caillou>");
    }
    
    
    @Test
   	public void resetpshTest() throws Exception {
    	String psh = user.getPasswdHash();
    	user.resetPasswordHash();
    	assertEquals(user.getPasswdHash(), psh);
    	user.setPassword(null);
    	user.resetPasswordHash();

    	user.setPassword("");
    	user.resetPasswordHash();
    	
    }
    
    @Test
   	public void userInGroupeTest() throws Exception {
    	assertFalse(ano.isInUserGroup());
    	assertTrue(user.isInUserGroup());
    }

    @Test
   	public void searchTest() throws Exception {
    	assertEquals(user.getSearch(), "Pierre user Pierre@pierre.caillou");
    	user.setSearch("ok");
    }
    
    @Test
   	public void userDtoTest() throws Exception {
    	UserDto userDto = user.convertToDto();
    	User userIni = new User();
    	userIni.initFromDto(userDto);
    	assertEquals(user.toString(), userIni.toString());
    }
}