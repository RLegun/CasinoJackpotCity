import java.time.LocalDate;

public abstract class Employee extends Person {
    private LocalDate dateOfEmployment;

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }
}
