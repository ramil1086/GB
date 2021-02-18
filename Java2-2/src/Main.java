public class Main {
    public static void main(String[] args) throws MyArrayDataException, MyArraySizeException{
        String[][] array = {{"1", "2", "3", "4"} ,{"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"}};
//        String[][] array = {{"1", "2", "3"} ,{"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"}};
//        String[][] array = {{"1", "2", "3", "B"} ,{"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"}};

        try {
            System.out.println(sumArray(array));
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }
    public static int sumArray (String [][] array) throws MyArraySizeException {
        if (array.length !=4) throw new MyArraySizeException("Размер массива не соответствует 4х4. Ошибка типа " + MyArraySizeException.class.getSimpleName());
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) throw new MyArraySizeException("Размер массива не соответствует 4х4. Ошибка типа " + MyArraySizeException.class.getSimpleName());
        }
        int sumArrayResult = 0;
        String position = "";
        try {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    position = "[" + i + "]" + "[" + j + "]";
                    sumArrayResult += Integer.parseInt(array[i][j]);
                }
            }
        }
        catch (NumberFormatException e) {
            throw new MyArrayDataException("Ошибка " + MyArrayDataException.class.getSimpleName() + " находится в ячейке " + position);
        }
        return sumArrayResult;
    }

}
