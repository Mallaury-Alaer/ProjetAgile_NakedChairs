package fr.iutinfo.skeleton.api;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.iutinfo.skeleton.common.dto.AssocieDto;
import fr.iutinfo.skeleton.common.dto.UserDto;

public class associeTest {

	Associe a = new Associe("fournisseur","om","adresse","ville", "type","statut","diplome","mail","telephone",5,3,1,"oui");
	@Test
	public void testGetDispo() {
		assertEquals(a.getDispo(), "oui");
	}

	@Test
	public void testSetDispo() {
		a.setDispo("non");
		assertEquals(a.getDispo(), "non");
	}

	@Test
	public void testGetId() {
		a.setId(1);
		assertEquals(a.getId(),1 );
	}

	@Test
	public void testSetId() {
		a.setId(1);
		assertEquals(a.getId(),1 );
	}

	@Test
	public void testGetValide() {
		assertEquals(a.getValide(),1 );
	}

	@Test
	public void testSetValide() {
		a.setValide(0);
		assertEquals(a.getValide(),0 );
	}

	@Test
	public void testGetMail() {
		
		assertEquals(a.getMail(),"mail" );
	}

	@Test
	public void testSetMail() {
		a.setMail("m");
		assertEquals(a.getMail(),"m" );
	}

	@Test
	public void testGetTelephone() {
		assertEquals(a.getTelephone(),"telephone" );
	}

	@Test
	public void testSetTelephone() {
		a.setTelephone("t");
		assertEquals(a.getTelephone(),"t" );
	}

	@Test
	public void testAssocie() {
		assertNotEquals(new Associe(),new Associe());
	}

	@Test
	public void testGetFoc() {
		assertEquals(a.getFoc(), "fournisseur");
	}

	@Test
	public void testSetFoc() {
		a.setFoc("foc");
		assertEquals(a.getFoc(), "foc");
	}

	@Test
	public void testGetNom() {
		assertEquals(a.getNom(),"om");
	}

	@Test
	public void testSetNom() {
		a.setNom("n");
		assertEquals(a.getNom(),"n");
	}

	@Test
	public void testGetAdresse() {
		assertEquals(a.getAdresse(),"adresse");
	}

	@Test
	public void testSetAdresse() {
		a.setAdresse("a");
		assertEquals(a.getAdresse(),"a");;
	}

	@Test
	public void testGetVille() {
		assertEquals(a.getVille(),"ville");
		}

	@Test
	public void testSetVille() {
		a.setVille("v");
		assertEquals(a.getVille(), "v");
	}

	@Test
	public void testGetType() {
		assertEquals(a.getType(), "type");
	}

	@Test
	public void testSetType() {
		a.setType("t");
		assertEquals(a.getType(), "t");
	}

	@Test
	public void testGetStatut() {
		assertEquals(a.getStatut(), "statut");
	}

	@Test
	public void testSetStatut() {
		a.setStatut("s");
		assertEquals(a.getStatut(), "s");
	}

	@Test
	public void testGetDiplome() {
		assertEquals(a.getDiplome(),"diplome");
	}

	@Test
	public void testSetDiplome() {
		a.setDiplome("d");
		assertEquals(a.getDiplome(), "d");
	}

	@Test
	public void testGetAnnexp() {
		assertEquals(a.getAnnexp(), 5);
	}

	@Test
	public void testSetAnnexp() {
		a.setAnnexp(3);
		assertEquals(a.getAnnexp(), 3);
	}

	@Test
	public void testGetHeuresSemaine() {
		assertEquals(a.getHeuresSemaine(), 3);
	}

	@Test
	public void testSetHeuresSemaine() {
		a.setHeuresSemaine(6);
		assertEquals(a.getHeuresSemaine(), 6);
	}

	@Test
	public void testDto() {
		AssocieDto associeDto = a.convertToDto();
    	Associe associeini = new Associe();
    	associeini.initFromDto(associeDto);
    	assertEquals(a.toString(), associeini.toString());
	}

	

}
