CREATE TABLE medicion (
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    linea_id     BIGINT      NOT NULL,
    temperatura  DOUBLE      NOT NULL,
    estado       VARCHAR(20) NOT NULL,
    fecha_hora   DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;