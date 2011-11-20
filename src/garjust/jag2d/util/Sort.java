package garjust.jag2d.util;

/**
 *
 * @author JAG-LAPTOP
 */
public final class Sort {
    
    public static void bubble(float[] array) {
        
    }
    
    public static void bubble(float[] array, Object[] reflection) {
        boolean isSwapped;
        do {
            isSwapped = false;
            for(int i = 1; i < array.length; i++) {
                if(array[i - 1] > array[i]) {
                    isSwapped = true;
                    float hold = array[i - 1];
                    Object hold2 = reflection[i - 1];
                    array[i - 1] = array[i];
                    reflection[i - 1] = reflection[i];
                    array[i] = hold;
                    reflection[i] = hold2;
                }
            }      
        } while(isSwapped);
    }
}
