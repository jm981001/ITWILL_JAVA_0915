package lambda;

// 1. 파라미터와 리턴타입이 없는 경우 (파라미터: X, 리턴타입: X)
@FunctionalInterface
interface MyFunc1 {
	// 함수형 인터페이스 어노테이션(@FunctionalInterface) 선언 시 에러 발생!
	// => 함수형 인터페이스는 반드시 하나의 추상메서드(abstract method)를 가져야함
	public void methodA();
//	public void methodB();
}

// 2. 파라미터가 있는 람다식 (파라미터: O)
interface MyFunc2 {
	public void methodB(String msg);
}

// 3. 리턴타입이 있는 람다식 (파라미터: O, 리턴타입: O)
interface MyFunc3 {
	public String methodC(String msg);
}


public class Ex2 {
	
	// 1. (파라미터: X, 리턴타입: X)
	public static void useFIMethodA(MyFunc1 fi) {
		fi.methodA();
	}
	// 2. (파라미터: O)
	public static void useFIMethodB(MyFunc2 fi) {
		fi.methodB("홍길동");
	}
	
	// 3. (파라미터: O, 리턴타입: O)
	public static String useFIMethodC(MyFunc3 fi) {
		return fi.methodC("홍길동");
	}
	

	public static void main(String[] args) {
		/*
		 * 함수형 인터페이스(functional interface) 또는 타겟 타입(target type)
		 * - 람다식은 결과적으로 "인터페이스 타입의 클래스를 손쉽게 구현하는 방법"
		 * - 반드시 하나의 abstract 메서드만 존재
		 * - 만약 abstract 메서드가 없거나 두개 이상 존재한다면 람다식으로 대체할 수 없다!
		 * - 함수형 인터페이스 @FunctionalInterface 어노테이션 선언
		 * */
		useFIMethodA(new MyFunc1() {
			
			@Override
			public void methodA() {
				System.out.println("익명 내부클래스 형태");
			}
		});
		System.out.println("-------------------------------------");
		
		// 1. (파라미터: X, 리턴타입: X)
		useFIMethodA(() -> {
			System.out.println("람다식1");
		});
		
		useFIMethodA(() -> System.out.println("람다식1"));
		
		
		// 2. (파라미터: O)
		useFIMethodB((String msg) -> { 
			System.out.println("람다식2 : " + msg); 
		});
		
		// 파라미터 갯수:1, 실행문:1, 데이터타입이 추론 가능 --> 소괄호(), 중괄호(), 데이터타입 생략 가능!
		useFIMethodB(msg -> System.out.println("람다식2 : " + msg));
		
		// 3. (파라미터: O, 리턴타입: O)
		String result = useFIMethodC((String msg) -> { 
			return "람다식3 : " + msg; 
		});
		System.out.println(result);
		
		System.out.println(useFIMethodC(msg -> "람다식3 : " + msg));
		
		
		
		A a1 = new A();
		a1.method();
		A a2 = new B();
		a2.method();
		
		A a3 = new A() {
			@Override
			void method() { System.out.println("A클래스를 상속받는 익명클래스"); }
		};
		
		a3.method();
		System.out.println("---------------------------------------------");
		I i = new SubClass();
		I i2 = new I() {
			@Override
			public void method() {}
		};
		
	}

}

interface I {
	void method();
}
class SubClass implements I {
	@Override
	public void method() {}
}




class A {
	void method() { System.out.println("A"); }
}

class B extends A {
	@Override
	void method() { System.out.println("B"); }
}










