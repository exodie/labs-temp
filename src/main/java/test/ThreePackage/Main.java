package test.ThreePackage;

public class Main {
    public static void main(String[] args) {
        try {
            Product[] products = getProducts();

            System.out.println("Полная информация о всех объектах массива:");
            for (Product product : products) {
                System.out.println(product);
            }
            System.out.println();

            // Возвращает одинаковый результат
            System.out.println("Объекты, функциональный метод которых возвращает одинаковый результат:");
            for (int i = 0; i < products.length; i++) {
                for (int j = i + 1; j < products.length; j++) {
                    try {
                        if (products[i].calculateTotalPrice() == products[j].calculateTotalPrice()) {
                            System.out.println("1: " + products[i].getName() + ", 2: " + products[j].getName());
                        }
                    } catch (PriceRangeException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            System.out.println();

            // Массив на два массива, в которых будут храниться однотипные элементы
            System.out.println("Два массива с однотипными элементами:");

            Product[] productArray = new Product[products.length];
            Product[] goodsArray = new Product[products.length];
            int productIndex = 0;
            int goodsIndex = 0;

            for (Product product : products) {
                if (product instanceof ProductItem) {
                    productArray[productIndex++] = product;
                } else if (product instanceof Goods) {
                    goodsArray[goodsIndex++] = product;
                }
            }

            // Вывод массива продуктов
            System.out.println("Массив продуктов:");
            for (int i = 0; i < productIndex; i++) {
                System.out.println(productArray[i]);
            }

            // Вывод массива товаров
            System.out.println("\nМассив товаров:");
            for (int i = 0; i < goodsIndex; i++) {
                System.out.println(goodsArray[i]);
            }
        } catch (InvalidPriceException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Product[] getProducts() throws InvalidPriceException {
        ProductItem product1 = new ProductItem(new String[]{"Яблоки", "Мандарины", "Апельсины"}, "Фрукты", 100);
        Goods goods1 = new Goods(new String[]{"Телефон", "Планшет", "ПК"}, "Электроника", 5000);

        ProductItem product2 = new ProductItem(new String[]{"Помидоры", "Огурцы", "Кабачки"}, "Овощи", 70); // Пример некорректной цены
        Goods goods2 = new Goods(new String[]{"Тест1", "Тест2", "Тест3"}, "Тесты", 100);

        Product[] products = { product1, goods1, product2, goods2 };
        return products;
    }
}
