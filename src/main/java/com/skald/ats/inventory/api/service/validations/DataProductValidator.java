package com.skald.ats.inventory.api.service.validations;

import com.skald.ats.inventory.api.dto.ProductDTO;
import com.skald.ats.inventory.api.exception.ValidationDataException;
import org.springframework.stereotype.Component;

@Component
public class DataProductValidator {

    public void productDataIsValid(ProductDTO productDTO) throws ValidationDataException{
        validateMinStockLevel(productDTO);
    }

    public void validateMinStockLevel(ProductDTO productDTO) throws ValidationDataException{
        if (productDTO.getMinimalStockLevel() >= productDTO.getMaximumStockLevel()){
            throw new ValidationDataException("minimalStockLevel",
                    "Nivel minimo de estoque não pode ser maior ou igual ao nível maximo de estoque");
        }
        if (productDTO.getMinimalStockLevel() <= 0){
            throw new ValidationDataException("maximumStockLevel",
                    "Nivel minimo de estoque não pode ser menor ou igual a zero");
        }

    }



}
