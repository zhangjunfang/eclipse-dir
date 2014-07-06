package aa.bb;

public class Sub extends Parent {

	private  int  member=30;
	
	
	
	@Override
	public void get() {
		super.get();
		System.out.println(member);
	}
	public static void main(String[] args) {
		Sub  sub=new Sub();
		
		Parent parent=sub; 
		sub.get();
		
		parent.get();
		
		System.out.println("sub:---"+System.identityHashCode(sub));
		System.out.println("parent:==="+System.identityHashCode(parent));

	}

}
