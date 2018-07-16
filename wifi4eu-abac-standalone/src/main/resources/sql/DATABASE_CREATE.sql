-- -----------------------------------------------------
-- Table ABAC_LEGAL_ENTITIES
-- -----------------------------------------------------
CREATE TABLE ABAC_LEGAL_ENTITIES (
  id            INT           NOT NULL,
  name          VARCHAR(255) NULL,
  lang          VARCHAR(255) NULL,
  region        VARCHAR(255) NULL,
  country       VARCHAR(255) NULL,
  code          VARCHAR(255) NULL,
  address       VARCHAR(255) NULL,
  nr            VARCHAR(255) NULL,
  postal_code   VARCHAR(255) NULL,
  id_abac       VARCHAR(255) NULL,
  status        VARCHAR(255) NULL,
  PRIMARY KEY (id)
);

CREATE INDEX IDX_ABAC_LE
  ON ABAC_LEGAL_ENTITIES (id_abac ASC);
