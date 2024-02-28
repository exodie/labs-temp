package test.ThreePackage;

// Исключение для ошибок ввода цены
class InvalidPriceException extends Exception {
    public InvalidPriceException(String message) {
        super(message);
    }
}