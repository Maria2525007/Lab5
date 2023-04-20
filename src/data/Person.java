package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

/**
 * Class for study group admin
 */
@XmlType(propOrder = {"name", "weight", "hairColor"})
public class Person {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int height; //Значение поля должно быть больше 0
    private java.util.Date birthday; //Поле не может быть null
    private String passportID; //Длина строки должна быть не меньше 6, Строка не может быть пустой, Поле может быть null
    private Country nationality; //Поле не может быть null
    private Location location; //Поле не может быть null

    /**
     * Class constructor
     *
     * @param aName      - admin name
     * @param aWeight    - admin weight
     * @param aHairColor - admin color
     */
    public Person(String aName, Long aWeight, Country aHairColor) {
        name = aName;
        weight = aWeight;
        hairColor = aHairColor;
    }

    /**
     * Class constructor for Xml parser
     */
    public Person() {
        name = null;
        weight = null;
        hairColor = null;
    }

    @XmlElement
    public void setName(String aName) {
        name = aName;
    }

    @XmlElement
    public void setWeight(Long aWeight) {
        weight = aWeight;
    }

    @XmlElement
    public void setHairColor(Country aHairColor) {
        hairColor = aHairColor;
    }

    public String getName() {
        return name;
    }

    public Long getWeight() {
        return weight;
    }

    public Country getHairColor() {
        return hairColor;
    }

    @Override
    public String toString() {
        return "name = " + name + ", " +
                "weight = " + weight + ", " +
                "hair color = " + hairColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, hairColor);
    }
}