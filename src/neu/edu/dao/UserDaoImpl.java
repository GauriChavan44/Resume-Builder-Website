package neu.edu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.entity.*;

@Service
public class UserDaoImpl implements UserAccountDAO {

	public UserDaoImpl() {
		super();
	}

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Users validateUser(String username, String password) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Users " + "where USER_NAME=:un " + "and password=:pass");
		query.setString("un", username);
		query.setString("pass", password);

		List<Users> userAccounts = (List<Users>) query.list();
		if (userAccounts.size() > 0) {
			return userAccounts.get(0);
		}
		try {
			session.close();
		} catch (Exception ex) {

		}
		return null;
	}

	@Override
	public Users validateUserSQL(String username, String password) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select * from Users where userName=:un and password=:pass ");
		query.setString("un", username);
		query.setString("pass", password);

		List userAccounts = query.list();
		Object row[];
		if (userAccounts.size() > 0) {
			row = (Object[]) userAccounts.get(0);
			Users userAccount = new Users((String) row[0], (String) row[1], (String) row[2], (String) row[3],
					(String) row[4], (Integer) row[5]);
			return userAccount;
		}
		try {
			session.close();
		} catch (Exception ex) {

		}
		return null;
	}

	@Override
	public boolean checkIfUserNamePresent(String userName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select * from USERS where UPPER(USER_NAME)=:un");
		query.setString("un", userName);

		List userAccounts = query.list();
		Object row[];
		if (userAccounts.size() > 0) {
			return true;
		}
		try {
			session.close();
		} catch (Exception ex) {

		}
		return false;
	}

	@Override
	@Transactional
	public boolean createUser(Users userAccount) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.persist(userAccount);
		return true;
	}

	@Override
	@Transactional
	public boolean createAboutMe(AboutMeTable aboutMeUser) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.persist(aboutMeUser);
		return true;
	}

	@Override
	@Transactional
	public boolean createCity(AddressTable cityAttribute) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(cityAttribute);
		return true;
	}

	@Override
	@Transactional
	public boolean createSession(UserSessionTable sessionAttribute) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(sessionAttribute);
		return true;
	}

	@Override
	@Transactional
	public boolean createEducation(EducationTable educationAttribute) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(educationAttribute);
		return true;
	}

	@Override
	@Transactional
	public boolean createProject(ProjectTable projectAttribute) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(projectAttribute);
		return true;
	}

	@Override
	@Transactional
	public boolean createSkill(SkillTable skillAttribute) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(skillAttribute);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteUser(Users userAccount) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(userAccount);
		return true;
	}

	@Override
	@Transactional
	public boolean updateUser(Users userAccount, AboutMeTable aboutMeAttribute, AddressTable cityAttribute,
			EducationTable educationAttribute, ProjectTable projectAttribute, SkillTable skillAttribute) {
		Session session = sessionFactory.getCurrentSession();
		session.update(userAccount);
		session.update(aboutMeAttribute);
		session.update(cityAttribute);
		session.update(educationAttribute);
		session.update(projectAttribute);
		session.update(skillAttribute);
		return true;
	}

	@Override
	@Transactional
	public void createUserResume(Users user, AboutMeTable aboutMeAttribute, AddressTable cityAttribute,
			EducationTable educationAttribute, ProjectTable projectAttribute, SkillTable skillAttribute) {

		Session session = sessionFactory.getCurrentSession();

		session.save(user);
		session.save(aboutMeAttribute);
		session.save(cityAttribute);
		session.save(educationAttribute);
		session.save(projectAttribute);
		session.save(skillAttribute);

	}

	@Override
	public AboutMeTable validateAboutMe(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from AboutMeTable " + "where user_name=:un ");
		query.setString("un", username);
		// query.setString("pass", password);

		List<AboutMeTable> AboutMeTablerows = (List<AboutMeTable>) query.list();
		if (AboutMeTablerows.size() > 0) {
			return AboutMeTablerows.get(0);
		}
		try {
			session.close();
		} catch (Exception ex) {

		}
		return null;
	}

	@Override
	public AddressTable validateCity(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from AddressTable " + "where user_name=:un ");
		query.setString("un", username);
		// query.setString("pass", password);

		List<AddressTable> addressTableRows = (List<AddressTable>) query.list();
		if (addressTableRows.size() > 0) {
			return addressTableRows.get(0);
		}
		try {
			session.close();
		} catch (Exception ex) {

		}
		return null;
	}

	public EducationTable validateEducation(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from EducationTable " + "where user_name=:un ");
		query.setString("un", username);

		List<EducationTable> EducationTablerows = (List<EducationTable>) query.list();
		if (EducationTablerows.size() > 0) {
			return EducationTablerows.get(0);
		}
		try {
			session.close();
		} catch (Exception ex) {

		}
		return null;
	}

	public ProjectTable validateProject(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from ProjectTable " + "where user_name=:un ");
		query.setString("un", username);

		List<ProjectTable> ProjectTablerows = (List<ProjectTable>) query.list();
		if (ProjectTablerows.size() > 0) {
			return ProjectTablerows.get(0);
		}
		try {
			session.close();
		} catch (Exception ex) {

		}
		return null;
	}

	@Override
	public SkillTable validateSkill(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from SkillTable " + "where user_name=:un ");
		query.setString("un", username);

		List<SkillTable> SkillTablerows = (List<SkillTable>) query.list();
		if (SkillTablerows.size() > 0) {
			return SkillTablerows.get(0);
		}
		try {
			session.close();
		} catch (Exception ex) {

		}
		return null;
	}
}
