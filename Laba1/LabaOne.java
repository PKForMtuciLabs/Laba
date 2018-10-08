import java.util.Scanner;
// Класс LabaOne содержит все необходимые методы для решения поставленных задач в лабораторной работе №1:
// 1) Сделать вывод простых чисел до N. Добавить ввод чсила с клавиатуры (N). Разбить на методы 
// 2) Проверить слово на палиндром. Разбить на методы
public class LabaOne {
// Метод main осуществляет ввод числа с помощью метода inFunctionNum и введенное число передает в метод OperatingMode,
// где выбирается режим работы программы.
	public static void main(String[] args) {
		System.out.println("Enter the number to select the operating mode of the program (1 - Simple numbers or 2 - palindrome)");
		int choice = inFunctionNum(); 
		OperatingMode(choice);
	}

// Метод OperatingMode осуществляет выбор режима работы программы в зависимости от передаваемого параметра
// c помощью конструкции switch. 1 - вывод простых чисел до N, 2 - провера слова на палиндром. 
// Любое другое значение - Not found.
	public static void OperatingMode( int ans) {
		switch (ans) {
			case 1:
				System.out.println("Enter number");
				int num =  inFunctionNum();
				CheckSimpleNumbers(num);
				break;
			case 2:
				System.out.println("Enter word");
				String str = inFunctionStr();
				CheckPolindrome(str);
				break;
			default:
				System.out.println("Not found");
				break;
		}
	}
// Метод inFunctionNum создает объект in класса Scanner и вызывает метод nextInt для ввода числа
	public static int inFunctionNum() {
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
// Метод inFunctionStr создает объект in класса Scanner и вызывает метод nextLine для ввода строки
	public static String inFunctionStr() {
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}
// Метод CheckSimpleNumbers выводит простые числа до введенного числа(inNumber),
// передаваемого в качестве параметра. В теле цикла проверяются числа от 2 
// до введенного числа с помощью медота checkSimple и в 
// зависимости от результата проверки выводятся в консоль
	public static void CheckSimpleNumbers(int inNumber) {
		boolean b = false;
		for (int P = 2; P <= inNumber; P++) {
			b = checkSimple(P);
			if (b) {
				System.out.println(P);
			}
		}
	}

// Метод checkSimple проверяет является ли число, переданное в качестве параметра, простым.
// в теле цикла если проверяемое число делится на другое число без остатка
// в диапозоне от 1 до divinded-1, то проверяемое число не является простым и метод вернет false. 
// В противном случае метод вернет true.
	public static boolean checkSimple(int dividend) {
		for (int i = 2; i < dividend; i++) {
			if (dividend % i == 0) {
				return false;
			}

		}
		return true;

	}
// Метод CheckPolindrome проверяет слово на палиндром.
// Введенная строка, которая передается в качестве параметра, орабатывается
// с помощью метода StrReverse, который создает реверсивную строку.
// Усоловие проверяет эквивалентна ли передаваемая строка реверсивной строке
// (true - слово палиндром, false - слово не палиндром)
	public static void CheckPolindrome(String str) { 
		if (StrReverse(str).equals(str)) {
			System.out.println("Word - polindrome");
		}
		else {
			System.out.println("Word - not polindrome");
		}
	}
// Метод StrReverse создает реверсивную версию передаваемой строки и возвращает её в качестве результата.
	public static String StrReverse(String str) {
		StringBuffer buf = new StringBuffer(str);
		return buf.reverse().toString();
	}
}