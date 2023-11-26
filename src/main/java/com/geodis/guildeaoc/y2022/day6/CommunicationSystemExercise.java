package com.geodis.guildeaoc.y2022.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.geodis.guildeaoc.utils.FileUtils;

import lombok.extern.slf4j.Slf4j;

public class CommunicationSystemExercise {

    public void run() {
		List<String> lines = FileUtils.parseFile("src/main/java/com/geodis/guildeaoc/y2022/day6/input.txt");
		this.part1(lines.get(0));
		this.part2(lines.get(0));
	}

    private void part1(String datasourceBuffer) {
        int markerIndex = this.getIndexMarkerForDatasourceBuffer(datasourceBuffer, 4);
        System.out.println("part1.markerIndex=" + markerIndex);
    }

    private void part2(String datasourceBuffer) {
        int markerIndex = this.getIndexMarkerForDatasourceBuffer(datasourceBuffer, 14);
        System.out.println("part2.markerIndex=" + markerIndex);
    }

    private int getIndexMarkerForDatasourceBuffer(String datasourceBuffer, int markerSize) {
        
        List<String> marker = new ArrayList<>();
        List<String> chars = new ArrayList<String>(Arrays.asList(datasourceBuffer.split("")));
        
        for (int i = 0; i <= chars.size() - 1; i++) {
            String elt = chars.get(i);
            if (marker.contains(elt)) {
                int indexDuplication = marker.indexOf(elt);
                marker = marker.subList(indexDuplication + 1, marker.size());
            }
            marker.add(elt);
            if (marker.size() >= markerSize) {
                return i + 1;
            }
        }
        return -1;
    }
}
