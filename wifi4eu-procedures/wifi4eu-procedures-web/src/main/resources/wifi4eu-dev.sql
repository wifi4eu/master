SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema wifi4eu
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `wifi4eu`;
-- -----------------------------------------------------
-- Schema wifi4eu
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `wifi4eu`
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_bin;
USE `wifi4eu`;

CREATE TABLE IF NOT EXISTS `wifi4eu`.`SEQUENCE` (
  `SEQ_NAME`  VARCHAR(255) NOT NULL,
  `SEQ_COUNT` INT,
  PRIMARY KEY (`SEQ_NAME`)
);

-- -----------------------------------------------------
-- Table `wifi4eu`.`audit_data_t`
-- -----------------------------------------------------
# CREATE TABLE IF NOT EXISTS `AUDIT_DATA_T` (
#   `AUDIT_DATA_ID`    INT(11) NOT NULL,
#   `REQUEST_ENDPOINT` VARCHAR(255)
#                      COLLATE utf8_bin DEFAULT NULL,
#   `REQUEST_METHOD`   VARCHAR(255)
#                      COLLATE utf8_bin DEFAULT NULL,
#   `REQUEST_BODY`     BLOB,
#   `RESPONSE_BODY`    BLOB,
#   `USER_ID`          INT(11)          DEFAULT NULL
# )
#   ENGINE = InnoDB
#   DEFAULT CHARSET = utf8
#   COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`users` (
  `id`            INT          NOT NULL AUTO_INCREMENT,
  `treatment`     VARCHAR(255) NULL,
  `name`          VARCHAR(255) NULL,
  `surname`       VARCHAR(255) NULL,
  `address`       VARCHAR(255) NULL,
  `address_num`   VARCHAR(255) NULL,
  `postal_code`   VARCHAR(255) NULL,
  `email`         VARCHAR(255) NULL,
  `password`      VARCHAR(255) NULL,
  `create_date`   BIGINT       NULL,
  `access_date`   BIGINT       NULL,
  `ecas_email`    VARCHAR(255) NULL,
  `ecas_username` VARCHAR(255) NULL,
  `lang`          VARCHAR(255) NULL,
  `type`          INT          NULL     DEFAULT NULL,
  `verified`      TINYINT      NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`rights`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`rights` (
  `id`        INT          NOT NULL AUTO_INCREMENT,
  `userId`    INT          NULL,
  `rightdesc` VARCHAR(255) NULL,
  `type`      INT          NULL     DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`laus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`laus` (
  `id`               INT          NOT NULL AUTO_INCREMENT,
  `country_code`     VARCHAR(255) NULL,
  `nuts3`            VARCHAR(255) NULL,
  `lau1`             VARCHAR(255) NULL,
  `lau2`             VARCHAR(255) NULL,
  `_change`          VARCHAR(255) NULL,
  `name1`            VARCHAR(255) NULL,
  `name2`            VARCHAR(255) NULL,
  `pop`              VARCHAR(255) NULL,
  `area`             VARCHAR(255) NULL,
  `physical_address` VARCHAR(255) NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`municipalities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`municipalities` (
  `id`          INT          NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(255) NULL,
  `address`     VARCHAR(255) NULL,
  `address_num` VARCHAR(255) NULL,
  `postal_code` VARCHAR(255) NULL,
  `country`     VARCHAR(255) NULL,
  `lau`         INT          NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_municipalities_laus1_idx` (`lau` ASC),
  CONSTRAINT `fk_municipalities_laus`
  FOREIGN KEY (`lau`)
  REFERENCES `wifi4eu`.`laus` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`registrations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`registrations` (
  `id`               INT          NOT NULL AUTO_INCREMENT,
  `_user`            INT          NOT NULL,
  `municipality`     INT          NOT NULL,
  `role`             VARCHAR(500) NULL,
  `_status`          INT(1)       NOT NULL, --  0=HOLD; 1=KO; 2=OK
  `legal_file1`      LONGTEXT     NULL,
  `legal_file2`      LONGTEXT     NULL,
  `legal_file3`      LONGTEXT     NULL,
  `legal_file4`      LONGTEXT     NULL,
  `ip_registration`  VARCHAR(30)  NULL,
  `organisation_id`  INT                   DEFAULT NULL,
  `association_name` VARCHAR(500)          DEFAULT NULL,
  `upload_time` bigint(20) DEFAULT NULL,
  `allFiles_flag` int(1) DEFAULT NULL,
  `mail_counter` int(1) NOT NULL DEFAULT '3',
  PRIMARY KEY (`id`),
  INDEX `fk_user_idx` (`_user` ASC),
  INDEX `fk_municipality_idx` (`municipality` ASC),
  CONSTRAINT `fk_registrations_users`
  FOREIGN KEY (`_user`)
  REFERENCES `wifi4eu`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_registrations_municipalities`
  FOREIGN KEY (`municipality`)
  REFERENCES `wifi4eu`.`municipalities` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`calls`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`calls` (
  `id`         INT          NOT NULL AUTO_INCREMENT,
  `event`      VARCHAR(500) NULL,
  `start_date` BIGINT       NULL,
  `end_date`   BIGINT       NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;
INSERT INTO calls (event, start_date, end_date)
  SELECT
    'Test call #1'                                       AS event,
    ROUND(UNIX_TIMESTAMP(CURTIME(4)) * 1000 + 100000000) AS start_date,
    0                                                    AS end_date;

-- -----------------------------------------------------
-- Table `wifi4eu`.`nuts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`nuts` (
  `id`           INT          NOT NULL AUTO_INCREMENT,
  `code`         VARCHAR(255) NULL,
  `label`        VARCHAR(255) NULL,
  `level`        INT          NULL,
  `country_code` VARCHAR(255) NULL,
  `_order`       INT          NULL,
  `sorting`      INT          NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`threads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`threads` (
  `id`        INT          NOT NULL AUTO_INCREMENT,
  `title`     VARCHAR(255) NULL,
  `reason`    VARCHAR(255) NULL,
  `type`      INT          NOT NULL,
  `mediation` INT                   DEFAULT 0,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`thread_messages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`thread_messages` (
  `id`          INT        NOT NULL AUTO_INCREMENT,
  `thread`      INT        NOT NULL,
  `author`      INT        NOT NULL,
  `message`     MEDIUMTEXT NULL,
  `create_date` BIGINT     NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_thread_idx` (`thread` ASC),
  INDEX `fk_author_idx` (`author` ASC),
  CONSTRAINT `fk_thread_messages_threads`
  FOREIGN KEY (`thread`)
  REFERENCES `wifi4eu`.`threads` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_thread_messages_users`
  FOREIGN KEY (`author`)
  REFERENCES `wifi4eu`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`suppliers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`suppliers` (
  `id`                   INT          NOT NULL AUTO_INCREMENT,
  `name`                 VARCHAR(255) NULL,
  `address`              VARCHAR(255) NULL,
  `vat`                  VARCHAR(255) NULL,
  `bic`                  VARCHAR(255) NULL,
  `account_number`       VARCHAR(255) NULL,
  `website`              VARCHAR(255) NULL,
  `contact_name`         VARCHAR(255) NULL,
  `contact_surname`      VARCHAR(255) NULL,
  `contact_phone_prefix` VARCHAR(255) NULL,
  `contact_phone_number` VARCHAR(255) NULL,
  `contact_email`        VARCHAR(255) NULL,
  `logo`                 LONGTEXT     NULL,
  `_user`                INT          NULL,
  `legal_file1`          LONGTEXT     NULL,
  `legal_file2`          LONGTEXT     NULL,
  `_status`              TINYINT      NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_suppliers_users_idx` (`_user` ASC),
  CONSTRAINT `fk_suppliers_users`
  FOREIGN KEY (`_user`)
  REFERENCES `wifi4eu`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`applications`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`applications` (
  `id`              INT     NOT NULL AUTO_INCREMENT,
  `call_id`         INT     NOT NULL,
  `registration`    INT     NOT NULL,
  `supplier`        INT     NULL,
  `voucher_awarded` TINYINT NULL     DEFAULT 0,
  `date`            BIGINT  NULL,
  `lef_export`      BIGINT  NULL,
  `lef_import`      BIGINT  NULL,
  `lef_status`      INT     NULL     DEFAULT 0,
  `bc_export`       BIGINT  NULL,
  `bc_import`       BIGINT  NULL,
  `bc_status`       INT     NULL     DEFAULT 0,
  `lc_export`       BIGINT  NULL,
  `lc_import`       BIGINT  NULL,
  `lc_status`       INT     NULL     DEFAULT 0,
  `_status`         INT     NOT NULL DEFAULT 0,
  `invalidate_reason` MEDIUMTEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_call_idx` (`call_id` ASC),
  INDEX `fk_registration_idx` (`registration` ASC),
  INDEX `fk_applications_supplier_idx` (`supplier` ASC),
  CONSTRAINT `fk_applications_calls`
  FOREIGN KEY (`call_id`)
  REFERENCES `wifi4eu`.`calls` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_applications_registrations`
  FOREIGN KEY (`registration`)
  REFERENCES `wifi4eu`.`registrations` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_applications_suppliers`
  FOREIGN KEY (`supplier`)
  REFERENCES `wifi4eu`.`suppliers` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`mayors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`mayors` (
  `id`           INT          NOT NULL AUTO_INCREMENT,
  `name`         VARCHAR(255) NULL,
  `surname`      VARCHAR(255) NULL,
  `treatment`    VARCHAR(255) NULL,
  `email`        VARCHAR(255) NULL,
  `municipality` INT          NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_mayors_municipalities_idx` (`municipality` ASC),
  CONSTRAINT `fk_mayors_municipalities`
  FOREIGN KEY (`municipality`)
  REFERENCES `wifi4eu`.`municipalities` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`representations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`representations` (
  `id`           INT NOT NULL AUTO_INCREMENT,
  `municipality` INT NOT NULL,
  `mayor`        INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_municipality_idx` (`municipality` ASC),
  INDEX `fk_mayor_idx` (`mayor` ASC),
  CONSTRAINT `fk_representations_municipalities`
  FOREIGN KEY (`municipality`)
  REFERENCES `wifi4eu`.`municipalities` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_representations_mayors`
  FOREIGN KEY (`mayor`)
  REFERENCES `wifi4eu`.`mayors` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`access_points`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`access_points` (
  `id`            INT          NOT NULL AUTO_INCREMENT,
  `municipality`  INT          NULL,
  `name`          VARCHAR(255) NULL,
  `product_name`  VARCHAR(255) NULL,
  `model_number`  VARCHAR(255) NULL,
  `serial_number` VARCHAR(255) NULL,
  `indoor`        TINYINT      NULL     DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_municipality_idx` (`municipality` ASC),
  CONSTRAINT `fk_access_points_municipalities`
  FOREIGN KEY (`municipality`)
  REFERENCES `wifi4eu`.`municipalities` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`supplied_regions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`supplied_regions` (
  `id`       INT NOT NULL AUTO_INCREMENT,
  `supplier` INT NOT NULL,
  `region`   INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_supplier_regions_supplier_idx` (`supplier` ASC),
  INDEX `fk_supplier_regions_region_idx` (`region` ASC),
  CONSTRAINT `fk_supplier_regions_suppliers`
  FOREIGN KEY (`supplier`)
  REFERENCES `wifi4eu`.`suppliers` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_supplier_regions_nuts`
  FOREIGN KEY (`region`)
  REFERENCES `wifi4eu`.`nuts` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`helpdesk_issues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`helpdesk_issues` (
  `id`           INT          NOT NULL AUTO_INCREMENT,
  `from_email`   VARCHAR(255) NULL,
  `assigned_to`  VARCHAR(255) NULL,
  `topic`        VARCHAR(255) NULL,
  `portal`       VARCHAR(255) NULL,
  `member_state` VARCHAR(255) NULL,
  `summary`      MEDIUMTEXT   NULL,
  `create_date`  BIGINT       NULL,
  `_status`      INT          NOT NULL DEFAULT 0,
  `_ticket`      INT          NOT NULL DEFAULT 0
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`helpdesk_comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`helpdesk_comments` (
  `id`          INT          NOT NULL AUTO_INCREMENT,
  `issue`       INT          NULL,
  `from_email`  VARCHAR(255) NULL,
  `comment`     MEDIUMTEXT   NULL,
  `create_date` BIGINT       NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_helpdesk_comments_issue_idx` (`issue` ASC),
  CONSTRAINT `fk_helpdesk_comments_issues`
  FOREIGN KEY (`issue`)
  REFERENCES `wifi4eu`.`helpdesk_issues` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`timelines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`timelines` (
  `id`          INT          NOT NULL AUTO_INCREMENT,
  `call_id`     INT          NULL,
  `description` VARCHAR(255) NULL,
  `start_date`  BIGINT       NULL,
  `end_date`    BIGINT       NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_timelines_call_id_idx` (`call_id` ASC),
  CONSTRAINT `fk_timelines_call_id`
  FOREIGN KEY (`call_id`)
  REFERENCES `wifi4eu`.`calls` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`temp_tokens`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`temp_tokens` (
  `id`          BIGINT       NOT NULL AUTO_INCREMENT,
  `token`       VARCHAR(255) NULL,
  `email`       VARCHAR(255) NULL,
  `create_date` BIGINT       NULL,
  `expiry_date` BIGINT       NULL,
  `_user`       INT          NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_temp_tokens_users_idx` (`_user` ASC),
  CONSTRAINT `fk_temp_tokens_users`
  FOREIGN KEY (`_user`)
  REFERENCES `wifi4eu`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `wifi4eu`.`organizations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`organizations` (
  `id`      INT          NOT NULL AUTO_INCREMENT,
  `name`    VARCHAR(255) NULL,
  `type`    VARCHAR(255) NULL,
  `country` VARCHAR(255) NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;
INSERT INTO `wifi4eu`.`organizations` (name, type, country)
VALUES ('Everis', 'private', 'ES');

-- -----------------------------------------------------
-- Table `dbo`.`voucher_management`
-- -----------------------------------------------------
CREATE TABLE `voucher_management` (
  `id`           INT          NOT NULL AUTO_INCREMENT,
  `call_id`      INT          NOT NULL,
  `member_state` VARCHAR(255) NULL,
  `minimum`      INT          NULL,
  `maximum`      INT          NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;
INSERT INTO `voucher_management` (call_id, member_state, minimum, maximum) VALUES
  (1, 'Austria', 15, 80),
  (1, 'Belgium', 15, 80),
  (1, 'Bulgaria', 15, 80),
  (1, 'Croatia', 15, 80),
  (1, 'Cyprus', 15, 80),
  (1, 'Czech Republic', 15, 80),
  (1, 'Denmark', 15, 80),
  (1, 'Estonia', 15, 80),
  (1, 'Finland', 15, 80),
  (1, 'France', 15, 80),
  (1, 'Germany', 15, 80),
  (1, 'Greece', 15, 80),
  (1, 'Hungary', 15, 80),
  (1, 'Ireland', 15, 80),
  (1, 'Italy', 15, 80),
  (1, 'Latvia', 15, 80),
  (1, 'Lithuania', 15, 80),
  (1, 'Luxembourg', 15, 80),
  (1, 'Malta', 15, 80),
  (1, 'Netherlands', 15, 80),
  (1, 'Poland', 15, 80),
  (1, 'Portugal', 15, 80),
  (1, 'Romania', 15, 80),
  (1, 'Slovakia', 15, 80),
  (1, 'Slovenia', 15, 80),
  (1, 'Spain', 15, 80),
  (1, 'Sweden', 15, 80);

-- -----------------------------------------------------
-- Table `dbo`.`user_threads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`user_threads` (
  `id`     INT NOT NULL AUTO_INCREMENT,
  `_user`  INT NOT NULL,
  `thread` INT NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Table `dbo`.`legal_files`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wifi4eu`.`legal_files` (
  `id`					INT NOT NULL AUTO_INCREMENT,
  `registration`		INT NOT NULL,
  `type`				INT NOT NULL,
  `data`				LONGTEXT NULL,
  `upload_time`			bigint(20) DEFAULT NULL,
  `request_correction`	TINYINT NOT NULL DEFAULT 0,
  `correction_reason`	INT DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;