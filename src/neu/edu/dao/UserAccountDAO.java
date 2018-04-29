package neu.edu.dao;

import neu.edu.entity.*;

public interface UserAccountDAO {
	Users validateUser(String username, String password);

	Users validateUserSQL(String username, String password);

	boolean checkIfUserNamePresent(String userName);

	boolean createUser(Users userAccount);

	boolean createAboutMe(AboutMeTable aboutMeUser);

	boolean deleteUser(Users userAccount);

	boolean updateUser(Users userAccount, AboutMeTable aboutMeAttribute, AddressTable cityAttribute,
			EducationTable educationAttribute, ProjectTable projectAttribute, SkillTable skillAttribute);

	void createUserResume(Users user, AboutMeTable aboutMeAttribute, AddressTable cityAttribute,
			EducationTable educationAttribute, ProjectTable projectAttribute, SkillTable skillAttribute);

	AboutMeTable validateAboutMe(String userParam);

	AddressTable validateCity(String userParam);

	EducationTable validateEducation(String userParam);

	ProjectTable validateProject(String userParam);

	SkillTable validateSkill(String userParam);

	boolean createSession(UserSessionTable sessionAttribute);

	boolean createCity(AddressTable cityAttribute);

	boolean createEducation(EducationTable educationAttribute);

	boolean createProject(ProjectTable projectAttribute);

	boolean createSkill(SkillTable skillAttribute);
}
