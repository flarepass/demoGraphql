CREATE TABLE SPRING_SESSION (
  SESSION_ID            CHAR(36),
  CREATION_TIME         BIGINT NOT NULL,
  LAST_ACCESS_TIME      BIGINT NOT NULL,
  MAX_INACTIVE_INTERVAL INT    NOT NULL,
  PRINCIPAL_NAME        TEXT,
  CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (SESSION_ID)
);

CREATE INDEX SPRING_SESSION_IX1
  ON SPRING_SESSION (LAST_ACCESS_TIME);
CREATE UNIQUE INDEX SPRING_SESSION_IX2
  ON SPRING_SESSION (SESSION_ID);

CREATE TABLE SPRING_SESSION_ATTRIBUTES (
  SESSION_ID      CHAR(36),
  ATTRIBUTE_NAME  VARCHAR(200),
  ATTRIBUTE_BYTES BLOB,
  CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_ID, ATTRIBUTE_NAME),
  CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_ID) REFERENCES SPRING_SESSION (SESSION_ID)
    ON DELETE CASCADE
);

CREATE INDEX SPRING_SESSION_ATTRIBUTES_IX1
  ON SPRING_SESSION_ATTRIBUTES (SESSION_ID);