package homeworks.homework7.entities;

import homeworks.homework7.enums.Elements;
import homeworks.homework7.enums.Summary;
import homeworks.homework7.enums.Vegetables;

import java.util.List;

import static homeworks.homework7.enums.Colors.RED;
import static homeworks.homework7.enums.Elements.FIRE;
import static homeworks.homework7.enums.Elements.WATER;
import static homeworks.homework7.enums.Metals.SELEN;
import static homeworks.homework7.enums.Summary.EIGHT;
import static homeworks.homework7.enums.Summary.THREE;
import static homeworks.homework7.enums.Vegetables.CUCUMBER;
import static homeworks.homework7.enums.Vegetables.TOMATO;
import static java.util.Arrays.asList;

public class MetalsAndColors {

    public MetalsAndColors homeworkSeven = new MetalsAndColors(asList(THREE.label, EIGHT.label),
            asList(WATER.label, FIRE.label), RED.label, SELEN.label, asList(CUCUMBER.label, TOMATO.label));

    private List<String> summary;
    private List<String> elements;
    private String color;
    private String metal;
    private List<String> vegetables;

    public MetalsAndColors(List<String> summary, List<String> elements, String color, String metal, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;
    }
}
