package com.example.ms_instalaciones.repository;

import com.example.ms_instalaciones.model.LineaBebedero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LineaRepository extends JpaRepository<LineaBebedero, Long> {

    // Todas las líneas ordenadas por granja, galpón y línea
    List<LineaBebedero> findAllByOrderByGranjaAscGalponAscLineaAsc();

    // Líneas de una granja
    List<LineaBebedero> findByGranjaOrderByGalponAscLineaAsc(String granja);

    // Líneas de un galpón dentro de una granja
    List<LineaBebedero> findByGranjaAndGalponOrderByLineaAsc(String granja, String galpon);

    // Lista de granjas sin repetir (para selector en la app)
    @Query("SELECT DISTINCT l.granja FROM LineaBebedero l ORDER BY l.granja")
    List<String> listarGranjas();

    // Lista de galpones de una granja sin repetir (para selector en la app)
    @Query("SELECT DISTINCT l.galpon FROM LineaBebedero l WHERE l.granja = :granja ORDER BY l.galpon")
    List<String> listarGalpones(@Param("granja") String granja);
}