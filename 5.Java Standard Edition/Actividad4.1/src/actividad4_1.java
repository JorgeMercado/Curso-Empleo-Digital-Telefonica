import java.util.Random;

public class actividad4_1 {

	public static void main(String[] args) {
		Random rand = new Random(System.currentTimeMillis());
		
		int array[];
		array = new int[6];
		
		for(int i = 0; i < 6; i++){
			int numGen = rand.nextInt(49) + 1;
			array[i] = numGen;
		}
		
		for(int j:array){
			System.out.println(j);
		}
	}
}
