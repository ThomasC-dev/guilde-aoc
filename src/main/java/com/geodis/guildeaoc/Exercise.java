package com.geodis.guildeaoc;

import java.util.ArrayList;
import java.util.List;

import com.geodis.guildeaoc.utils.FileUtils;

public abstract class Exercise {

    private String filepath;

    public Exercise(String filepath) {
        this.filepath = filepath;
    }
    
    public void run() {
        List<String> input = FileUtils.parseFile(filepath);
		this.part1(new ArrayList<>(input));
        this.part2(new ArrayList<>(input));
    }
    protected abstract void part1(List<String> lines);
    protected abstract void part2(List<String> lines);
}
