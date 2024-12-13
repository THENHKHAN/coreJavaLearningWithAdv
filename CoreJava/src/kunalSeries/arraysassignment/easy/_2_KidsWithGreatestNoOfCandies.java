package kunalSeries.arraysassignment.easy;

// TODO - easy: 1431. Kids With the Greatest Number of Candies
// ref : https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/
// explained below the intuition & Approach
// Or can be see : https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/solutions/6141116/easy-approach-with-right-understanding/
import java.util.ArrayList;
import java.util.List;
public class _2_KidsWithGreatestNoOfCandies {

    // lets find the maximum candie's in the array
    public int maxCandi(int[] candies){
        int max = candies[0];

        for (int candy : candies) {
            if (candy > max)
                max = candy;
            //can be used as well  max = Math.max(max,candies[i]);
        }

        return max;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> listOfGreaterCandiesKid = new ArrayList<>();

        int maxCandi = maxCandi(candies);


        for (int i = 0; i < candies.length; i++) {
            if (candies[i]+extraCandies >= maxCandi){
                listOfGreaterCandiesKid.add(true);
            } else{
                listOfGreaterCandiesKid.add(false);
            }
        }

        return listOfGreaterCandiesKid ;
    }

    public List<Boolean> kidsWithCandiesReducedStep(int[] candies, int extraCandies) {
        List<Boolean> listOfGreaterCandiesKid = new ArrayList<>();

        int maxCandi = candies[0];
        for (int candi: candies){
            maxCandi = Math.max(candi, maxCandi);
        }

        for (int i = 0; i < candies.length; i++) {
                listOfGreaterCandiesKid.add(candies[i]+extraCandies>= maxCandi);
        }

        return listOfGreaterCandiesKid ;
    }

    public static void main(String[] args) {
        _2_KidsWithGreatestNoOfCandies obj = new _2_KidsWithGreatestNoOfCandies();

        System.out.println("\n ****************  TEST CASE - 1    **********************");
        int[] candies1 = {2,3,5,1,3};
        int extraCandies1 = 3 ;

        System.out.println("Kids With the Greatest Number of Candies : " + obj.kidsWithCandies(candies1,extraCandies1));

        System.out.println("\n ****************  TEST CASE - 2    **********************");
        int[] candies2 = {4,2,1,1,2};
        int extraCandies2 = 1 ;

        System.out.println("Kids With the Greatest Number of Candies : " + obj.kidsWithCandies(candies2,extraCandies2));


        System.out.println("\n ****************  TEST CASE - 3    **********************");
        int[] candies3 = {12,1,12};
        int extraCandies3 = 10 ;

        System.out.println("Kids With the Greatest Number of Candies : " + obj.kidsWithCandies(candies3,extraCandies3));

    // TODO - note : you can use optimized one (its on the basis of TC or SC but in terms of reducing steps.)

    }
}

// Todo
/*
            Intuition
The key is to compare each child's potential total
(candies[i] + extraCandies) with the current maximum (maxCandies):

If adding extraCandies makes the total greater than or equal to the current maximum, that child can potentially have the most candies.
This is why maxCandies acts as a baseline for comparison.

Approach
If you Know linear Search then its Piece of cake.

Find Maximum of All elements in the Array
Traverse the Loop from i=0 to N(length of array)
check candies[i] + extraCandies >= max
if it is max then add true to list
else add false to list


Complexity
Time complexity:
O(2*N)  OR O(n) + O(n) = O(2n) ≈ O(n).
finding maximum --> O(N)
traverse the Array to find greatest for each -->O(N)

Space complexity:
O(N) for return the answer not in the algorithm.
If we not consider this then
O(1).

 */