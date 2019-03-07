package homeworks.homework8.entities;

import java.util.List;

import static homeworks.homework8.enums.Colors.RED;
import static homeworks.homework8.enums.Elements.FIRE;
import static homeworks.homework8.enums.Elements.WATER;
import static homeworks.homework8.enums.Metals.SELEN;
import static homeworks.homework8.enums.Summary.EIGHT;
import static homeworks.homework8.enums.Summary.THREE;
import static homeworks.homework8.enums.Vegetables.CUCUMBER;
import static homeworks.homework8.enums.Vegetables.TOMATO;
import static java.util.Arrays.asList;

public class MetalsAndColors {

    public static MetalsAndColors homeworkSeven = new MetalsAndColors(asList(THREE.value, EIGHT.value),
            asList(WATER.label, FIRE.label), RED.label, SELEN.label, asList(CUCUMBER.label, TOMATO.label));

    public List<Integer> summary;
    public List<String> elements;
    public String color;
    public String metal;
    public List<String> vegetables;

    private MetalsAndColors(List<Integer> summary, List<String> elements, String color, String metal, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;
    }
}
