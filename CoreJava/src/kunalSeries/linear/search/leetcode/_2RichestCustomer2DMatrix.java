package kunalSeries.linear.search.leetcode;

import java.util.Arrays;
// TODO: Leetcode: 1672. Richest Customer Wealth
//  REF : https://leetcode.com/problems/richest-customer-wealth/description/
public class _2RichestCustomer2DMatrix {

    public int[] maximumWealth(int[][] accounts) {
        int customer = 0 ; // extra not for leetcode it's for me
        int maxWealth = 0; // using 0 and not 1st element since money can't be negative in bank
        for (int r = 0; r < accounts.length; r++) {
            int sum = 0 ; // for each customer we should be calculating wealth
            for (int c = 0; c < accounts[r].length; c++) {
                sum += accounts[r][c];
            }
            if (sum > maxWealth){
                maxWealth = sum;
                customer = r;
            }
        }
        return new int[] {customer, maxWealth}; // format { customer , its wealth}
        // as per the lc - only return maxWealth.
    }

    public static void main(String[] args) {
//        int[][] accounts = {
//                                {1, 2, 3},
//                                {3, 2 , 1}
//                            }; //  0oth & 1st customer , 6 wealth
        int[][] accounts = {
                {2,8,7},
                {7,1,3},
                {1,9,5}
        }; // 0oth customer , 17 wealth
        _2RichestCustomer2DMatrix obj = new _2RichestCustomer2DMatrix();
        int[] maxWealth= obj.maximumWealth(accounts); // {0, 17}
        System.out.println("Maximum wealth : " + Arrays.toString(maxWealth)); // {0, 17}
    }
}
