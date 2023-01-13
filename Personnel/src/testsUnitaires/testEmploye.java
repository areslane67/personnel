package testsUnitaires;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;


import personnel.*;


import java.time.LocalDate;

public class testEmploye {
	
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();

	@Test
	void isAdmin() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "admin", null, null);
		assertFalse(employe.estAdmin(ligue));
		ligue.setAdministrateur(employe);
		assertTrue(employe.estAdmin(ligue));
	}
	@Test
	void isRoot() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		Employe employe = gestionPersonnel.getRoot();
		Employe employe2 = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "admin", null, null);
		assertTrue(employe.estRoot());
		assertFalse(employe2.estRoot());
	}
	@Test
	void getNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "admin", null, null);
		assertEquals("Bouchard", employe.getNom());
	}
	
	@Test
	void setNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "admin", null, null);
		employe.setNom("Haddadi");
		assertEquals("Haddadi", employe.getNom());
	}
	@Test
	void getPrenom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "admin", null, null);
		assertEquals("Gerard", employe.getPrenom());
	}
	
	@Test
	void setPrenom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "admin", null, null);
		employe.setPrenom("Areslane");
		assertEquals("Areslane", employe.getPrenom());
	}
	@Test
	void getMail() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "admin", null, null);
		assertEquals("g.bouchard@gmail.com", employe.getMail());
		
	}

	@Test
	void setMail() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "admin", null, null);
		employe.setMail("Ares@gmail.com");
		assertEquals("Ares@gmail.com", employe.getMail());
	}
	@Test
	void getLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "admin", null, null);
		assertEquals(ligue, employe.getLigue());
	}
	
	
	@Test
	void getDateDepart() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "admin", LocalDate.parse("2020-12-28"), LocalDate.parse("2020-12-30"));
		assertEquals(LocalDate.parse("2020-12-30"), employe.getDateDepart());
	}
	@Test
	void getDateArrive() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "admin", LocalDate.parse("2020-12-28"), LocalDate.parse("2020-12-30"));
		assertEquals(LocalDate.parse("2020-12-28"), employe.getDateArrivee());
	}
	@Test
	void checkPassword() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "admin", null, null);
		assertFalse(employe.checkPassword("admiN"));
		assertTrue(employe.checkPassword("admin"));
	}
	
	@Test
	void setPassword() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "admin", null, null);
		employe.setPassword("Ares91");
		assertFalse(employe.checkPassword("Ares"));
		assertTrue(employe.checkPassword("Ares91"));
	}
	@Test
	void remove() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Flechettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "admin", null, null);
		employe.remove();
		assertEquals(0, ligue.getEmployes().size());
	}

		
	
		 
}