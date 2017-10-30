
//此文件跟项目无关，只是用来决定一些纠结的事情
public class demo {

	public static void main(String[] args) {
		int c=0;
		int d=0;
		for (int i = 0; i < 100000; i++) {
			System.out.println("随机的选择是：");

			int a = (int) (Math.random() * 10);

			if (a % 2 == 0) {
				System.out.println("去干");
				c++;
			} else {
				System.out.println("不去");
				d++;
			}
			System.out.println(a);
		}
		System.out.println(c+"/"+d);
	}
}
