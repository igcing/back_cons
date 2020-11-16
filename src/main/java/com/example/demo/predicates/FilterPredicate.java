package com.example.demo.predicates;

import com.example.demo.dto.FarmaciaDTO;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

/**
 * Método para establecer las condiciones de cumplimiento de búsqueda de una farmacia
 */
@Component
public class FilterPredicate {
    /**
     * Verifica si es la mismo idComuna
     * @param idComuna
     * 
     * @return Predicate<FarmaciaDTO> 
     */
    public static Predicate<FarmaciaDTO> isEqualComuna(String idComuna)
    {
        return p -> p.getFk_comuna().equals(idComuna);
    }

    /**
     * Verifica si contiene el nombre ingresado
     * @param nombreLocal
     * 
     * @return Predicate<FarmaciaDTO>
     */
    public static Predicate<FarmaciaDTO> isContainsNombreLocal(String nombreLocal)
    {
        return p -> p.getLocal_nombre().contains(nombreLocal.toUpperCase());
    }

    /**
     * Verifica si cumple ambas condiciones
     * @param idComuna
     * @param nombreLocal
     * @return  Predicate<FarmaciaDTO>
     */
    public static Predicate<FarmaciaDTO> isSatisfyFilter(String idComuna, String nombreLocal)
    {
        return isEqualComuna(idComuna).and(isContainsNombreLocal(nombreLocal));
    }

}
