package homework2;

public class Main {

//+ 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
// при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//+ 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или
// текст вместо числа), должно быть брошено исключение MyArrayDataException, с детализацией в какой
// именно ячейке лежат неверные данные.
//+ 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException
// и MyArrayDataException, и вывести результат расчета.

    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"2", "1", "4", "3"},
                {"3", "4", "2", "1"},
                {"4", "3", "1", "2"}
        };

        try{ // обработка исключений + результат
            int result = method(arr);
            System.out.println("Сумма элементов массива:" + result );
            } catch (MyArraySizeException e ){
                System.out.println("Превышен размер массива");
            } catch (MyArrayDataException e) {
            System.out.println("Неверное значение элемента массива!");
            System.out.println("Ошибка в ячейке: " + e.i + "." + e.j);
        }
    }

    // второй метод, преобразование в int, исключения
    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if(arr.length != 4) {
            throw  new MyArraySizeException(); // превышение размера массива
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) { //неверные ячейки
                try{
                    count = count + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return count;
    }

}
