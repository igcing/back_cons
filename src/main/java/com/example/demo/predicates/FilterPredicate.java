package com.example.demo.predicates;

import com.example.demo.dto.FarmaciaDTO;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class FilterPredicate {
    public static Predicate<FarmaciaDTO> isEqualComuna(String idComuna)
    {
        return p -> p.getFk_comuna().equals(idComuna);
    }

    public static Predicate<FarmaciaDTO> isContainsNombreLocal(String nombreLocal)
    {
        return p -> p.getLocal_nombre().contains(nombreLocal);
    }

    public static Predicate<FarmaciaDTO> isSatisfyFilter(String idComuna, String nombreLocal)
    {
        return isEqualComuna(idComuna).and(isContainsNombreLocal(nombreLocal));
    }

}
