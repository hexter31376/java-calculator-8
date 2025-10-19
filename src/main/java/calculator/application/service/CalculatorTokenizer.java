package calculator.application.service;

import calculator.application.dto.CalculatorRequest;
import calculator.domain.token.MeanToken;
import calculator.exception.custom.RequsetNullException;
import calculator.infrastructure.Operators;
import calculator.util.StringStateCursor;

import java.util.ArrayList;
import java.util.List;

// 파서 서비스
public class CalculatorTokenizer {

    private final Operators operators;

    public CalculatorTokenizer(Operators operators) {
        this.operators = operators;
    }

    List<MeanToken> doTokenize(CalculatorRequest calculatorRequest) {
        if (calculatorRequest == null) {
            throw new RequsetNullException("doTokenize의 Request가 Null");
        }
        List<MeanToken> meanTokens = new ArrayList<>();
        // 검증
        // 비어있을때 -> 빈 리스트인 오퍼레이터 그대로 반환, 얼리 리턴 패턴 적용
        if(calculatorRequest.isEmpty()){
            return meanTokens;
        }

        // 메인 구분자 커서
        StringStateCursor cursor = new StringStateCursor(calculatorRequest.userinput());

        for(calculatorRequest.userinput())
        // TODO : '//'가 감지되었을때 -> 커스텀 구분자 추가 처리 스택과 버퍼를 연다, \n 만날때까지 묶어서 토크나이징해서 오퍼레이터에 집어넣는데 이때 오퍼레이터 내에 이미 있는 요소인지 체크를 해 주어야 한다 IAE("커스텀 구분자를 중복으로 추가했습니다."). 내부에서 .과 공백이 발견되면 커스텀 IAE("공백 혹은 .은 커스텀 구분자의 요소로 사용할 수 없습니다.")를 반환한다. 따로 meanTokens에 집어넣지는 않는다.
        // TODO : 숫자가 감지되었을때 -> 숫자 처리 스택과 버퍼를 연다, 0-9까지의 문자로 정의되어 감지하고 .을 감지하여 그 뒤의 요소도 숫자로 인식하지만 .은 두번 올 수 없고, .뒤에는 반드시 숫자가 하나 있어야 한다. 숫자를 제외한 다른 문자열을 인식하면 해당 스택을 종료한다. 조건들을 통과하여 하나씩 넣은 문자들을 Double형으로 변환해서 NumberToken으로 래핑하고 그 결과버퍼를 meanTokens에 집어넣는다.
        // TODO : 문자가 감지되었을때 -> 커스텀 구분자 검색 처리 스택과 버퍼를 연다, 숫자를 만나기 전까지의 문자들을 문자열로 래핑해서 버퍼를 만들고 그 버퍼 요소로 operators 내에 해당 요소가 존재하는지 검색하고 존재하지 않으면 커스텀 IAE("등록되지 않은 구분자를 사용했습니다.") 발생, 존재하면, operators에서 OperatorToken을 빼내고 그것을 래핑해서 meanTokens에 집어넣는다.

        return meanTokens;
    }
}
