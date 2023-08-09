package Exceptions;
public class NoRightInputElement extends Exception {
    public NoRightInputElement(int fieldNumber) {
        super(String.format("\nОшибка №2: Введёные данные в поле %d не верны.\n", fieldNumber));
    }
}
