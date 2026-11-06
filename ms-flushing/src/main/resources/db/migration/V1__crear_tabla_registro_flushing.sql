CREATE TABLE registro_flushing (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    granja VARCHAR(100) NOT NULL,
    galpon VARCHAR(100) NOT NULL,
    linea VARCHAR(100) NOT NULL,
    responsable VARCHAR(100) NOT NULL,
    motivo VARCHAR(150) NOT NULL,
    observaciones VARCHAR(500),
    fecha VARCHAR(30) NOT NULL
);