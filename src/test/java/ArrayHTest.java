import com.sun.org.glassfish.gmbal.ParameterNames;
import jdk.nashorn.internal.runtime.regexp.joni.constants.Arguments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;



class ArrayHTest {
    private final ArrayH arrayH = new ArrayH();

    @ParameterizedTest
    @MethodSource("dataForFour")
    void getFourValue(int[] originalArray, int[] expectedResultArray) {
        int[] actualResultArray = arrayH.getFourValue(originalArray);

        Assertions.assertArrayEquals(expectedResultArray, actualResultArray);
    }

    private static Stream<Arguments> dataForFour() {
        List<Arguments> arguments = new ArrayList<>(){{
            add(Arguments.arguments(new int[]{1, 2, 3, 4, 5}, new int[]{5}));
            add(Arguments.arguments(new int[]{1, 2, 3, 4}, new int[]{}));
            add(Arguments.arguments(new int[]{4, 1, 2, 4, 3, 4, 5}, new int[]{5}));
            add(Arguments.arguments(new int[]{4, 1, 2, 3, 5}, new int[]{1, 2, 3, 5}));
        }};
        return arguments.stream();
    }

    @Test
    void getFourException() {
        int[] originalArray = {1, 2, 3};
        Assertions.assertThrows(RuntimeException.class,
                () -> arrayH.getFourValue(originalArray));

    }

    @Test
    void getEmpty() {


        int[] empty = {};
        Assertions.assertThrows(RuntimeException.class,

                () -> arrayH.getFourValue(empty));
    }


    @ParameterizedTest
    @MethodSource("dataForFindOneOrFour")
    void findOneorFour(int[] array, boolean expectedResult) {
        boolean actualResult = arrayH.findOneOrFour(array);

        Assertions.assertEquals(expectedResult, actualResult);
    }
    private static Stream<Arguments> dataForFindOneOrFour() {
        List<Arguments> arguments = new ArrayList<>(){{
            add(Arguments.arguments(new int[]{1,1,1,4,1,4,1,1}, true));
            add(Arguments.arguments(new int[]{1,1,1,1,1,1}, false));
            add(Arguments.arguments(new int[]{4,4,4,4,4,4,4,4}, false));
            add(Arguments.arguments(new int[]{1,1,4,4,1,1,1,4,4,4,5}, false));
        }};
        return arguments.stream();
    }
}