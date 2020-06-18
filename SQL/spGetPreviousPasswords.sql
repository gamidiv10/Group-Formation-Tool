DELIMITER $$

DROP procedure IF EXISTS `spGetPreviousPasswords`;


CREATE PROCEDURE `spGetPreviousPasswords` (
IN uID BIGINT,
IN historyConstraint INT
)
BEGIN

SELECT password FROM PasswordHistory
WHERE userID = uID ORDER BY password_Time DESC LIMIT historyConstraint;

END$$

DELIMITER ;