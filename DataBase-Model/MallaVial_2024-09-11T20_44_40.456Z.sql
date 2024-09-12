CREATE TABLE "Segmento" (
	"idSegmento" BIGINT NOT NULL UNIQUE,
	"nomenclatura" VARCHAR,
	"longitudSegmento" VARCHAR,
	"activo" BOOLEAN DEFAULT TRUE,
	"actualiza" TIMESTAMP DEFAULT CURRENT_DATE,
	PRIMARY KEY("idSegmento")
);


CREATE TABLE "Calzada" (
	"idCalzada" BIGINT NOT NULL UNIQUE,
	"idSegmento" BIGINT,
	"longitudCalzada" VARCHAR,
	"activo" BOOLEAN DEFAULT TRUE,
	"actualiza" TIMESTAMP DEFAULT CURRENT_DATE,
	PRIMARY KEY("idCalzada")
);


CREATE TABLE "Bordillo" (
	"idBordillo" BIGINT NOT NULL UNIQUE,
	"idSegmento" BIGINT,
	"longitudBordillo" VARCHAR,
	"activo" BOOLEAN DEFAULT TRUE,
	"Actualiza" TIMESTAMP DEFAULT CURRENT_DATE,
	PRIMARY KEY("idBordillo")
);


ALTER TABLE "Segmento"
ADD FOREIGN KEY("idSegmento") REFERENCES "Calzada"("idSegmento")
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE "Bordillo"
ADD FOREIGN KEY("idSegmento") REFERENCES "Segmento"("idSegmento")
ON UPDATE NO ACTION ON DELETE NO ACTION;