import java.util.*;

class rule30 {

	char[][] array;
	int rowLength;

	public rule30(int rowNum, String initialState){
		this.rowLength = rowNum;
		array = new char[rowNum][30 + 2];
		array[0][0] = '0';
		array[0][31] = '0';

		for(int i = 0, j = 1; i < 30; j++, i++){
			array[0][j] = initialState.charAt(i);
		}

		//System.out.println(String.valueOf(array[0]));
	}

	public void generate(){
		for(int i = 0; i < rowLength-1; i++){
			this.array[i][0] = '0';
			this.array[i][31] = '0';
			
			for(int j = 0; j < 30; j ++){
				if((this.array[i][j] == '0' && this.array[i][j+1] == '0' && this.array[i][j+2] == '0') 
					|| (this.array[i][j] == '1' && this.array[i][j+1] == '0' && this.array[i][j+2] == '1') 
					|| (this.array[i][j] == '1' && this.array[i][j+1] == '1' && this.array[i][j+2] == '0') 
					|| (this.array[i][j] == '1' && this.array[i][j+1] == '1' && this.array[i][j+2] == '1'))
				{
					this.array[i+1][j+1] = '0';
				}

				else
				{
					this.array[i+1][j+1] = '1';
				}
			}

			char[] temp = Arrays.copyOfRange(this.array[i], 1, 31);
			//System.out.println(temp.length);
			System.out.println(String.valueOf(temp));
			//System.out.println(String.valueOf(array[i]));
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String initial;

		System.out.print("Input height: ");
		int height = scan.nextInt();
		scan.nextLine();

		do{
			System.out.print("Input initial state (LENGTH SHOULD BE 30): ");
			initial = scan.nextLine();
			//System.out.println(initial.length());
		}while(initial.length() != 30);	//or any value

		rule30 test = new rule30(height, initial);

		test.generate();
	} 	
}