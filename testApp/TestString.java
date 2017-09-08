//package testApp;
//
//public class TestString {
//
//	public static void main(String[] args) {
//		
//		String s1 = "Programming";
//        String s2 = new String("Programming");
//        String s3 = "Program";
//        String s4 = "ming";
//        String s5 = "Program" + "ming";
//        String s6 = s3 + s4;
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s5);
//        System.out.println(s1 == s6);
//        System.out.println(s1 == s6.intern());
//        System.out.println(s2 == s2.intern());
//        
//      //Test String, StringBuffer & StringBuilder
//  		System.out.println("============Test Starting=========");
//  		boolean StringModifyResult = false;
//  		String st1 = "Hello";
//  		String st2;
//  		StringModifyResult = st1.equals("Hello");	
//  		st2 = st1.concat(" World");
//  		
//  		String st3 = st1 + "Ming";
//  		
//  		System.out.println(StringModifyResult);
//  		System.out.println("ST1:"+st1);
//  		System.out.println("ST2:"+st2);
//  		System.out.println("ST3:"+st3);
//  		System.out.println("============Test String End=========");
//  		
//  		//Test StringBuffer
//  		StringBuffer sBuff = new StringBuffer();
//  		sBuff.append("Hello");
//  		sBuff.append(" ");
//  		sBuff.append("World!");
//  		System.out.println("sBuff:"+sBuff);
//  		System.out.println("============Test StringBuffer End=========");
//  		
//  		//Test StringBuilder
//  		StringBuilder sb = new StringBuilder();
//  		sb.append("Ming");
//  		sb.append(" ");
//  		sb.append("Qiu");
//  		System.out.println("StringBuilder:"+sb);
//  		System.out.println("============Test StringBuilder End=========");
//  		
//  		System.out.println("============End of Test=========");
//  		
//	}
//
//}
