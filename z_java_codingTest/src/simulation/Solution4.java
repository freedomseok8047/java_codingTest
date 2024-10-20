package simulation;

//문제4 : 좌석번호
import java.util.*;
class Solution4 {
	public int[] solution(int c, int r, int k){
		int[] answer = new int[2];
		
		// k가 c*r 보다 클때 {0,0} 리턴
		if( c * r < k ) return new int[] {0,0};
		
		// 방향 d 와 dx, dy
		int d =0;
		int[] dx = { 0, 1, 0, -1};
		int[] dy = { 1, 0, -1, 0};
		
		// 초기 x, y 값 나중에 +1 해줘야함
		int x = 0 , y = 0 ;
		
		// 좌석순서
		int[][] seatOrder = new int[c][r];
		
		for ( int i = 1; i <= c*r ; i++) {
			
			seatOrder[x][y] =i;
			
			if ( i== k ) break;
			
			// 다음 스텝의 x,y 값
			int nextX = x + dx[d];
			int nextY = y + dy[d];
						
			if( nextX < 0 || nextX >= c  || nextY < 0 || nextY >= r || seatOrder[nextX][nextY] > 0) {
				d = (d+1) % 4;
				// 만약 방향전환이 일어났다면 다음 스텝은 
				// 바뀐 회전 변수로 다시 입력
				nextX = x + dx[d];
				nextY = y + dy[d];
			}
			
			x = nextX;
			y = nextY;
			
		}
		// 좌표가 0,0 부터 시작했으니 각각 +1
		answer[0] = x+1;
		answer[1] = y+1;
		return answer;
	}

	public static void main(String[] args){
		Solution4 T = new Solution4();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));	
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}
////문제4 : 좌석번호
//import java.util.*;
//class Solution4 {
//	public int[] solution(int c, int r, int k){
//		int[] answer = new int[2];
//		
//		// k가 c*r 보다 클때 {0,0} 리턴
//		if( c * r < k ) return new int[] {0,0};
//		
//		// 방향 d 와 dx, dy
//		int d =0;
//		int[] dx = { 0, 1, 0, -1};
//		int[] dy = { 1, 0, -1, 0};
//		
//		// 초기 x, y 값 나중에 +1 해줘야함
//		int x = 0 , y = 0 ;
//		int nextX = 0;
//		int nextY = 0;
//		
//		// 좌석순서
//		int[][] seatOrder = new int[c][r];
//		
//		for ( int i = 1; i <= c*r ; i++) {
//			
//			seatOrder[nextX][nextY] =i;
//			
//			if ( i== k ) break;
//			
//			// 다음 스텝의 x,y 값
//			nextX = x + dx[d];
//			nextY = y + dy[d];
//						
//			if( nextX < 0 || nextX >= c  || nextY < 0 || nextY >= r || seatOrder[nextX][nextY] > 0) {
//				d = (d+1) % 4;
//				// 만약 방향전환이 일어났다면 다음 스텝은 
//				// 바뀐 회전 변수로 다시 입력
//				nextX = x + dx[d];
//				nextY = y + dy[d];
//			}
//			
//			// 이게 쌉중요!!
//			x = nextX;
//			y = nextY;
//			
//		}
//		// 좌표가 0,0 부터 시작했으니 각각 +1
//		answer[0] = nextX+1;
//		answer[1] = nextY+1;
//		return answer;
//	}
//
//	public static void main(String[] args){
//		Solution4 T = new Solution4();
//		System.out.println(Arrays.toString(T.solution(6, 5, 12)));	
//		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
//		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
//		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
//	}
//}
