public class ArrayH {
    public int[] getFourValue(int[] array) {
        for(int i = array.length - 1;i >= 0; i--){
            if(array[i] ==4){
                return getSliceArray(i, array);
            }
        }
        throw new RuntimeException();
    }
    private int[] getSliceArray(int fromIndex, int[] originalArray) {
        int[] resultArray = new int[originalArray.length - fromIndex];
        for(int i = fromIndex, j = 0; i < originalArray.length; i++, j++){
            resultArray[i] = originalArray[i];
        }
        return resultArray;
    }

    public boolean findOneOrFour(int[] array){
        boolean four = false;
        boolean one = false;

        for(int value : array) {
            if (value == 4) {
                four = true;
            } else if (value == 1){
                one = true;
            } else {
                return false;
            }
        }
        return four && one;
    }
}
