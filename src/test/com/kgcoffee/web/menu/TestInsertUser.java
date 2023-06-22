package test.com.kgcoffee.web.menu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.kgcoffee.web.users.dao.UsersDAO;

class TestInsertUser {

	@Test
	void testExecute() {

		try {
			UsersDAO dao = UsersDAO.getInstance();

			for (int i = 1; i <= 100; i++) {

				String user_id = "유저" + i;
				String user_pw = "pw" + i;
				String user_name = "유저" + i;
				
				String birthday = "1993-01-01";
				String tel = "010-1234-1234"; 

				assertEquals(true, 
						dao.insert_user(user_id, user_pw, user_name, birthday, tel));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
