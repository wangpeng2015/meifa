package cpm.spring;

public class test {
	
	public static void main(String[] args) {
		
		test t=new test();
		try{
			Object obj=t.getTest();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
//		System.out.println(obj);
		
		
	}

	
	public Object getTest(){
		
		Object obj=new Object();
		obj=null;
		if(obj==null){
			throw new RuntimeException("fgjhkjhgdsafghjhgf");
		}
		return "1";
	}
}

