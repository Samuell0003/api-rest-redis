package com.iftm.apirestredis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "immobile")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Immobile implements Serializable {
    @Id
    private ObjectId id;
    private String address;
    private Double area;
    private Double value;
}
