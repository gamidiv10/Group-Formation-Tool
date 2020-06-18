DELIMITER $$
CREATE DEFINER=`CSCI5308_2_DEVINT_USER`@`%` PROCEDURE `spCreateQuestion`(
	IN title VARCHAR(150),
    IN typeID INT(11),
    IN questionText VARCHAR(400),
    IN instructorID VARCHAR(20)
)
BEGIN
	DECLARE userID BIGINT(20);
    DECLARE qID INT(11);
	SELECT id into userID from User u where u.bannerID = instructorID; 
	INSERT INTO Question(title, typeID, questionText, instructorID, dateCreated)
    VALUES (title, typeID, questionText, userID, now());
	SET qID = LAST_INSERT_ID();
    SELECT Q.questionID FROM Question Q WHERE Q.questionID = qID;
END$$
DELIMITER ;