package cn.humblecodeukco.test.leetcode;

/**
 * @Author lyr
 * @Date 2020/10/20 12:46
 * @Version 1.0
 * @Description
 */
public class BestTimetoBuyStocks {
}

//class BestTimetoBuyStocksSolution {
//    public int maxProfit(int[] prices) {
//        int maxprofit = 0;
//        for (int i = 0; i < prices.length - 1; ++i) {
//            for (int j = i + 1; j < prices.length; ++j) {
//                int profit = prices[j] - prices[i];
//                if (profit > maxprofit) maxprofit = profit;
//            }
//        }
//        return maxprofit;
//    }
//}

class BestTimetoBuyStocksSolution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}