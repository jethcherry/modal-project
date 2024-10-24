package com.modal_app.model.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Data
public class ProductDTO {
    private UUID id;
    private String name;
    private String description;
    private Double price;

}
