package testApp;

public class TestString {

	public static void main(String[] args) {
		
		//Test on String Class related concepts and methods
		
		/*
		 * String is a final type Class, therefore, cannot be inherited. 
		 */
		
		String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming"; 
        String s6 = s3 + s4; //The result would be saved in stack, not in the pool
      
        System.out.println(s1 == s2);
        //Expected Result: false. 
        /*Explanation:
         * Both s1 and s1 are reference, created in the stack by JVM
         *s1 is pointed to string "Programming", created in the Runtime Constant Pool in Method Area by JVM. 
         *while s2 is pointed to the String object, created in the heap by JVM. 
         **/
        
        System.out.println(s1 == s5);
        //Expected Result: true.
        /*Explanation:
         * reference s5 will find the reference that point to string "Programming" in the pool.  
         * Thus, both s1 and s5 are pointed to the same constant, "Programming"
         */
       
        System.out.println(s1 == s6);
        //Expected Result: false. 
        //The operation result of "s3 + s4" is saved in stack, not in the pool
       
        
        /*
         * intern() returns a canonical representation for the string object. 
         * A pool of strings, initially empty, is maintained privately by the class String.
         * When the intern method is invoked, if the pool already contains a string equal to 
         * this String object as determined by the equals(Object) method, then the string from the pool is returned. 
         * Otherwise, this String object is added to the pool and a reference to this String object is returned. 
         */
        System.out.println("============Start Testing on intern()============");
        //Expected Result: true
        System.out.println(s1 == s6.intern());
        
        //Expected Result: true
        System.out.println(s1 == s2.intern());
        
        //Expected Result: true
        System.out.println(s5 == s2.intern());
        
        //Expected Result: false
        System.out.println(s2 == s2.intern());
        
        System.out.println("============End of intern() test============");
        
        //Test on String Conversion
        System.out.println("============Start Test on String Conversion============");
        
        //One Convert from primitive type to String.Eg: int
        //Method one,  connect (+) with ""
        int i = 0;
        String st = i + "";
        
        System.out.println("Convert int into string:"+ st);
      
        //Method one, call String valueOf() method
        int j = 1;
        String st2 = String.valueOf(j);
        
        System.out.println("Convert int into string"+ st2);
        
        //One Convert from string into primitive type. 
        //1: use parseXXX in Wrapper class; 2. use valueOf()
  
        String source = "123456";
        Integer target = null;
        int result1 = target.parseInt(source);//automatic unboxing
        
        int result2 = target.valueOf(source);//automatic unboxing
        
        System.out.println("Use int wrapper class:"+result1);
        System.out.println("Use valueOf :"+result2);
        System.out.println("============End of String Conversion test=========");
        
        //Test String, StringBuffer & StringBuilder
  		System.out.println("============Test on StringBuffer & StringBuilder=========");
  		
  		boolean StringModifyResult = false;
  		String ss1 = "Hello";
  		String ss2;
  		StringModifyResult = s1.equals("Hello");	
  		ss2 = ss1.concat(" World");
  		String ss3 = s1 + "Ming";
  		
  		System.out.println(StringModifyResult);
  		System.out.println("ST1:"+ss1);
  		System.out.println("ST2:"+ss2);
  		System.out.println("ST3:"+ss3);
  		System.out.println("============Test String End=========");
  		
  		//Test StringBuffer
  		StringBuffer sbf = new StringBuffer();
  		sbf.append("Hello");
  		sbf.append(" ");
  		sbf.append("World!");
  		
  		System.out.println("StringBuffer:"+sbf);
  		System.out.println("============End of StringBuffer Test=========");
  		
  		//Test StringBuilder
  		StringBuilder sb = new StringBuilder();
  		sb.append("Ming");
  		sb.append(" ");
  		sb.append("Qiu");
  		
  		System.out.println("StringBuilder:"+sb);
  		System.out.println("============End of test on StringBuffer & StringBuilder=========");

  		
 
  		//Demo on Reverse String
        System.out.println("============Demo on String Reversion============");
        String testInput = "HelloWorld";
        
        System.out.print(reverse(testInput));
        
        
	}
	
	//Reverse Stringr
	public  static String reverse(String originStr)
    {
		if(originStr == null || originStr.length() <1)
			return originStr;
		return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
}
