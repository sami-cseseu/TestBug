package task1;

import java.sql.Connection;

public class DatabaseORM {
	
	public DatabaseORM(Connection connection) {
		// TODO Auto-generated constructor stub
	}
	
	public DatabaseORM() {
		// TODO Auto-generated constructor stub
	}

	public static Table table(String name) {
		return new Table(name);
	}
}
