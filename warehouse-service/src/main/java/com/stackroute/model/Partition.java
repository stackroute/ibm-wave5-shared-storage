package com.stackroute.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partition {
    @Id
    private int id;

    private String type;

    private String size;

    private int cost;
    private Tenant tenant;
}
