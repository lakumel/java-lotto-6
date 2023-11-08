package lotto.util;

import java.lang.reflect.Array;

public class ValidateUtil {
    /*
    * 구매 금액이 1000원 단위로 나누어 떨어지는지 검증한다.
    * @param amount 구매 금액
    * */
    public void validatePurchase(int amount){
        if(amount % PURCHASE_AMOUNT_COND.getNumber()!=0){
            throw new IllegalArgumentException(PURCHASE);
        }
    }
    /*
    * 당첨 번호에 대한 모든 것을 진행한다.
    * @param input입력한 당첨번호
    * */
    public void validateWinningAmount(String input){
        String[] winningAmounts = input.split(",");
        validateWinningCount(winningAmounts);
        validateBlack(winningAmounts);
        validateDuplicate(winningAmounts);
        validateWinningRange(winningAmounts);
    }
    /*
    * 당첨 번호를 6개 입력했는지 검증한다.
    * @param inputNums 당첨번호 리스트
    * */
    private void validateWinningCount(String[] inputNums){
        if (inputNums.length!=MAX_COUNT.getNumber()){
            throw new IllegalArgumentException(NUMBER_COUNT);
        }
    }
    /*
    * 당첨 번호에 공백값을 입력했는지 검증한다.
    * @param inputNums 당첨번호 리스트
    * */
    private void validateBlack(String[] inputNums){
        boolean result = Array.stream(inputNums)
                .noneMatch(str -> str.equals(" ")||str.equals(" "));

        if (!result){
            throw new IllegalArgumentException(NUMBER_BLACK);
        }
    }

    /*
    * 당첨 번호에 중복값이 존재하는지 검증한다.
    * @param inputNums 당첨번호 리스트
    * */

    private void validateDuplicate(String[] inputNums){
        if (Array.stream(inputNums).distinct().count()!=MAX_COUNT.getNumber()){
            throw new IllegalArgumentException(NUMBER_DUPLICATE);
        }
    }
    /*
    * 당첨 번호의 범위가 1 ~ 45 사이의 값인지 검증한다.
    * @param inputNums 당첨번호 리스트
    * */

    private void validateWinningRange(String[] inputNums){
        boolean result = Array.stream(inputNums)
                .mapToInt(Integer::parseInt)
                .noneMatch(this::isNotCorrectRange);

        if (!result){
            throw new IllegalArgumentException(NUMBER_RANGE);
        }
    }

    /*
    * 보너스 번호의 범위가 1 ~ 45 사이의 값인지 검증 한다.
    * @param bonusNum 보너스 번호
    * */

    public void validateBonusRange(int bonusNum){
        if (isNotCorrectRange(bonusNum)){
            throw new IllegalArgumentException(NUMBER_RANGE);
        }
    }

    /*
    * 로또 번호의 범위가 1 ~ 45 사이의 값이 아닌지 판단한다.
    * @param number 로또 번호
    * @return 1 ~ 45 사이의 값이 아니라면 true 맞다면 false
    * */

    private boolean isNotCorrectRange(int number){
        return number < FIRST_RANGE.getNumber()||number>LAST_RANGE.getNumber();
    }


}
