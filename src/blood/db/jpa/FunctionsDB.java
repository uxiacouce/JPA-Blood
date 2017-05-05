package blood.db.jpa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;



public interface FunctionsDB <Objeto> {
	public void SQLCreate() throws SQLException;
	public List<Objeto> SQLSelect();
	public void SQLDrop();
	public void SQLInsert(Objeto objeto);
	public List<Objeto> SQLSearch(String nombre);
	public void SQLDelete(Objeto objeto) throws IOException, SQLException;
	public void SQLUpdate(Objeto oldObjeto, Objeto newObjeto) throws IOException , SQLException;
}
