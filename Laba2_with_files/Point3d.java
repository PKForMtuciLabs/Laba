// Класс Point3d, содержащий методы для взаимодействия с координатами, указанными в полях.

public class Point3d {
	private double xCoord;
	private double yCoord;
	private double zCoord;
// Конструктор для инициализации полей (координат)
	public Point3d(double x, double y, double z) {
		xCoord = x;
		yCoord = y;
		zCoord = z;
	}
// Конструктор для инициализации полей (когда нужно поставить точку в начало координат)
	public Point3d() {
		this(0.0,0.0,0.0);
	}
// Метод getX возвращает координату точки по оси x.
	public double getX() {
		return xCoord;
	}
// Метод getY возвращает координату точки по оси y.
	public double getY() {
		return yCoord;
	}
// Метод getZ возвращает координату точки по оси z.
	public double getZ() {
		return zCoord;
	}
// Метод setX задает координату точки по оси x.
	public void setX(double val) {
		xCoord = val;
	}
// Метод setX задает координату точки по оси y.
	public void setY(double val) {
		yCoord = val;
	} 
// Метод setZ задает координату точки по оси z.
	public void setZ(double val) {
		zCoord = val;
	}
// Метод distanceTo вычисляет расстояние между двумя точками (указатель this ссылается на первую точку, вторая
// точка передается в качестве параметра).
	public double distanceTo(Point3d obj) {
		return Math.sqrt(Math.pow((this.xCoord-obj.xCoord),2) + Math.pow((this.yCoord-obj.yCoord),2) + Math.pow((this.zCoord-obj.zCoord),2));
	}
// Метод equalsCoords проверяет имеют ли 2 точки одинаковые координаты.
	public boolean equalsCoords(Point3d obj) {
		if ((this.xCoord == obj.xCoord) && (this.yCoord == obj.yCoord) && (this.zCoord == obj.zCoord))
			return true;
		else
			return false;
	}

}