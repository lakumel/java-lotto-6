package lotto.domain;

import java.util.List;
import java.util.function.Predicate;

public class LottoPrize {

    public long getMatchCount(List<Integer> winningNums,List<Integer> userNums){
        return winningNums.stream()
                .filter(lottoNum->userNums.stream()
                        .noneMatch(Predicate.isEqual(lottoNum)))
                .count();
    }
}
