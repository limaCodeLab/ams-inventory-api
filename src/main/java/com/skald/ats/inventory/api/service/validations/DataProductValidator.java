package com.skald.ats.inventory.api.service.validations;

import com.skald.ats.inventory.api.dto.ProductDTO;
import com.skald.ats.inventory.api.exception.ValidationDataException;
import org.springframework.stereotype.Component;

@Component
public class DataProductValidator {

    public void validateMaxStockLevel(ProductDTO productDTO) throws ValidationDataException{
        if (productDTO.getMaximumStockLevel() <= productDTO.getMinimalStockLevel()){
            throw new ValidationDataException("maximumStockLevel",
                    "Nivel máximo de estoque não pode ser menor ou igual ao nível mínimo de estoque");
        }

    }


}
