create table ArticleGroupType
(
    ArticleGroupTypeId TEXT not null
        primary key
        unique,
    Code               TEXT,
    Desc               TEXT,
    ProductionOrder    TEXT
);

create table ArticleType
(
    ArticleTypeId TEXT    not null
        primary key
        unique,
    Desc          TEXT    not null,
    Code          TEXT    not null,
    Year          INTEGER not null
);

create table Article
(
    ArticleId     TEXT not null
        primary key
        unique,
    Img           TEXT,
    Doc           TEXT,
    Code          TEXT not null,
    Name          TEXT not null,
    Desc          TEXT not null,
    ArticleTypeId TEXT not null
        references ArticleType
            on delete cascade,
    BasePrice     NUMERIC
);

create table ArticleArticleGroupType
(
    ArticleArticleGroupTypeId TEXT not null
        primary key
        unique,
    ArticleGroupTypeId        TEXT
        references ArticleGroupType
            on delete cascade,
    ArticleId                 TEXT
        references Article
            on delete cascade,
    Qta                       NUMERIC
);

create table Customer
(
    CustomerId TEXT not null
        primary key
        unique,
    Name       TEXT,
    Code       TEXT
);

create table Invoice
(
    InvoiceId  TEXT not null
        primary key
        unique,
    Dt         TEXT not null,
    CustomerId TEXT not null
        references Customer
            on delete cascade,
    Total      NUMERIC default 0
);

create table MachineType
(
    MachineTypeId TEXT not null
        primary key
        unique,
    Desc          TEXT,
    Code          TEXT,
    Dt            TEXT,
    Nr            TEXT,
    Img           TEXT,
    Axes          INTEGER,
    Cnc           TEXT,
    Note          INTEGER,
    Spindles      INTEGER
);

create table ArticleMachineType
(
    ArticleMachineTypeId TEXT not null
        primary key
        unique,
    ArticleId            TEXT not null
        references Article
            on delete cascade,
    MachineTypeId        TEXT not null
        references MachineType
            on delete cascade,
    Qta                  NUMERIC default 1
);

create table Machine
(
    MachineId       TEXT    not null
        primary key
        unique,
    Nr              INTEGER not null,
    Year            INTEGER not null,
    Code            TEXT    not null,
    Desc            TEXT,
    Img             TEXT,
    Doc             TEXT,
    MachineTypeId   TEXT    not null
        references MachineType,
    BasePrice       NUMERIC,
    Note            TEXT,
    ProductionOrder TEXT,
    Address         TEXT,
    DtDelivery      TEXT,
    DtAcceptance    TEXT,
    DtEndWarranty   TEXT,
    DtStartWarranty TEXT
);

create table ArticleMachine
(
    ArticleMachineId TEXT not null
        primary key
        unique,
    MachineId        TEXT not null
        references Machine
            on delete cascade,
    ArticleId        TEXT not null
        references Article
            on delete cascade,
    Qta              NUMERIC default 1,
    Note             TEXT
);

create table InvoiceItem
(
    InvoiceItemId TEXT not null
        primary key
        unique,
    Dt            TEXT not null,
    InvoiceId     TEXT not null
        references Invoice
            on delete cascade,
    ArticleId     TEXT
        references Article
            on delete cascade,
    MachineId     TEXT
        references Machine
            on delete cascade,
    Qta           NUMERIC default 1
);

