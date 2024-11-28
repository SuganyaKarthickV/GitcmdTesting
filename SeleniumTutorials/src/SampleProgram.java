

public class SampleProgram {

	String name;
	int rollNo;
	name="suganya";
	
	public void getdetail()
	{
		System.out.println("Enter the name:"+ name);
		System.out.println("Rollno:"+ rollNo);
	}
	public static void main(String[] args) {
		SampleProgram s= new SampleProgram();
		s.getdetail();
	}

}
