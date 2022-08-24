import java.util.*;

// Problem Link:
// Runtime: O()
// Space: O()
public class packman {
	
	// Public Static Variables
	
	// Private Static Methods Starts Here
	
    private static class StringLT implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			return o1.compareToIgnoreCase(o2);
		}
	}

    private static class Box{
        int width;
        int height;
        public Box(int width, int height){
            this.width = width;
            this.height = height;
        }
    }
 
	public static void main(String[] args) {
//		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);

		// Code Starts Here
		int n = sc.nextInt();
		ArrayList<Box> list = new ArrayList<>();
		Box bigWidth = new Box(0, 0);
		Box bigHeight = new Box(0, 0);
		for(int i = 0; i < n; i++) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			list.add(new Box(w, h));
			if(w > bigWidth.width || (w == bigWidth.width && h > bigWidth.height)) {
				bigWidth = new Box(w, h);
			}
			if(h > bigHeight.height || (h == bigHeight.width && w > bigHeight.height)) {
				bigHeight = new Box(w, h);
			}
		}
		for(Box box : list) {
			if((box.width < bigWidth.width && box.height < bigWidth.height)) {
				
			}
		}
		
	}
 
}