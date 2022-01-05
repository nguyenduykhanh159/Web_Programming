package com.example.demo.dto.job;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreatedJobDTO {
    
    @JsonProperty("job")
    private JobDTO job;

    @JsonProperty("receivers")
    private List<FarmerJobDTO> receivers=new ArrayList<>();
}
