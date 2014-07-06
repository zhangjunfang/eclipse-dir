package aa.bb;

public class QQ {

	private int b;
	private int a;

	public int getB() {
		System.out.println("``````````````````````");
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getA() {
		System.err.println("==================");
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QQ qq = new QQ();
		qq.setA(10);
		qq.setB(12);
		System.out.println(qq.getA() - qq.getB());
		System.out.println(- qq.getB());

	}

}
