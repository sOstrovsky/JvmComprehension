public class JvmComprehension { // JvmComprehension.classes попадает в Metaspace

    public static void main(String[] args) { // 0 в момент вызова main создается фрейм (1) в стеке
        int i = 1;                      // 1 в фрейм (1) записывается переменная "i" со значением 1 (примитивные типы хранятся в стеке)
        Object o = new Object();        // 2 экземпляр класса Object создается в куче (heap), в фрейм (1) записывается сстыука на него "o"
        Integer ii = 2;                 // 3 в фрейм (1) записывается ссылочная переменная ii типа Integer, но значение попадает в кучу (heap)
        printAll(o, i, ii);             // 4 в момент вызова printAll создается новый фрейм (2) в стеке
        System.out.println("finished"); // 7 в момент вызова sout создается новый фрейм (4) в стеке
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 в фрейм (2) записывается ссылочная переменная uselessVal типа Integer, значение 700 записывается в кучу
        System.out.println(o.toString() + i + ii);  /* 6 в момент вызова sout создается новый фрейм (3) в стеке
                                                    в фрейм (3) передается ссылка на o.toString() + i + ii */
    }
}