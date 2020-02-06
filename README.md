# java-calculator
문자열 계산기 미션 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)







## 요구사항

- 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.





## 기능목록

- 사용자에게 입력을 받는다.
  - NULL 혹은 띄어쓰기만 있는 경우
  - 숫자와 부호 이외의 입력이 있는 경우
  - 숫자 혹은 부호가 연속으로 나오는 경우
  - 나눗셈 뒤에 0이 들어가는 경우
  - 문자열 시작과 끝이 숫자가 아닌 경우
  - <b>위 사항은 사용자들에게 재입력을 받는다.</b>



- 입력받은 문자를 띄어쓰기 기준으로 Split한다.

  - 띄어쓰기가 연속으로 있는 경우

    - 띄어쓰기 하나로 취급한다.

    

- 스플릿 한 문자열을 Double형으로 변환한다.

  - overflow가 있는 경우

    - 오류 메시지를 띄우고, 재입력 받는다.

    

- 순차적으로 연산한다.

  - 연산 값이 overflow가 있는 경우
    - 오류 메시지를 띄우고, 재입력 받는다.

