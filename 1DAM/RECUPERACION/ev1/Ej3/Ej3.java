
public class Ej3 {
	
	public static void main (String[] args) {
		int max=0;
		int min=100;
		
		int a=44;
		int g=19;
		int l=10;
		int e=17;
		int n=20;
		int vec[]=new int[5];
		vec[0]=a;
		vec[1]=g;
		vec[2]=l;
		vec[3]=n;
		vec[4]=e;
		for (int i = 0; i < vec.length-1; i++)
		{
			if (max<vec[i])
				max=vec[i];
				
			if(min>vec[i])
				min=vec[i];
		}
		System.out.println("a="+a+" g="+g+" l="+l+" e="+e+" n="+n);
		System.out.println("maximo: "+max+"\nminimo: "+min);
		
		
	}
}

