package com.example.ms_flushing.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registro_flushing")
public class RegistroFlushing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String granja;
    private String galpon;
    private String linea;
    private String responsable;
    private String motivo;

    @Column(length = 500)
    private String observaciones;

    private String fecha;

    public RegistroFlushing() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getGranja() { return granja; }
    public void setGranja(String granja) { this.granja = granja; }

    public String getGalpon() { return galpon; }
    public void setGalpon(String galpon) { this.galpon = galpon; }

    public String getLinea() { return linea; }
    public void setLinea(String linea) { this.linea = linea; }

    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}