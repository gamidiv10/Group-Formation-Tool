DELIMITER $$

DROP procedure IF EXISTS spPasswordEnforcementPolicy $$;

CREATE PROCEDURE spPasswordEnforcementPolicy ()
BEGIN
SELECT * FROM PasswordPolicy;
END $$

DELIMITER ;
