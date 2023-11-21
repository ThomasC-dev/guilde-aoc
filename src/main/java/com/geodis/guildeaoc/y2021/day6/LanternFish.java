package com.geodis.guildeaoc.y2021.day6;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class LanternFish {
    
    private int lifeExpectancy;
    private List<LanternFish> childs;

    public LanternFish(int lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
        this.childs = new ArrayList<>();
    }

    public void iterate() {
        this.childs.forEach(LanternFish::iterate);
        if (this.lifeExpectancy == 0) {
            this.lifeExpectancy = 6;
            this.childs.add(new LanternFish(8));
        } else {
            this.lifeExpectancy--;
        }
    }

    public int getLineageCount() {
        int childsCount = this.childs.stream()
            .mapToInt(LanternFish::getLineageCount)
            .sum();
        return childsCount + 1;
    }
}
