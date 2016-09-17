/**
 * Created by ndodakheswa on 2016/09/14.
 */
public class DataStructures {

    public static int quickSortStep(int[] A, int lo, int hi) {
        //Put A[lo] into pivot to leave an available space at
        //A[lo].
        int pivot = A[lo];

        while( hi > lo ) {

            while ( hi > lo && A[hi] >= pivot ) {
                //Move A[hi] down past pivot.
                hi--;
            }

            if ( hi == lo ) {
                break;
            }
            //At this point A[hi] < pivot, move it into the
            //available space at A[lo]
            A[lo] = A[hi];
            lo++;
            while ( hi > lo && A[lo] <= pivot ) {
                //Move A[lo] up past pivot
                lo++;
            }

            if ( hi == lo ) {
                break;
            }
            //At this point A[lo] is greater than pivot
            //Move it into the available space at A[hi]
            A[hi] = A[lo];
            hi++;
        } //End while
        /**
         * At this point hi = lo and there's an available space
         * at that position.  This position lies between numbers
         * less than pivot and numbers greater than pivot.
         *Put pivot at that position
         **/
        A[lo] = pivot;
        return lo;
    }//End quickSortStep()

    public static void quickSort( int A[], int lo, int hi) {
        if ( hi <= lo ) {
            //The list has one or zero length.  There's nothing to do
            //Return from the subroutine
            return;
        }

        int pivot = quickSortStep(A, lo, hi);
        quickSort(A, lo, pivot - 1);
        quickSort(A, pivot + 1, hi);
    }

    static int binarySearch( int[] A, int lo, int hi, int item ) {
        if ( hi < lo ) {
            //The starting position comes after the final index.
            //so are actually no elements in the specified range
            //The value does not accur in this empty list
            return -1;
        } else {
            //Look at the position in the middle of the list
            //If the item accurs there, you're done searching.
            //Otherwise compare the item with the value in the
            //middle of the list.  If the item is lower than
            //middle then look in the lower part of the array
            //Otherwise look in the upper part of the array above
            //middle.
            int middle = (lo + hi)/2;
            if ( item == middle ) {
                return middle;
            } else if ( item < middle) {
                return binarySearch(A, lo, middle - 1, item);
            } else {
                return binarySearch(A, middle + 1, hi, item);
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {34, 89, 12, 34, 100, 34, 45, 89};
        quickSort(A, 1, 5);

        System.out.println();
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }
}
