package Exceptions;

public class EmptyField extends Exception {
    public EmptyField() {
        super("\nОшибка №1: Поле не заполнено.\n");
    }
}
