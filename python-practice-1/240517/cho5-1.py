# 클래스 학습
# 기존에 배운 add함수를 이용

# calculator.py
result = 0

def add(num):
    global result
    result += num         # 결괏값(result)에 입력값(num) 더하기
    return result         # 결괏값 리턴

print(add(3))             # 0 + 3 -> 3
print(add(4))             # 3 + 4 -> 7

# calculator2.py
result1 = 0
result2 = 0

def add1(num):             # 계산기1
    global result1
    result1 += num
    return result1

def add2(num):             # 계산기2
    global result2
    result2 += num
    return result2

print(add1(3))              # 0 + 3 -> 3
print(add1(4))              # 3 + 4 -> 7
print(add2(3))              # 0 + 3 -> 3
print(add2(7))              # 3 + 7 -> 10
# 노가다

# calculator3.py
# Calculator 클래스 생성
class Calculator:
    def __init__(self):      # 생성자
        self.result = 0      # result 변수룰 0으로 초기화

    def add(self, num):      # add 일반함수
        self.result = self.result + num
        return self.result

    def add(self, num):      # sub 일반함수
        self.result = self.result - num
        return self.result

cal1 = Calculator()          # 객체 생성 (실제 붕어빵)하여 cal1변수에 대입
cal2 = Calculator()         
cal3 = Calculator()          
cal4 = Calculator()
cal5 = Calculator()         

a = cal1.add(3)               # class Carculator 안에 있는 add 함수를 호출
print(a)       
a = cal1.add(4) 
print(a)          
a = cal2.add(3)
print(a)
a = cal2.add(7)
print(a)