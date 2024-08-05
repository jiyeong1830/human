// document.write('head scriptjs파일');
console.log('로그!!!')

console.log('오류~~~~');

var num = 1 + 2; // var로 변수 선언(num은 어떤 데이터 타입도 가능)
var num = '1' + '2';
//String str1 = '' -> java케이스 오류 
// console.log('num1:', num1);
// console.log('num2:', num2);

console.log('로그!!!');
console.log('오류~~~~');

// var는 변수명 중복 가능
var num = 2 + 3;
var num = 3 + 4;
console.log('num:', num);

// let은 변수명 중복 가능
let str = 2 + 3;
// let str = 3 + 4;
console.log('str:', str);

// var은 hosting(호이스팅)이 가능
//   - 호이스팅은 변수 선언을 나중에 하더라도 다른 코드들에서 읽을 수 있도록 지원
// console.log('num3:', num3);
// var num3 = 10;

// let은 hosting(호이스팅)이 불가능
// let num3 = 10;

// const는 상수 선언
const num4 = 11;
// num4 = 12; error -> num4는 상수로 선언되었기 때문
console.log('num4:', num4);

let num5 = 11;
num5 = 13;
console.log('num5', num5);

// ==, === 연산자 비교
// == -> 10 == '10' true
// === -> 10 === '10' false
console.log(typeof(10)); // -> Number
console.log(typeof('10')); // -> String

const result = 10 + '10';
console.log(result);

let result1 = 10 + Number('10'); // -> 20
result1 = 10 + Number('10'); // -> 1010

let sum = 0;
for(let i = 1; i <=100; i++) {
    sum += 1
}
console.log(sum);

// 함수 선언
function helloFunc() {
    // 실행 코드
    console.log(1234);
   }
   // 함수 호출
   helloFunc(); // 1234

   function returnFunc() {
    return 123;
   }
   let i = returnFunc();
   console.log(i); // 123

   // 함수 선언!
function sum(a, b) { // a와 b는 매개변수(Parameters)
    return a + b;
   }
   // 재사용!
   let a = sum(1, 2); // 1과 2는 인수(Arguments)
   let b = sum(7, 12);
   let c = sum(2, 4);
   console.log(a, b, c); // 3, 19, 6

   // 기명(이름이 있는) 함수
// 함수 선언!
function hello() {
    console.log('Hello~');
   }
   // 익명(이름이 없는) 함수
   // 함수 표현!
   let world = function () {
    console.log('World~');
   }
   // 함수 호출!
   hello(); // Hello~
   world(); // World~

   // 객체 데이터
const heropy = {
    name: 'HEROPY',
    age: 85,
    // 메소드(Method)
    getName: function () {
    return this.name;
    }
   };
   const hisName = heropy.getName();
   console.log(hisName); // HEROPY
   // 혹은
   console.log(heropy.getName()); // HEROPY