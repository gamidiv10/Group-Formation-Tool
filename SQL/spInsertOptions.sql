DELIMITER $$
CREATE DEFINER=`CSCI5308_2_DEVINT_USER`@`%` PROCEDURE `spInsertOptions`(
	IN questionID INT(11),
    IN displayText VARCHAR(150),
    IN storedAs INT(11))
BEGIN
	INSERT INTO QuestionOptions(questionID, displayText, storedAs)
    VALUES (questionID, displayText, storedAs);
END$$
DELIMITER ;