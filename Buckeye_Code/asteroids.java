import java.util.*;

// Problem Link:
// Runtime: O()
// Space: O()
public class asteroids {
	
	// Private Static Methods Starts Here
	
    private static class StringLT implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			return o1.compareToIgnoreCase(o2);
		}
	}

    private static class Asteroid{
        int x;
        int y;
        int radius;
        int angle;
        int velocity;
        public Asteroid(int x, int y, int radius, int angle, int velocity){
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.angle = angle;
            this.velocity = velocity;
        }
    }
 
	public static void main(String[] args) {
//		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);

		// Code Starts Here
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int radius = sc.nextInt();
		int angle = sc.nextInt();
		int distance = sc.nextInt();
		
		int n = sc.nextInt();
		ArrayList<Asteroid> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			list.add(new Asteroid(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		// Find the complete path of the ship
		// Find if any asteroid collides with that path
		// If they do, find the time to see if it actually collides
		// Keep them as circles (x2-x1)^2 + (y2-y1)^2 <= (r1+r2)^2
	}
 
}