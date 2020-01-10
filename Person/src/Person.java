public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        if (this.man != person.man) { //проверка пола
            if (this.spouse == person.spouse && this.spouse != null)
                return false; //уже женаты
            if (this.spouse != null) { //разводим 1 пару
                this.divorce();
            }
            if (person.spouse != null) { //разводим 2 пару
                person.divorce();
            }
            this.spouse = person; //женим
            person.spouse = this;
            return true;
        } else return false;
    }

    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        if (this.spouse != null) {
            this.spouse.spouse = null;
            this.spouse = null;
            return true;
        } else return false;
    }

    public String getName() {
        return name;
    }

    public Person getSpouse() {
        return spouse;
    }

    public static void main(String[] args) {
        Person p1 = new Person(true, "Ваня");
        Person p2 = new Person(false, "Настя");
        Person p3 = new Person(true, "Петя");
        Person p4 = new Person(false, "Аня");
        Person p5 = new Person(false, "Даша");

        // свадьбы
        p1.marry(p2);

        // развод
        System.out.println("муж " + p1.name + " жена " + p1.spouse.name);
        System.out.println("жена " + p2.name + " муж " + p2.spouse.name);
        p1.divorce();
        System.out.println("имя " + p1.name + " жена " + p1.spouse);
        System.out.println("имя " + p2.name + " муж " + p2.spouse);

        // свадьба с разводом
        p3.marry(p4);
        System.out.println("муж " + p3.name + " жена " + p3.spouse.name);
        System.out.println("жена " + p4.name + " муж " + p4.spouse.name);
        p3.marry(p5);
        System.out.println(p3.name + " жена " + p3.spouse.name);
        System.out.println(p4.name + " муж "+p4.spouse);
        System.out.println(p5.name + " муж " + p5.spouse.name);
    }
}