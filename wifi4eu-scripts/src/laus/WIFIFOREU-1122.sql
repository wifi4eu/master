-- ----------------------------------------------------------------- --
-- ---- WIFIFOREU-1122 :: Transfilter Latin LAU1 names for ABAC ---- --
-- - https://webgate.ec.europa.eu/CITnet/jira/browse/WIFIFOREU-1122  --
-- ----------------------------------------------------------------- --

-- Remove previous version
DROP TABLE IF EXISTS laus_temp;

-- Back up
CREATE TABLE laus_temp LIKE laus; 
INSERT laus_temp SELECT * FROM laus;

-- Add new column
ALTER TABLE laus ADD name1_abac VARCHAR(255) AFTER name2;

-- Insert the new values in name_1_abac
UPDATE laus
SET name1_abac = (
  SELECT name1
  FROM laus_temp
  WHERE id = laus.id
);

-- DISABLED: remove the temporal table
-- DROP TABLE IF EXISTS laus_temp;