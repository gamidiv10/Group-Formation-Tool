CREATE TABLE User (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    bannerID VARCHAR(20) NOT NULL,
    password VARCHAR(76) NOT NULL
);

CREATE TABLE UserContactInfo (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    userID BIGINT NOT NULL,
    firstName VARCHAR(100) NULL,
    lastName VARCHAR(100) NULL,
    email VARCHAR(320) NOT NULL,
    FOREIGN KEY (userID) REFERENCES User(id)
);

CREATE TABLE Role (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    role VARCHAR(10)
);

CREATE TABLE Course (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200)
);

CREATE TABLE CourseRole (
	courseID BIGINT NOT NULL,
    roleID BIGINT NOT NULL,
    userID BIGINT NOT NULL,
    FOREIGN KEY (courseID) REFERENCES Course(id),
    FOREIGN KEY (roleID) REFERENCES Role(id),
    FOREIGN KEY (userID) REFERENCES User(id)
);

CREATE TABLE SystemRole (
	roleID BIGINT NOT NULL,
    userID BIGINT NOT NULL,
    FOREIGN KEY (roleID) REFERENCES Role(id),
    FOREIGN KEY (userID) REFERENCES User(id)
);

CREATE TABLE `QuestionType` (
  `typeID` int(11) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`typeID`)
);

CREATE TABLE `Question` (
  `questionID` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(150) NOT NULL,
  `typeID` int(11) NOT NULL,
  `questionText` varchar(400) NOT NULL,
  `instructorID` bigint(20) NOT NULL,
  `dateCreated` datetime NOT NULL,
  PRIMARY KEY (`questionID`),
  KEY `type` (`typeID`),
  KEY `instructor` (`instructorID`),
  CONSTRAINT `instructor` FOREIGN KEY (`instructorID`) REFERENCES `User` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `type` FOREIGN KEY (`typeID`) REFERENCES `QuestionType` (`typeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `QuestionOptions` (
  `optionID` bigint(20) NOT NULL AUTO_INCREMENT,
  `questionID` int(11) NOT NULL,
  `displayText` varchar(150) NOT NULL,
  `storedAs` int(11) NOT NULL,
  PRIMARY KEY (`optionID`),
  KEY `question` (`questionID`),
  CONSTRAINT `question` FOREIGN KEY (`questionID`) REFERENCES `Question` (`questionID`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

INSERT INTO QuestionType
VALUES
(1, 'Numeric'),
(2, 'Multiple Choice - One'),
(3, 'Multiple Choice - Many'),
(4, 'Free Text');

INSERT INTO Role(role)
VALUES
    ('Admin'),
	('Guest'),
    ('Student'),
    ('Instructor'),
    ('TA');

/*
	This is not how you would do this in the real world, it would not be safe to have passwords
    or accounts stored in files in git.  This creates the admin user with an empty password.
*/
INSERT INTO User(bannerID, password)
VALUES ('B-000000', '1234');

SELECT LAST_INSERT_ID()
INTO @adminID;

INSERT INTO UserContactInfo(userID, firstName, lastName, email)
VALUES (@adminID, 'Sreyas', 'Ram', 'srey94@dal.ca');

SELECT id
INTO @adminRoleID
FROM Role
WHERE role = 'Admin';

INSERT INTO SystemRole(roleID, userID)
VALUES (@adminRoleID, @adminID);

SELECT * FROM Role;
SELECT * FROM User;
