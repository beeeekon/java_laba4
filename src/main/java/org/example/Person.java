package org.example;

/**
 * Класс, описывающий подразделение
 */
class Subdivision {

    /**
     * ID подразделения
     */
    private final int id;

    /**
     * название подразделения
     */
    private final String title;

    /**
     * конструктор по названию и id
     * @param title название подразделения
     * @param id_subd ID подразделения
     */
    public Subdivision(String title, int id_subd)
    {
        this.title = title;
        id = id_subd;
    }

    /**
     * Метод для получения ID подразделения
     * @return ID подразделения
     */
    public int getId() { return id; }

    /**
     * Метод для получения названия подразделения
     * @return название подразделения
     */
    public String getTitle() { return title; }
}

/**
 * Класс содержащий информацию о человеке
 */
public class Person {

    /**
     * ID человека
     */
    private final String id;

    /**
     * имя человека
     */
    private final String name;

    /**
     * пол человека
     */
    private final String gender;

    /**
     * зарплата человека
     */
    private final String salary;

    /**
     * день рождения человека
     */
    private final String birthDate;

    /**
     * подразделения человека
     */
    private final Subdivision subd;

    /**
     * конструктор по умолчанию
     */
    public Person() {
        id = "";
        name = "";
        gender = "";
        salary = "";
        birthDate = "";
        subd = new Subdivision("", 0);
    }

    /**
     * конструктор по значения
     * @param id ID человека
     * @param name имя человека
     * @param gender пол человека
     * @param salary зарплата человека
     * @param birthDate день рождения человека
     * @param title_subd название подразделения, где работает человек
     * @param id_subd Id подразделения, где работает чеолвек
     */
    Person(String id, String name, String gender, String salary, String birthDate, String title_subd, int id_subd)
    {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.birthDate = birthDate;
        subd = new Subdivision(title_subd, id_subd);
    }

    /**
     * Переопределенный метод toString()
     * @return строка с информацией о человеке
     */
    @Override
    public String toString() {
        return id + "; " +
                name + "; " +
                gender + "; " +
                salary + "; " +
                birthDate + "; " +
                subd.getTitle() + "; " +
                subd.getId();
    }
}