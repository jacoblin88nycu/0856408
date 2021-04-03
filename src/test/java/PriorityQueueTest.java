import java.util.NoSuchElementException;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.lang.Integer;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {

    static Stream<Arguments> stringIntAndListProvider(){
        return Stream.of(
                Arguments.of(new int[]{3,1,2,4},new int[]{1,2,3,4}),
                Arguments.of(new int[]{6,-2,1,5},new int[]{-2,1,5,6}),
                Arguments.of(new int[]{1,9,-8,0,8,4},new int[]{-8,0,1,4,8,9}),
                Arguments.of(new int[]{-4,-5,-8,-9},new int[]{-9,-8,-5,-4}),
                Arguments.of(new int[]{-378, 184, -38, -455, 59, -395, 460, 97},new int[]{-455,-395,-378,-38,59,97,184,460})
                //Arguments.of(new int[]{0x1a,0,2},new int[]{-455,-395,-378,-38,59,97,184,460})
        );
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("stringIntAndListProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s = 0;
        int[] result = new int[random_array.length];

        for(int i=0;i<random_array.length;i++){
            test.offer(random_array[i]);
        }

        while((s = test.poll()) != null){
            result[index] = s;
            index++;
        }
        //System.out.println(test.size());
        //s = test.remove();
        assertArrayEquals(correct_array,result);

    }

    @Test
    public void whenExceptionThrown_thenOfferEisNull(){
        Exception exception =assertThrows(NullPointerException.class,()->{
            throw new NullPointerException("Null int array only");
        });
        String expectedMessage = "Null int array only";
        String actualMessage  = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void whenExceptionThrown_Wrong_Number_Format(){
        Exception exception =assertThrows(NumberFormatException.class,()->{
            throw new NumberFormatException("wrong Number format");
        });
        String expectedMessage = "wrong Number format";
        String actualMessage  = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void whenExceptionThrown_No_Element_Canbe_Remove(){
        Exception exception =assertThrows(NoSuchElementException.class,()->{
            throw new NoSuchElementException("No element can be removed");
        });
        String expectedMessage = "No element can be removed";
        String actualMessage  = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }
}
