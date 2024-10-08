package simulation;

import java.util.*;
			class Solution2 {
				public int[] solution(int[][] board, int k){
					int[] answer = new int[2]; 
					int x = 0 ;
					int y = 0 ;
					int count = 0 ;
					
					int[] dx = { 0, 1, 0, -1 };	
					int[] dy = { 1, 0, -1, 0 };
					int d = 0 ;							 // 방향  0: 3시 , 1: 6시 , 2: 9시 , 3: 12시 
					int n = board.length;			// 격자 밖의 기준
					
					while(count < k ) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						count++;
						
						if ( !(nx >= 0 && nx < n) || !(ny >= 0 && ny < n)  ||  board[nx][ny] == 1 ) {
							d = (d+1) % 4;
							continue;
//							count++;      오류 : 위에서 이미 count++을 실행 했기 때문에 방향이 바뀔때 count가 2가 증가 됨  
						}
						x = nx ;
						y = ny ;
					}
					
					answer[0] = x ;
					answer[1] = y ;
					
					return answer;
				}

				public static void main(String[] args){
					Solution2 T = new Solution2();
					int[][] arr1 = {{0, 0, 0, 0, 0}, 
						{0, 1, 1, 0, 0}, 
						{0, 0, 0, 0, 0}, 
						{1, 0, 1, 0, 1}, 
						{0, 0, 0, 0, 0}};
					System.out.println(Arrays.toString(T.solution(arr1, 10)));
					int[][] arr2 = {{0, 0, 0, 1, 0, 1}, 
						{0, 0, 0, 0, 0, 0}, 
						{0, 0, 0, 0, 0, 1}, 
						{1, 1, 0, 0, 1, 0}, 
						{0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0}};
					System.out.println(Arrays.toString(T.solution(arr2, 20)));
					int[][] arr3 = {{0, 0, 1, 0, 0}, 
						{0, 1, 0, 0, 0}, 
						{0, 0, 0, 0, 0}, 
						{1, 0, 0, 0, 1}, 
						{0, 0, 0, 0, 0}};
					System.out.println(Arrays.toString(T.solution(arr3, 25)));
					
				}
}
			
			
			// 내가 생각한 로직이 맞으려면 count++ 위치가 달라져야 함 
//		    public int[] solution(int[][] board, int k){
//		        int[] answer = new int[2]; 
//		        int x = 0 ;
//		        int y = 0 ;
//		        int count = 0 ;
//		        
//		        // 이동 방향 설정: { 3시, 6시, 9시, 12시 }
//		        int[] dx = { 0, 1, 0, -1 };	
//		        int[] dy = { 1, 0, -1, 0 };
//		        int d = 0 ;  // 방향: 0 (3시), 1 (6시), 2 (9시), 3 (12시)
//		        int n = board.length;  // 격자판의 크기
//		        
//		        while(count < k ) {
//		            // 이동하려는 다음 좌표
//		            int nx = x + dx[d];
//		            int ny = y + dy[d];
//		            
//		            // 벽을 만나거나, 장애물(1)을 만나는 경우
//		            if (!(nx >= 0 && nx < n) || !(ny >= 0 && ny < n) || board[nx][ny] == 1) {
//		                // 방향 전환 (시계 방향으로 90도 회전)
//		                d = (d + 1) % 4;
//		                count++;  // 회전에도 1초가 소요됨
//		                continue;  // 이동하지 않고 방향만 바꾸고 다음 반복으로 이동
//		            }
//		            
//		            // 유효한 위치로 이동
//		            x = nx;
//		            y = ny;
//		            count++;  // 이동에 1초 소요
//		        }
//		        
//		        answer[0] = x ;
//		        answer[1] = y ;
//		        
//		        return answer;
//		    }