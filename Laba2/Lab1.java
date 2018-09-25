import java.util.Scanner;
// Класс Lab1,содержащий методы для ввода координат, проверки различия координат 
// трех точек, вычисления периметра и площади треугольника.
public class Lab1{
// Основной метод main в котором осуществляется ввод координат,
// проверяется различие координат трех точек и в зависимости от
// результата проверки выводится площадь треугольника или сообщением о том,
// что есть точки с одинаковыми координатами.
	public static void main(String args[]) {
		System.out.println("Enter x1,y1,z1");
		Point3d object1 = inFunctionNum();
		System.out.println("Enter x2,y2,z2");
		Point3d object2 = inFunctionNum();
		System.out.println("Enter x3,y3,z3");
		Point3d object3 = inFunctionNum();
		if (checkCoords(object1, object2, object3)) {
			double p = perimetr(object1,object2,object3);
			System.out.println(square(p, object1, object2, object3));
		}
		else 
			System.out.println("Coords eq");
	}

// Метод inFunction получает координаты с командной строки и возвращает созданную точку
// с указанными координатами.
	public static Point3d inFunctionNum() {
		Scanner in = new Scanner(System.in);
		double x = in.nextDouble();
		double y = in.nextDouble();
		double z = in.nextDouble();
		return new Point3d(x,y,z);
	}


// Метод checkCoords проверяет различны ли координаты трех точек.
// В качестве параметров передаются 3 точки. Возвращаемое значение - 
// true,если точки различны и false, если есть точки с одинаковыми координатами.
	public static boolean checkCoords(Point3d obj1, Point3d obj2, Point3d obj3) {
		if ((obj1.equalsCoords(obj2)) || (obj1.equalsCoords(obj3)) || (obj2.equalsCoords(obj3)))
			return false;
		else
			return true;
	}
// Метод perimetr вычисляет периметр треугольника.
// В качестве параметров передаются 3 точки.
// Возвращаемое значение - периметр треугольника.
	public static double perimetr(Point3d obj1, Point3d obj2, Point3d obj3) {
		double a = obj1.distanceTo(obj2);
		double b = obj2.distanceTo(obj3);
		double c = obj3.distanceTo(obj1);
		double per = (a+b+c)/2;
		return per;
	}
// Метод square вычисляет площадь треугольника
// В качестве параметров передаются 3 точки и периметр.
// Возвращаемое значение - площадь треугольника.
	public static double square(double p, Point3d obj1, Point3d obj2, Point3d obj3) {
		return Math.sqrt(p*(p-obj1.distanceTo(obj2))*(p-obj2.distanceTo(obj3))*(p-obj3.distanceTo(obj2)));
	}
}