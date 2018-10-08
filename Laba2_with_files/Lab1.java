import java.util.Scanner;
import java.io.*;
// Класс Lab1,содержащий методы для ввода координат, проверки различия координат 
// трех точек, вычисления периметра и площади треугольника.
public class Lab1{
// Основной метод main в котором осуществляется ввод координат,
// проверяется различие координат трех точек и в зависимости от
// результата проверки выводится площадь треугольника или сообщением о том,
// что есть точки с одинаковыми координатами.
	public static void main(String args[]) throws Exception {
		Double[] ar = readF();
		System.out.println("Enter x1,y1,z1");
		Point3d object1 = new Point3d(ar[0],ar[1],ar[2]);
		System.out.println("Enter x2,y2,z2");
		Point3d object2 = new Point3d(ar[3],ar[4],ar[5]);
		System.out.println("Enter x3,y3,z3");
		Point3d object3 = new Point3d(ar[6],ar[7],ar[8]);
		if (checkCoords(object1, object2, object3)) {
			double p = perimetr(object1,object2,object3);
			System.out.println(square(p,object1, object2, object3));
		}
		else 
			System.out.println("Coords eq");
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
		double s = Math.sqrt(p*(p-obj1.distanceTo(obj2))*(p-obj2.distanceTo(obj3))*(p-obj3.distanceTo(obj2)));
		String str = Double.toString(s);
		writeF(str);
		return s;
	}
// Метод readF осуществляет считывание координат из файла.
// Возвращаемое значение - массив, содержащий координаты 3-х точек.
	public static Double[] readF() {
		Double[] crds = new Double[9];
		int i = 0;
		try(FileReader rd = new FileReader("Coords.txt"))
		{
			Scanner in = new Scanner(rd);
			BufferedReader rader = null;
			while (in.hasNextLine()) {
				crds[i] = new Double(in.nextLine());
				i++;
			}
			rd.close();
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		return crds;
	}
// Метод writeF осуществляет запись строки (передается в качестве параметра) в файл
	public static void writeF(String result) {
		try(FileWriter wr = new FileWriter("CoordsResult.txt"))
		{
			wr.write("Square= " + result);
			wr.close();
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	} 
}