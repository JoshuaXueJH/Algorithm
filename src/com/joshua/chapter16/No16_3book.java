package com.joshua.chapter16;

public class No16_3book {
	public static void main(String[] args) {
		Point result = intersection(new No16_3book().new Point(1, 2), new No16_3book().new Point(2, 4),
				new No16_3book().new Point(2, 4), new No16_3book().new Point(4, 8));
		System.out.println("(" + result.x + "," + result.y + ")");
	}

	public static Point intersection(Point start1, Point end1, Point start2, Point end2) {
		if (start1.x > end1.x)
			swap(start1, end1);
		if (start2.x > end2.x)
			swap(start2, end2);
		if (start1.x > start2.x) {
			swap(start1, start2);
			swap(end1, end2);
		}

		Line line1 = new No16_3book().new Line(start1, end1);
		Line line2 = new No16_3book().new Line(start2, end2);

		if (line1.slope == line2.slope) {
			if (line1.yintercept == line2.yintercept && isBetween(start1, start2, end1)) {
				return start2;
			}
			return null;
		}

		double x = (line2.yintercept - line1.yintercept) / (line1.slope - line2.slope);
		double y = x * line1.slope + line1.yintercept;
		Point intersection = new No16_3book().new Point(x, y);

		if (isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)) {
			return intersection;
		}
		return null;
	}

	public static boolean isBetween(Point start, Point middle, Point end) {
		return isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y);
	}

	public static boolean isBetween(double start, double middle, double end) {
		if (start > end) {
			return end <= middle && middle <= start;
		} else {
			return start <= middle && middle <= end;
		}
	}

	public static void swap(Point one, Point two) {
		double x = one.x;
		double y = one.y;
		one.setLocation(two.x, two.y);
		two.setLocation(x, y);
	}

	public class Line {
		public double slope, yintercept;

		public Line(Point start, Point end) {
			double deltaX = end.x - start.x;
			double deltaY = end.y - start.y;
			slope = deltaY / deltaX;
			yintercept = end.y - end.x * slope;
		}
	}

	public class Point {
		public double x, y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public void setLocation(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

}
