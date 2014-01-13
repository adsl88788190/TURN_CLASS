import java.io.*;
import java.util.*;
 public class Demo {
  public static void main(String[] args) {
		TURN tr = new TURN();
		int a=1000020;
		
		/*计锣糶	a惠锣传计*/
		String test = tr.NumToString(a);
		System.out.println(test);
		/**/
		test = tr.numtoEng_main(a);
		System.out.println(test);
  }
}




class TURN{
	String NumString="";
	int count;
	
	public String NumToString(int number){
		int[] num=new int[10];
		
		String[] Bignum={"箂","滁","禠","把","竩","ヮ","嘲","琺","","╤"};
		String[] numtype={"珺","ㄕ","","窾","珺","ㄕ",""};
		for(count=0;number>0;number/=10,count++)
			num[count]=number%10;
		
		count--;
		
		for(;count>=0;count--){
			if(num[count] != 0){
				//System.out.print(Bignum[num[count]]);
				NumString += Bignum[num[count]];
				if(count>0){
					//System.out.print(numtype[count-1]);
					NumString += numtype[count-1];
				}
			}else if(num[count]==0 && count>0){
				if(count == 3)
						NumString += numtype[3];
				if(num[count-1] != 0){
				//	System.out.print(Bignum[num[count]]);
					NumString += Bignum[num[count]];
				}
			}
				
		}			
		return NumString;
	}
	
		
	public String numtoEng_main(int number){
			int checknum=0;
			NumString ="";
			String[] type = {"thousand","million","billion","trillion"}; 
			for(;number>0;number/=1000,checknum++){
				if(checknum > 0 && number%1000>0)
					NumString = numtoEng(number%1000)+" "+type[checknum-1]+" "+NumString;
				else if(number%1000>0)
					NumString = numtoEng(number%1000)+NumString;
			}
			return NumString;
	}
	
	public static String numtoEng(int number){/*璽砫矪瞶 –场だ*/
		String[] numEng={"and","one","two","three","four","five","six","seven","eight","nine"};
		String[] numEng2={"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen", "nineteenth"};
		String[] numEng3={"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
		String   numEng4="hundred";
		String re="";
		int[] num=new int[3];
		for(int count=0;count <3 ;count++,number/=10){
				num[count]=number%10;
		}
		/*κ*/
		if(num[2]!=0){
			re += numEng[num[2]]+" "+numEng4;
			if(num[1]!=0 || num[0]!=0)
				re += " and ";
		}
		/*の*/
		if(num[1]<2){
			if(num[2]!=0 && (num[1]+num[2]==0))
				re += "";
			else if(num[1]==0 )
				re += numEng[num[0]];
			else 
				re += numEng2[num[0]];
	
		}
		else{
			re += numEng3[num[1]-2]+" ";
			if(num[0]>0)
				re +=numEng[num[0]];
		}
		return re;
	}
}
