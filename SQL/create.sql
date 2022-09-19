CREATE TABLE "Article" (
                           "ArticleId"	TEXT NOT NULL UNIQUE,
                           "Img"	TEXT,
                           "Doc"	TEXT,
                           "Code"	TEXT NOT NULL,
                           "Name"	TEXT NOT NULL,
                           "Desc"	TEXT NOT NULL,
                           "ArticleTypeId"	TEXT NOT NULL,
                           "BasePrice"	NUMERIC,
                           PRIMARY KEY("ArticleId"),
                           FOREIGN KEY("ArticleTypeId") REFERENCES "ArticleType" on delete cascade
);

CREATE TABLE "ArticleArticleGroupType" (
                                           "ArticleArticleGroupTypeId"	TEXT NOT NULL UNIQUE,
                                           "ArticleGroupTypeId"	TEXT,
                                           "ArticleId"	TEXT,
                                           "Qta"	NUMERIC,
                                           FOREIGN KEY("ArticleId") REFERENCES "Article"("ArticleId") ON  DELETE CASCADE,
                                           FOREIGN KEY("ArticleGroupTypeId") REFERENCES "ArticleGroupType"("AticleGroupTypeId") ON DELETE CASCADE,
                                           PRIMARY KEY("ArticleArticleGroupTypeId")
);

CREATE TABLE "ArticleGroupType" (
                                    "AticleGroupTypeId"	TEXT NOT NULL UNIQUE,
                                    "Code"	TEXT,
                                    "Desc"	TEXT,
                                    "ProductionOrder"	TEXT,
                                    PRIMARY KEY("AticleGroupTypeId")
);

CREATE TABLE "ArticleMachine" (
                                  "ArticleMachineId"	TEXT NOT NULL UNIQUE,
                                  "MachineId"	TEXT NOT NULL,
                                  "ArticleId"	TEXT NOT NULL,
                                  "Qta"	NUMERIC DEFAULT 1,
                                  "Note"	TEXT,
                                  PRIMARY KEY("ArticleMachineId"),
                                  FOREIGN KEY("MachineId") REFERENCES "Machine"("MachineId") ON DELETE CASCADE,
                                  FOREIGN KEY("ArticleId") REFERENCES "Article"("ArticleId") ON DELETE CASCADE
);

CREATE TABLE "ArticleMachineType" (
                                      "ArticleMachineTypeId"	TEXT NOT NULL UNIQUE,
                                      "ArticleId"	TEXT NOT NULL,
                                      "MachineTypeId"	TEXT NOT NULL,
                                      "Qta"	NUMERIC DEFAULT 1,
                                      PRIMARY KEY("ArticleMachineTypeId"),
                                      FOREIGN KEY("MachineTypeId") REFERENCES "MachineType"("MachineTypeId") ON DELETE CASCADE,
                                      FOREIGN KEY("ArticleId") REFERENCES "Article"("ArticleId") ON DELETE CASCADE
);

CREATE TABLE "ArticleType" (
                               "ArticleTypeId"	TEXT NOT NULL UNIQUE,
                               "Desc"	TEXT NOT NULL,
                               "Code"	TEXT NOT NULL,
                               "Year"	INTEGER NOT NULL,
                               PRIMARY KEY("ArticleTypeId")
);

CREATE TABLE "Customer" (
                            "CustomerId"	TEXT NOT NULL UNIQUE,
                            "Name"	TEXT,
                            "Code"	TEXT,
                            PRIMARY KEY("CustomerId")
);

CREATE TABLE "Invoice" (
                           "InvoiceId"	TEXT NOT NULL UNIQUE,
                           "Dt"	TEXT NOT NULL,
                           "CustomerId"	TEXT NOT NULL,
                           "Total"	NUMERIC DEFAULT 0,
                           FOREIGN KEY("CustomerId") REFERENCES "Customer"("CustomerId") ON DELETE CASCADE,
                           PRIMARY KEY("InvoiceId")
);

CREATE TABLE "InvoiceItem" (
                               "InvoiceItemId"	TEXT NOT NULL UNIQUE,
                               "Dt"	TEXT NOT NULL,
                               "InvoiceId"	TEXT NOT NULL,
                               "ArticleId"	TEXT,
                               "MachineId"	TEXT,
                               "Qta"	NUMERIC DEFAULT 1,
                               PRIMARY KEY("InvoiceItemId"),
                               FOREIGN KEY("InvoiceId") REFERENCES "Invoice"("InvoiceId") on delete cascade,
                               FOREIGN KEY("MachineId") REFERENCES "Machine"("MachineId") on delete cascade,
                               FOREIGN KEY("ArticleId") REFERENCES "Article"("ArticleId") on delete cascade
);

CREATE TABLE "Machine" (
                           "MachineId"	TEXT NOT NULL UNIQUE,
                           "Nr"	INTEGER NOT NULL,
                           "Year"	INTEGER NOT NULL,
                           "Code"	TEXT NOT NULL,
                           "Desc"	TEXT,
                           "Img"	TEXT,
                           "Doc"	TEXT,
                           "MachineTypeId"	TEXT NOT NULL,
                           "InvoiceItemId"	TEXT,
                           "BasePrice"	NUMERIC,
                           "Note"	TEXT,
                           "ProductionOrder"	TEXT,
                           "Address"	TEXT,
                           "DtDelivery"	TEXT,
                           "DtAcceptance"	TEXT,
                           "DtEndWarranty"	TEXT,
                           "DtStartWarranty"	TEXT,
                           PRIMARY KEY("MachineId"),
                           FOREIGN KEY("InvoiceItemId") REFERENCES "Invoice"("InvoiceId") ON DELETE CASCADE,
                           FOREIGN KEY("MachineTypeId") REFERENCES "MachineType"("MachineTypeId")
);

CREATE TABLE "MachineType" (
                               "MachineTypeId"	TEXT NOT NULL UNIQUE,
                               "Desc"	TEXT,
                               "Code"	TEXT,
                               "Dt"	TEXT,
                               "Nr"	TEXT,
                               "Img"	TEXT,
                               "Axes"	INTEGER,
                               "Cnc"	TEXT,
                               "Note"	INTEGER,
                               "Spindles"	INTEGER,
                               UNIQUE("Code","Dt"),
                               PRIMARY KEY("MachineTypeId")
);