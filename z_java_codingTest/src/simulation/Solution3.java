package simulation;

// 문제 3 : 잃어버린 강아지
class Solution3 {
	public int solution(int[][] board){
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int d2 = 0;  //현수 방향
		int d3 = 0;  // 강아지 방향
	    int x2 =0 , y2=0; //현수 초기 위치 변수
	    int x3 =0 , y3=0; //강아지 초기 위치 변수
	    int n = board.length; // 지도 크기
	    
	    // 현수, 강아지 초기 위치 정의
	    for ( int i =0 ; i < n ; i++) {
	    	for (int j =0 ; j < n ; j++) {
	    		//현수 초기 위치 정의
	    		if( board[i][j] == 2 ) {
	    				x2 = i;
	    				y2 = j;
	    		}
	    		if( board[i][j] == 3) {
	    				x3 = i;
	    				y3 = j;
	    		}
	    	}
	    }
	    
	    int count = 0;  // 시간 카운트 변수
	    
	    while ( count < 10000) {
	    	
	    	count++;  // 1분안에 일어난 모든 상황을 책임
	    	
	    	//현수의 위치
	    	int nx2 = x2 + dx[d2];
	    	int ny2 = y2 + dy[d2];
	    	// 강아지 위치
	    	int nx3 = x3 + dx[d3];
	    	int ny3 = y3 + dy[d3];
	    	
	    	int rotate2 = 0;  // 현수가 회전 했는지 안했는지 변수    -> 회전X : 0  , 회전O : 1   => boolean값으로 true/false로 줘도 됨
	    	int rotate3 = 0;  // 강아지가 회전 했는지 안했는지 변수
	    	
	    	//현수 회전 
	    	if (!(nx2 >= 0 && nx2 < n) || !(ny2 >= 0 && ny2 < n)  ||  board[nx2][ny2] == 1 ) {
	    		d2 = (d2+1) % 4;
	    		rotate2 = 1;
	    	}
	    	
	    	// 현수가 회전 안했다면 위치 변경
	    	if ( rotate2 == 0) {
	    	x2 = nx2;
	    	y2 = ny2;
	    	}
	    	
	    	//강아지 회전 
	    	if (!(nx3 >= 0 && nx3 < n) || !(ny3 >= 0 && ny3 < n)  ||  board[nx3][ny3] == 1 ) {
	    		d3 = (d3+1) % 4;
	    		rotate3 =1;
	    	}
	    	
	    	// 강아지가 회전 안했다면 위치 변경
	    	if ( rotate3 == 0) {
	    	x3 = nx3;
	    	y3 = ny3;
	    	}
	    	
	    	if ( x2 == x3 && y2 == y3 ) {
	    		break;
	    	}
	    }
		
		if ( count > 10000 ) {
			return 0;
		}
		return count;		
	}

	public static void main(String[] args){
		Solution3 T = new Solution3();
		int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 1, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 2, 0, 0}, 
			{1, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 3, 0, 0, 0, 1}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 0}}; 
		System.out.println(T.solution(arr1));
		int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 1, 1, 0, 0, 0, 1, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
			{1, 0, 0, 0, 0, 0, 1, 0, 1, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 1, 0, 0, 0, 0, 0, 2, 1}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 1}, 
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 3}}; 
		System.out.println(T.solution(arr2));
	}
}
