package cn.humblecodeukco.test.behaviorparameterization;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * @Author lyr
 * @Date 2020/12/25 20:36
 * @Version 1.0
 * @Description
 */
public class UseStream {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian =new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(alan, 2012, 950)
        );

        // 找出2011耐的所有交易并按交易额排序（从低到高）
        List<Transaction> tr2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        // 交易员都在哪些不同的城市工作过
        List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
        Set<String> cities2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(toSet());

        // 查找所有来自于剑桥的交易员，并按姓名排序
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());

        // 返回所有交易员的姓名字符串，按字母顺序排序
        String traderStr = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        String traderStr2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());

        // 有没有交易员在米兰工作
        boolean milanBased = transactions.stream()
                .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));

        // 打印生活在剑桥是交易员的所有交易额
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // 所有交易中，最高的交易额是多少
        Optional<Integer> highestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        // 找到交易额最小的交易
        Optional<Transaction> smallestTransaction = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        Optional<Transaction> smallestTransaction2 = transactions.stream()
                .min(comparing(Transaction::getValue));
    }
}
