import java.lang.reflect.Array;

public class ReflArr {
	
	public ReflArr(){
		
	}
	
	public static Object createSoloArr(int num, Class type) throws ClassNotFoundException{
	 Object arr = Array.newInstance(type, num);
	 return arr;
	}
	
	public static Object createMatrix(Class type, int... width) throws ClassNotFoundException{
		Object arr = Array.newInstance(type, width);
		return arr;
	}
	
	public static void setArr(int value, int pos, Object arr){
		Array.set(arr, pos, value);
	}
	
	public static Object getArr(int pos, Object arr){
		return Array.get(arr, pos);
	}
	
	public static Object ArrChange(Object arr, int num, Class type){
		Object NewArr = Array.newInstance(type, num);
		System.arraycopy(arr, 0, NewArr, 0, Array.getLength(arr));
		return NewArr;
	}
	
	public static Object ChangeMatrix(Object arr, int length, int height, Class type){
		Object NewArr = Array.newInstance(type, length, height);
		int count = Array.getLength(arr);
			while(!(count == 1)){
				int count2 = Array.getLength(getArr(Array.getLength(arr) - count,arr));
				Object NewArr2 = Array.newInstance(type, count2);
				System.arraycopy(getArr(Array.getLength(arr) - count, arr), 0, NewArr2,0, Array.getLength(arr));
				Array.set(NewArr,Array.getLength(arr) - count, NewArr2);
				count--;
			}
			return NewArr;
	}
	
	public static String ArrtoString(Object arr){
		int count = Array.getLength(arr);
		String s = null;
		System.out.print(arr.getClass().getTypeName() + " ");
		while(!(count == 0)){
			s = s + getArr(Array.getLength(arr)-count, arr).toString() + ", ";
			count--;
		}
		return s;	
	}
	
	public static String MatrixtoString(Object arr){
		int count2 = Array.getLength(arr);
		String s = null;
		System.out.print(arr.getClass().getTypeName() + " ");
		
		for(int i = 0;i<count2; i++){
			if (s == null)
				s = "{";
			else
			s = s + "{";
		int count = Array.getLength(Array.get(arr, Array.getLength(arr) - count2));
		while(!(count == 0)){
			s = s + getArr(Array.getLength(Array.get(arr, i))-count, Array.get(arr, i)).toString() + ", ";
			count--;
		}//while
		s = s + "}";
		}//for
		return s;	
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException{
		Object arr = createMatrix(int.class,3,5);
		setArr(2,1,Array.get(arr, 1));
		System.out.print("{" + MatrixtoString(arr) + "}\n");
		arr = ChangeMatrix(arr,4,8,int.class);
		System.out.println("{" + MatrixtoString(arr) + "}");
	}
}
