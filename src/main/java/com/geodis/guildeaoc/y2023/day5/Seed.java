package com.geodis.guildeaoc.y2023.day5;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Seed {
    
    private Long value;
    private List<Mapper> mappers;

    public Long processLifeCycle() {
        for(Mapper mapper : this.mappers) {
            value = mapper.processSeed(value);
        }
        return value;
    }
}
