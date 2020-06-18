DELIMITER $$

DROP procedure IF EXISTS spInsertPasswordToHistory $$;

CREATE PROCEDURE spInsertPasswordToHistory (
IN bID VARCHAR(20)
)
BEGIN
SELECT id,password
INTO @userID, @encPassword
FROM User WHERE bannerID = bID;

INSERT INTO PasswordHistory(userID,password,password_time)
VALUES (@userID,@encPassword,now());

END $$

DELIMITER ;